package com.random.game.slingshot;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Particule extends Sprite {
	protected Pos pos;
	protected Pos last_pos;
	protected Pos v;
	protected Pos impact_pos;
	protected int flight;
	protected int speed;
	protected int angle;
	private int size;
	private Rectangle rect;
	private Texture image;
		
	public Particule(Settings set, Pos pos, Pos impact_pos, int size){
		if (size == 5)
			image = set.particle_image5;
		else
			image = set.particle_image10;
		rect = this.getBoundingRectangle();
		//#self.image, self.rect = load_image("explosion-10.png", (0,0,0))
		
		this.pos = pos;
		this.impact_pos = impact_pos;
		this.size = size;
		angle = (int) (Math.random()*359);
		if(size == 5)
			speed = (int) ((Math.random()*(Settings.PARTICLE_5_MAXSPEED-Settings.PARTICLE_5_MINSPEED))+Settings.PARTICLE_5_MINSPEED);
		else
			speed = (int) ((Math.random()*(Settings.PARTICLE_10_MAXSPEED-Settings.PARTICLE_10_MINSPEED))+Settings.PARTICLE_10_MINSPEED);
		v = new Pos(0.1 * speed * Math.sin(angle), -0.1 * speed * Math.cos(angle));
		flight = Settings.MAX_FLIGHT;
	}
	
	public boolean max_flight(){
		if (flight < 0)
			return true;
		else
			return false;
	}
	
	public int update(List<Planete> planets){
		flight--;
		last_pos = pos;
		
		for(Planete p :  planets){
			final Pos p_pos = p.get_pos();
			final double mass = p.get_mass();
			final double d = Math.pow((pos.x - p_pos.x),2) + Math.pow((pos.y - p_pos.y),2);
			final double d_sqrt = Math.sqrt(d);
			final double gm = Settings.g * mass;
			Pos a = new Pos(gm * pos.diffX(p_pos) / (d * d_sqrt ), gm * pos.diffY(p_pos) / (d * d_sqrt ));
			v = v.diff(a);	
		}
		
		pos.up(pos.x + v.x, pos.y + v.y);
		
		if (! in_range()){
			return 0;
		}
		
		for(Planete p :  planets){
			Pos p_pos = p.get_pos();
			final float r = p.get_radius();
			//d = (self.pos[0] - p_pos[0])**2 + (self.pos[1] - p_pos[1])**2
			final double d = Math.pow(pos.diffX(p_pos),2) + Math.pow(( pos.diffY(p_pos)),2);
			if (d <= (r*r) ) {
				impact_pos = Utils.get_intersect(p_pos, r, last_pos, pos);
				pos = impact_pos;
				return 0;
			}
		}
		
		if(Settings.BOUNCE) {
			float d;
			if (pos.x > 799) {
				d = pos.x - last_pos.x;
				pos.up(799, last_pos.y + (pos.y - last_pos.y) * (799 - last_pos.x) / d);
				v.up(-v.x, v.y);
			}
			if (pos.x < 0) {
				d = last_pos.x - pos.x;
				pos.up(0,last_pos.y +  (pos.y - last_pos.y) * last_pos.x / d);
				v.up(-v.x, v.y);
			}
			if (pos.y > 599) {
				d = pos.y - last_pos.y;
				pos.up( last_pos.x + (pos.x - last_pos.x) * (599 - last_pos.y) / d , 599);
				v.up(  v.x , - v.y);
			}
			if (pos.y < 0) {
				d = last_pos.y - pos.y;
				pos.up(last_pos.x + (pos.x - last_pos.x) * last_pos.y / d, 0);
				v.up(v.x, - v.y);
				//#print pos;
				//#print last_pos;
			}
		}
		rect.setCenter(pos.x, pos.y);
		return 1;
	}
	
	public boolean in_range(){
		final Rectangle colrec = new Rectangle(-800, -600, 2400, 1800);	
		if ( colrec.contains(pos.x, pos.y) )
			return true;
		else
			return false;
	}
	
	public boolean visible(){
		final Rectangle colrec = new Rectangle(0, 0, 800, 600);	
		if (colrec.contains(pos.x, pos.y) )
			return true;
		else
			return false;
	}
	
	public Pos get_pos(){
		return pos;
	}
		
	public Pos get_impact_pos(){
		return impact_pos;
	}
		
	public int get_size(){
		return size;
	}
}
