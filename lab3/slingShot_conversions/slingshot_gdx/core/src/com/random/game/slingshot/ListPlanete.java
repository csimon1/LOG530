package com.random.game.slingshot;

import java.util.ArrayList;
import java.util.List;

public class ListPlanete {
	private List<Planete> listPlanete;
	
	int n, mass;
	double r;
	Pos pos;

	
	public ListPlanete() {
		super();
		listPlanete = new ArrayList<>();
		init();
	}


	public List<Planete> getListPlanete() {
		return listPlanete;
	}
	
	private void init(){
		boolean unique = false;
		while (! unique){
			unique = true;
			n = (int) Utils.randIntr(1,8);
			for (Planete p : listPlanete){
				if (n == p.get_n())
					unique = false;
			}
		}
		String filename = "data/planet_"+n+".png";
		Planete pl = new Planete(filename);
		
		boolean positioned = false;
		while (! positioned){
			double m = Math.random()*(Math.pow(518-8,2));
			//mass = (int) (8 + Math.sqrt(m));
			mass = (int) (Math.random()*(518-8)+8);
			r = Math.pow(mass, 1/3) * 12.5;
			double xpos = Utils.randIntr(Settings.PLANET_SHIP_DISTANCE + r, 800 - Settings.PLANET_SHIP_DISTANCE - r);
			double ypos = Utils.randIntr(Settings.PLANET_EDGE_DISTANCE + r, 600 - Settings.PLANET_EDGE_DISTANCE - r);
			pos = new Pos( xpos, ypos);
			positioned = true;
			for(Planete p : listPlanete){
				double d = Math.sqrt(Math.pow((pos.x - p.get_pos().x), 2) + Math.pow((pos.y - p.get_pos().y),2));
				if (d < (r + p.get_radius()) * 1.5 + 0.1 * (mass + p.get_mass()))
					positioned = false;
			}
		}
		
		int s = (int) (Math.round(2 * r / 0.96));
		
		/*
		self.orig = pygame.transform.scale(self.image, (s, s));
		self.image = self.orig;
		self.rect = self.orig.get_rect();
		self.rect.center = self.pos;
		tmp = pygame.Surface(background.get_size());
		tmp.blit(background, (0,0));
		rect = tmp.blit(self.orig, self.rect.topleft);
		self.fade_image = pygame.Surface(self.orig.get_size());
		self.fade_image.blit(tmp, (0,0), rect);
		self.fade_image.set_alpha(255);
		self.fade_image.convert();
		*/
	}
}
