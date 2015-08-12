package com.random.game.slingshot;

import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Missile extends Particule {
	private Color trail_color;
	private int score;
	private Texture image;
	private Rectangle rect;
	private Sprite trail_screen;
	
	public Missile(Settings set, Pos pos, Pos impact_pos, int size, Sprite trail_screen) {
		super(set, pos, impact_pos, size);
		image = new Texture("data/shot.png");
		rect = this.getBoundingRectangle();
		this.trail_screen = trail_screen;
		last_pos = new Pos(0,0);
	}
	
	public void launch(Player player){
		flight = Settings.MAX_FLIGHT;
		pos = player.get_launchpoint();
		speed = player.get_power();
		angle = (int) Utils.radians(player.get_angle());
		v = new Pos(0.1 * speed * Math.sin(angle), -0.1 * speed * Math.cos(angle));
		trail_color = player.get_color();
		score = -Settings.PENALTY_FACTOR * speed;
	}
	
	public int update_players(List<Player> players){
		int result = 1;
		
		Pos pos = new Pos(0,0);
		for (int i=0; i<10; i++) {
			pos.up(last_pos.x + i * 0.1 * v.x, last_pos.y + i * 0.1 * v.y);
			if (players.get(1).hit(pos)){
				result = 0;
			}
			if (players.get(2).hit(pos)) {
				result = 0;
			}
			if (result == 0) {
				impact_pos = pos;
				this.pos = pos;
				break;
			}
		}
		return result;	
	}
			
	public void draw_status(Sprite screen){
		//txt = Settings.font.render("Power penalty: %d" %(-self.score), 1, (255,255,255));
		//rect = txt.get_rect();
		Pos midtop = new Pos(399, 5);
		//screen.blit(txt, rect.topleft);
		/*
		if (flight >= 0) {
			txt = Settings.font.render("Timeout in %d" %(self.flight), 1,(255,255,255));
		}
		else {
			txt = Settings.font.render("Shot timed out...", 1, (255,255,255));
		}
		rect = txt.get_rect();
		Pos midbottom = new Pos(399, 594);
		screen.blit(txt, rect.topleft);
		*/
	}
		
		
	public int update(List<Planete> planets,List<Player> players){
		int result = super.update(planets);
		result = result * update_players(players);
		//pygame.draw.aaline(self.trail_screen, self.trail_color, self.last_pos, self.pos);
		return result;
	}
		
	public Texture get_image(){
		return image;
	}
	
	public int get_score(){
		return score;
	}
}
