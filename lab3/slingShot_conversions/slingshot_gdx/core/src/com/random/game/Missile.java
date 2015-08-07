package com.random.game;

import java.util.List;

public class Missile extends Particule {

	public Missile(Settings set, Pos pos, Pos impact_pos, int size) {
		super(set, pos, impact_pos, size);
		/*
		Particle.__init__(self) #call Sprite intializer
		self.image, self.rect = load_image("data/shot.png", (0,0,0))
		self.rect = self.image.get_rect()
		self.trail_screen = trail_screen
		self.last_pos = (0.0, 0.0)
		*/
	}
	
	public void launch(player){
		self.flight = Settings.MAX_FLIGHT;
		self.pos = player.get_launchpoint();
		speed = player.get_power();
		angle = math.radians(player.get_angle());
		self.v = (0.1 * speed * math.sin(angle), -0.1 * speed * math.cos(angle));
		self.trail_color = player.get_color();

		self.score = -Settings.PENALTY_FACTOR * speed;
	}
	
	public void update_players(players){
		result = 1;
		
		Pos pos;
		for (int i=0; i<10; i++) {
			pos.up(self.last_pos[0] + i * 0.1 * self.v[0], self.last_pos[1] + i * 0.1 * self.v[1]);
			if (players[1].hit(pos)){
				result = 0;
			}
			if (players[2].hit(pos)) {
				result = 0;
			}
			if (result == 0) {
				self.impact_pos = pos;
				self.pos = pos;
				break;
			}
		}
		return result;	
	}
			
	public void draw_status(screen){
		txt = Settings.font.render("Power penalty: %d" %(-self.score), 1, (255,255,255));
		rect = txt.get_rect();
		rect.midtop = (399, 5);
		screen.blit(txt, rect.topleft);
		if (self.flight >= 0) {
			txt = Settings.font.render("Timeout in %d" %(self.flight), 1,(255,255,255));
		}
		else {
			txt = Settings.font.render("Shot timed out...", 1, (255,255,255));
		}
		rect = txt.get_rect();
		rect.midbottom = (399, 594);
		screen.blit(txt, rect.topleft);
	}
		
		
	public void update(List<Planete> planets, players){
		result = Particle.update(self, planets);
		result = result * self.update_players(players);
		pygame.draw.aaline(self.trail_screen, self.trail_color, self.last_pos, self.pos);
		return result;
	}
		
	public void get_image(self){
		return self.image;
	}
	
	public void get_score(){
		return self.score;
	}
}
