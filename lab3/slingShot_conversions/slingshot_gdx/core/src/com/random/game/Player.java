package com.random.game;

import java.util.Vector;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite {

	private int score, player;
	private int power, attempts, e, exp;
	private boolean shot;
	
	private int angle, orig;
	private Rectangle rect;
	private Texture image;
	
	
	public Player(int n) {
		super();
		player = n;
		init();
		score = 0;
	}
	
	private void init(){
		power = 100;
		shot = false;
		attempts = 0;
		e = 0;
		//self.exp, self.rect = load_image("data/explosion.png", (0,0,0))
		
		if(player == 1) {
			angle = 90;
			self.orig, self.rect = load_image("data/red_ship.png", (0,0,0));
			self.rect = pygame.Rect(0,0,40,33);
			self.rect.midleft = (20,randint(100,500));
			self.color = (209,170,133);
		}
		else if (player == 2) {
			angle = 270;
			self.orig, self.rect = load_image("data/blue_ship.png", (0,0,0));
			self.rect = pygame.Rect(0,0,40,33);
			self.rect.midright = (780,randint(100,500));
			self.color = (132,152,192);
		}
		else {
			self.orig = None;
		}
		
		self.rel_rot = 0.01;
		if (player == 1)
			self.d = self.rect.right - self.rect.centerx + 2;
		else
			self.d = self.rect.centerx - self.rect.left + 3;
		
		if (self.orig != None)
			self.image = self.orig.subsurface(0, 0, 40, 33);
			
		if (Settings.FIXED_POWER)
			power = Settings.POWER;
	}
	
	public void reset_score(){
		score = 0;
	}		
		
	public void add_score(int score){
		this.score += score;
	}
	
	public void get_color(){
		return self.color;
	}

	/*
	def change_angle(self, a){
		self.angle += a
		self.rel_rot += a
		if self.angle >= 360:
			self.angle -= 360
		if self.angle < 0:
			self.angle += 360
		if self.rel_rot >= 360:
			self.rel_rot -= 360
		if self.rel_rot < 0:
			self.rel_rot += 360
#		if Settings.ROTATE:
#			center = self.rect.center
#			self.image = pygame.transform.rotate(self.orig, -self.rel_rot)
#			self.image = self.image.convert_alpha()
#			self.rect = self.image.get_rect(center = center)
		
		center = self.rect.center
		#print "center0: (%d,%d)" %(self.rect.center[0], self.rect.center[1])
		
		img1 = round((self.rel_rot + 22.5) / 45 - 0.49) % 8
		img2 = round(self.rel_rot / 45 - 0.49) % 8
		if img1 == img2 or img1 == -img2:
			img2 = (img2 + 1) % 8
			f = (self.rel_rot - img1 * 45.0) / 45.0
		else:
			f = ((img2 + 1) * 45.0 - self.rel_rot) / 45.0
				
		rect1 = pygame.Rect(img1 * 40, 0, 40, 33)
		rect2 = pygame.Rect(img2 * 40, 0, 40, 33)
		image1 = self.orig.subsurface(rect1)
		image2 = self.orig.subsurface(rect2)
		image1 = image1.convert_alpha()
		image2 = image2.convert_alpha()
		
		tmp = pygame.Surface((40, 33))
		tmp = tmp.convert_alpha()
		tmp.blit(image2, (0,0))
		tmp = tmp.convert()
		tmp.set_alpha(round(255.0 * f))
		tmp.set_colorkey((0,0,0))
		tmp = tmp.convert_alpha()
		
		image1.blit(tmp,(0,0))
		
#		self.image = pygame.transform.rotate(image1, -self.rel_rot)
		self.image = pygame.transform.rotozoom(image1, -self.rel_rot, 1.0)
		self.rect = self.image.get_rect()
		#print "center1: (%d,%d)" %(self.rect.center[0], self.rect.center[1])
		self.rect.center = center
		#print "center2: (%d,%d)" %(self.rect.center[0], self.rect.center[1])
		}
	*/
	
	public void change_power(int p){
		if (! Settings.FIXED_POWER){
			power += p;
			if (power < 0)
				power = 0;
			if (power > Settings.MAXPOWER)
				power = Settings.MAXPOWER;
		}
	}
			
	public int get_angle(){
		return angle;
	}
	
	public int get_power(){
		return power;
	}
	
	
	public Pos get_launchpoint(){
		if (Settings.ROTATE) {
			Vector2 c = new Vector2();
			rect.getPosition(c);
			//WIP lighta
			return (c.x + self.d * Math.sin( Utils.radians( angle)), c.y - self.d * Math.cos( Utils.radians( angle)));
		}
		else{
			if ( player == 1){
				return (self.rect.midright[0] + 1, self.rect.midright[1]);
			}
			if ( player == 2){
				return (self.rect.midleft[0] - 1, self.rect.midleft[1]);
			}
		}
	}
			
	public void draw_info(screen){
		txt = Settings.font.render("Angle: %3.2f" %(self.angle), 1, (255,255,255));
		rect = txt.get_rect();
		rect.topleft = (290, 5);
		screen.blit(txt, rect.topleft);
		
		txt = Settings.font.render("Power: %3.1f" %(self.power), 1, (255,255,255));
		rect = txt.get_rect();
		rect.topleft = (403, 5);
		screen.blit(txt, rect.topleft);
	}
		
	public void draw_status(screen){
		if (self.player == 1) {
			txt = Settings.font.render("Player 1  --  %d" %(self.score), 1, self.color);
			rect = txt.get_rect();
			rect.topleft = (5,5);
		}
		else {
			txt = Settings.font.render("%d  --  Player 2" %(self.score), 1, self.color);
			rect = txt.get_rect();
			rect.topright = (794,5);
		}
		screen.blit(txt, rect.topleft);
	}
		
	public void update_explosion(){
		e++;
		s = e * (6 - e) * 100 / 9;
		if (s >= 0) {
			self.image = pygame.transform.scale(self.exp, (s,s));
			pos = self.rect.center;
			self.rect = self.image.get_rect();
			self.rect.center = pos;
		}
	}
			
	public void draw_line(screen){
		Pos ps = get_launchpoint();
		pygame.draw.aaline(screen, self.color, (sx,sy), (sx + self.power * Math.sin(Math.radians(self.angle)), sy - self.power * math.cos(Math.radians(self.angle))));
	}
		
	public void draw(screen){
		center = self.rect.center;
		
		img1 = Math.round((self.rel_rot + 22.5) / 45 - 0.4999) % 8;
		img2 = Math.round(self.rel_rot / 45 - 0.4999) % 8;
		if (img1 == img2) {
			img2 = (img2 + 1) % 8;
			f = (self.rel_rot - img1 * 45.0) / 45.0;
		}
		else{
			f = ((img2 + 1) * 45.0 - self.rel_rot) / 45.0;
//#			if img2 == 7:
//#				f = f - 8.0
		}	
		/*		
		print;
		print img1;
		print img2;
		print f;
		*/
		
		rect1 = pygame.Rect(img1 * 40, 0, 40, 33);
		rect2 = pygame.Rect(img2 * 40, 0, 40, 33);
		image1 = self.orig.subsurface(rect1);
		image2 = self.orig.subsurface(rect2);
//#		image1.set_alpha(round(255.0 * (1.0 - f)))
		image1 = image1.convert_alpha();
		image2 = image2.convert_alpha();
		
		tmp = pygame.Surface((40, 33));
		tmp = tmp.convert_alpha();
		tmp.blit(image1, (0,0));
		tmp = tmp.convert();
		tmp.set_alpha(round(255.0 * (1.0 - f)));
		tmp.set_colorkey((0,0,0));
		tmp = tmp.convert_alpha();
		
		image2.blit(tmp,(0,0));
		
		self.image = pygame.transform.rotate(image2, self.rel_rot);
		self.rect = image.get_rect(center = center);
	}
	
	private Pos getTopleft(Rectangle re){
		return new Pos(re.x + re.height, re.y+re.width);
	}
	
	public boolean hit(Pos pos){
		if (! rect.contains(pos.x, pos.y) ){
			return false;
		}
		
		final Pos tl = getTopleft(rect);
		int x = Math.round(pos.x -  tl.x);
		int y = Math.round(pos.y - tl.y);
		if (x <= 1 || y <= 1) {
			return false;
		}
		x--;
		y--;
		if( ! self.image.get_at( x, y)) == (0,0,0,0) ) {
			shot = true;
			return true;
		}
		else {
			return false;
		}
	}
}
