package com.random.game.slingshot.menu;

public class Confirm {
	public void __init__(self, txt1, txt2 = "", txt3 = ""){
		Menu.__init__(self, "");
		self.txt1 = txt1;
		self.txt2 = txt2;
		self.txt3 = txt3;
	}
		
	public void draw(){
		offset = 0;
		
		w = self.get_width();
		h = self.get_height();
		result = pygame.Surface((w, h));
		//#result.fill((100,0,0));
		result.blit(Settings.menu_background, (0,0));
		
		txt = Settings.menu_font.render(self.txt1, 1, (255,255,255));
		rect = txt.get_rect();
		rect.midtop = (w / 2, Settings.MENU_LINEFEED);
		result.blit(txt, rect.topleft);
		
		if (self.txt2 != ""){
			offset += Settings.MENU_LINEFEED;
			txt = Settings.menu_font.render(self.txt2, 1, (255,255,255));
			rect = txt.get_rect();
			rect.midtop = (w / 2, Settings.MENU_LINEFEED + offset);
			result.blit(txt, rect.topleft);
		}
		
		if (self.txt3 != ""){
			offset += Settings.MENU_LINEFEED;
			txt = Settings.menu_font.render(self.txt3, 1, (255,255,255));
			rect = txt.get_rect();
			rect.midtop = (w / 2, Settings.MENU_LINEFEED + offset);
			result.blit(txt, rect.topleft);
		}
		
		for (i in range(0, 2) ){
			if (i == self.selected){
				color = (self.count,self.count,255);
			}
			else {
				color = (0,0,255);
			}
			txt = Settings.menu_font.render(self.items[i][0], 1, color);
			rect = txt.get_rect();
			if (i == 0){
				rect.topright = (w / 2 - Settings.MENU_LINEFEED, 3 * Settings.MENU_LINEFEED + offset);
			}
			else{
				rect.topleft = (w / 2 + Settings.MENU_LINEFEED, 3 * Settings.MENU_LINEFEED + offset);
			}
			result.blit(txt, rect.topleft);
		}
		
		pygame.draw.rect(result, (0,0,200), pygame.Rect(0, 0, w, h), 1);
		
		self.count += self.inc;
		if (self.count > 255 or self.count < 0){
			self.inc *= -1;
			self.count += 2* self.inc;
		}
		
		return result;
	}
}
