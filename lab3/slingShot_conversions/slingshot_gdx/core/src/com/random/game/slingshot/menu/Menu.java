package com.random.game.slingshot.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class Menu {
	private List<List<Boolean>> items;
	private String name;
	private int count;
	private int inc;
	private boolean dim;
	
	private int selected;
	private String choice;

 	public Menu(String name, boolean dim) {
		super();
		items = new ArrayList<List<Boolean>>();
		this.name = name;
		this.dim = dim;
		count = 0;
		inc = 15;
	}

	
	public void change_active(boolean item, boolean a){
		for (int i=0; i<items.size() ; i++ ){
			if(items.get(i).get(0) == item ) {
				items.get(i) .set(3, a);
			}
		}
	}
	
	
	public void add(boolean item){
		/*
		 // item, 0, 0, 1 
		final boolean tmp[] = {item, false, false, true};
		Arrays.asList(tmp);
		items.addAll();
		items.append((item, 0, False, True));
		*/
	}
	
	public void addoption(boolean item){
		this.addoption(item,false,true);
	}
	public void addoption(boolean item,boolean v, boolean a){
		/*
		items.append((item, 1, v, a));
		*/
	}
		
	public void up(){
		selected--;
		if (selected < 0) {
			selected = items.size() - 1;
		}
		if(items.get(selected).get(3) == false){
			up();
		}
	}
	
	public void left(){
		up();
	}
			
	public void down(){
		selected++;
		if (selected >= items.size()){
			selected = 0;
		}
		if (items.get(selected).get(3) == false){
			down();
		}
	}
		
	public void right(){
		down();
	}
		
	public boolean select(){
		return items.get(selected).get(0);
	}
	
		
	public void reset(){
		selected = 0;
		choice = "";
	}
		
	public int get_width(){
		//#return 300;
		return 350;
	}
		
	public int get_height(){
		//#n = self.items.__len__()
		//#return 44 * n + 100
		return 500;
	}
	
	/*
	public select(){
		if (items.get(selected).get(1) ){
			items[selected] = (items[selected][0], items[selected][1], not items[selected][2], items[selected][3]);
		}
		choice = items.get(selected).get(0);
	}
	*/
	
	/*
	 * Get the choice and clean it, like taking it from buffer
	 * */
	public String get_choice(){
		String c = choice;
		choice = "";
		return c;
	}
	
	public void draw(){
		w = self.get_width();
		h = self.get_height();
		result = pygame.Surface((w, h));
		//#result.fill((100,0,0));
		result.blit(Settings.menu_background, (0,0));
		
		txt = Settings.menu_font.render(self.name, 1, (255,255,255));
		rect = txt.get_rect();
		rect.midtop = (w / 2, Settings.MENU_LINEFEED);
		result.blit(txt, rect.topleft);
		
		n = self.items.__len__();
		for (i in range(0, n)){
			if (i == self.selected){
				color = (self.count,self.count,255);
			}
			else{
				if (self.items[i][3] == true){
					color = (0,0,255);
				}
				else{
					color = (75,75,75);
				}
			}
			txt = Settings.menu_font.render(self.items[i][0], 1, color)
			if (self.items[i][1] == 1){
				offset = 35;
				result.blit(Settings.box, (25, 2.5 * Settings.MENU_LINEFEED + Settings.MENU_LINEFEED * i - 8));
				if (self.items[i][2]){
					if (self.items[i][3]){
						result.blit(Settings.tick, (25, 2.5 * Settings.MENU_LINEFEED + Settings.MENU_LINEFEED * i - 8));
					}
					else{
						result.blit(Settings.tick_inactive, (25, 2.5 * Settings.MENU_LINEFEED + Settings.MENU_LINEFEED * i - 8));
					}
				}
			}
			else{
				offset = 0;
			}
			result.blit(txt, (25 + offset,2.5 * Settings.MENU_LINEFEED + Settings.MENU_LINEFEED * i));
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
