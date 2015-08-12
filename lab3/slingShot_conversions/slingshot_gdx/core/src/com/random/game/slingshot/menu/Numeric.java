package com.random.game.slingshot.menu;

public class Numeric {
	public void __init__(txt, init, step, mmax, mmin = 0, inf = "0"){
		Menu.__init__(self, txt);
		self.val = init;
		self.step = step;
		self.mmax = mmax;
		self.mmin = mmin;
		self.inf = inf;
		self.choice = -1;
	}
		
	public void up(){
		self.val += self.step;
		if(self.val > self.mmax){
			self.val = self.mmax;
		}
	}
	
	public void down(){
		self.val -= self.step;
		if (self.val < self.mmin){
			self.val = self.mmin;
		}
	}
			
	public void select(){
		self.choice = self.val;
	}

	public void get_choice(){
		c = self.choice;
		self.choice = -1;
		return c;
	}
		
	public void draw(){
		w = self.get_width();
		h = self.get_height();
		result = pygame.Surface((w, h));
		
		result.blit(Settings.menu_background, (0,0));
		
		txt = Settings.menu_font.render(self.name, 1, (255,255,255));
		rect = txt.get_rect();
		rect.midtop = (w / 2, Settings.MENU_LINEFEED);
		result.blit(txt, rect.topleft);
		
		if (self.val == 0){
			txt = Settings.menu_font.render(self.inf, 1, (255,255,255));
		}
		else{
			txt = Settings.menu_font.render("%d" %(self.val), 1, (255,255,255));
		}
		rect = txt.get_rect();
		rect.midtop = (w / 2, 2.5 * Settings.MENU_LINEFEED);
		result.blit(txt, rect.topleft);
		
		pygame.draw.rect(result, (0,0,200), pygame.Rect(0, 0, w, h), 1);
		
		return result;
	}
}
