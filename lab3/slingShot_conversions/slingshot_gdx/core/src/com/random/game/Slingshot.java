package com.random.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class Slingshot extends ApplicationAdapter implements InputProcessor {

	private SpriteBatch batch;
	private Texture backgroud;
	private BitmapFont font;

	private Sprite red_ship_sprite;
	private Sprite blue_ship_sprite;

	private Sprite missile_sprite;

	private int current_player = 1;
	private boolean missile_lauch;

	private float missile_position_X;
	private float missile_position_Y;
	private float missile_direction_X;
	private float missile_direction_Y;

	private Pixmap missile_red_ship_trace, missile_blue_ship_trace;
	private int bounce;
	private Sprite missile_red_ship_trace_sprite;
	private Sprite missile_blue_ship_trace_sprite;

	@Override
	public void create() {
		batch = new SpriteBatch();

		Gdx.input.setInputProcessor(this);

		/***********************************
		 * basic
		 ***********************************/

		backgroud = new Texture("backdrop.png");
		// texture = new Texture(Gdx.files.internal("data/jet.png"));
		// sprite = new Sprite(img)

		// jet_sprite = new Sprite(img2);

		red_ship_sprite = new Sprite(new Texture("red_ship.png"));
		blue_ship_sprite = new Sprite(new Texture("blue_ship.png"));

		red_ship_sprite.setScale(0.8f);
		blue_ship_sprite.setScale(0.8f);

		red_ship_sprite.setPosition(10, Gdx.graphics.getHeight() / 2
				- red_ship_sprite.getHeight() / 2);
		blue_ship_sprite.setPosition(
				Gdx.graphics.getWidth() - blue_ship_sprite.getWidth() - 10,
				Gdx.graphics.getHeight() / 2 - red_ship_sprite.getHeight() / 2);

		missile_sprite = new Sprite(new Texture("shot.png"));

		missile_red_ship_trace = new Pixmap(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),Format.RGBA8888);
		missile_blue_ship_trace = new Pixmap(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),Format.RGBA8888);
		
		
		missile_red_ship_trace_sprite = new Sprite(new Texture(missile_red_ship_trace));
		missile_blue_ship_trace_sprite = new Sprite(new Texture(missile_blue_ship_trace));
	}

	@Override
	public void render() {

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// select player ship
		Sprite ship_sprite = this.current_player == 1 ? red_ship_sprite
				: blue_ship_sprite;

		// if(Gdx.input.isKeyPressed(Input.Keys.W)){
		// ship_sprite.translateX(5);
		// }
		// if(Gdx.input.isKeyPressed(Input.Keys.S)){
		// ship_sprite.translateX(-5);
		// }

		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			ship_sprite.rotate(5);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			ship_sprite.rotate(-5);
		}

		batch.begin();

		// draw background
		batch.draw(backgroud, 0, 0);

		// draw sprite

		update_missile(batch);

		red_ship_sprite.draw(batch);
		blue_ship_sprite.draw(batch);

		batch.end();

		// switch players
		if (Gdx.input.isKeyPressed(Input.Keys.TAB)) {
			this.current_player = this.current_player == 1 ? 2 : 1;
		}

		try {

			Thread.sleep((long) (1000 / 50 - Gdx.graphics.getDeltaTime()));

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void update_missile(SpriteBatch batch) {
		if (missile_lauch) {

			float new_missile_position_X = missile_position_X + missile_direction_X * 10;
			float new_missile_position_Y = missile_position_Y + missile_direction_Y * 10;

			//on le fait avant pour pas overlap la particule
			drawMissileTrace(new_missile_position_X, new_missile_position_Y,missile_position_X, missile_position_Y);
			missile_sprite.setPosition(new_missile_position_X, new_missile_position_Y);
			missile_sprite.draw(batch);

			
			// preparation pour prochain tick
			missile_position_X = new_missile_position_X;
			missile_position_Y = new_missile_position_Y;
			
			if (missile_position_X <= 0
					|| missile_position_X + missile_sprite.getWidth() >= Gdx.graphics.getWidth())
			{
				missile_direction_X *= -1;
				bounce -= 1;
			}
			if (missile_position_Y <= 0
					|| missile_position_Y + missile_sprite.getHeight() >= Gdx.graphics.getHeight())
			{
				missile_direction_Y *= -1;
				bounce -= 1;
			}
			
			if(bounce == 0){
				missile_lauch = false;
			}
		}
		
		missile_red_ship_trace_sprite.draw(batch);
		missile_blue_ship_trace_sprite.draw(batch);
		
		
	}

	private void drawMissileTrace(
			float new_missile_position_X,float new_missile_position_Y, 
			float old_missile_position_X,float old_missile_position_Y) 
	{
		
		
		Pixmap missileTrace = this.current_player == 1 ? missile_red_ship_trace	: missile_blue_ship_trace;
		missileTrace.setColor(this.current_player == 1 ? Color.RED : Color.CYAN);
		missileTrace.drawLine((int)new_missile_position_X, Gdx.graphics.getHeight()-(int)new_missile_position_Y, (int)old_missile_position_X, Gdx.graphics.getHeight()-(int)old_missile_position_Y);

	}
	

	private void launch_missile() {
		missile_lauch = true;
		
		bounce = 3;

	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		missile_position_X = (float) (Math.random() * Gdx.graphics.getWidth()); // (ship_sprite.getOriginY()
																				// -
																				// ship_sprite.getWidth()/2
																				// )
																				// *
																				// (float)Math.tan(angle);
		missile_position_Y = (float) (Math.random() * Gdx.graphics.getHeight()); // (ship_sprite.getOriginX()
																					// -
																					// ship_sprite.getHeight()/2
																					// )
																					// *
																					// (float)Math.tan(angle);

		missile_direction_X = (float) (Math.random() * 100 + 2); // (ship_sprite.getOriginY()
																	// -
																	// ship_sprite.getWidth()/2
																	// ) *
																	// (float)Math.tan(angle);
		missile_direction_Y = (float) (Math.random() * 100 * 2); // (ship_sprite.getOriginX()
																	// -
																	// ship_sprite.getHeight()/2
																	// ) *
																	// (float)Math.tan(angle);
		float missile_direction_norme = (float) Math.sqrt(Math.pow(
				missile_direction_X, 2) + Math.pow(missile_direction_Y, 2));
		missile_direction_X = missile_direction_X / missile_direction_norme;
		missile_direction_Y = missile_direction_Y / missile_direction_norme;

		launch_missile();

		return false;

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
