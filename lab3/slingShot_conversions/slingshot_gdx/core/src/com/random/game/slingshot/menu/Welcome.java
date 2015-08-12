package com.random.game.slingshot.menu;

public class Welcome {
	public void __init__(){
		Menu.__init__(self, "");
		self.img, rect = load_image("data/welcome.png", (0,0,0));
		self.choice = "";
	}
		
	public void select(){
		self.choice = "Start";
	}
	
	public void draw(){
		return self.img;;
	}
}
