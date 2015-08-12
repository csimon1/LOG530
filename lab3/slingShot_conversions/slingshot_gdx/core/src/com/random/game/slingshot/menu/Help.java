package com.random.game.slingshot.menu;

public class Help {
	public void __init__(){
		Menu.__init__(self, "", false);
		self.img, rect = load_image("data/help.png", (0,0,0));
		self.choice = "";
	}

	public void select(){
		self.choice = "Back";
	}
	
	public void draw(){
		return self.img;
	}
}
