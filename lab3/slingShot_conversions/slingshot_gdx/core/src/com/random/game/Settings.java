package com.random.game;

import com.badlogic.gdx.graphics.Texture;

public final class Settings {
	Texture particle_image5, particle_image10;
	
	public static final int 
		g = 120, // # gravity
		MAXPOWER = 350,
		PLANET_SHIP_DISTANCE = 75, // # this is actually the distance towards the edge left and right
		PLANET_EDGE_DISTANCE = 50, // # upper and lower edge
		
		PARTICLE_5_MINSPEED = 100, //
		PARTICLE_5_MAXSPEED = 200, // # 200: easy, 300: wild
		PARTICLE_10_MINSPEED = 150, //
		PARTICLE_10_MAXSPEED = 250,  //# 250 easy, 400-500 wild
		n_PARTICLES_5 = 0, // # number of small particles originating from a big one
		n_PARTICLES_10 = 0; // # number of big particles originating from explosion
		                   //# if both are too high, the game stalls on impact
	public static final boolean 
		ROTATE = true,
		BOUNCE = true,
		FIXED_POWER = false,
		PARTICLES = true,
		INVISIBLE = true,
		RANDOM = false;
	
	public static final int 	
		POWER = 200,
		MAX_FLIGHT = 750,
		MAX_PLANETS = 4;
	
	public static final int 
		HITSCORE = 1500,
		SELFHIT = 2000,
		QUICKSCORE1 = 500,
		QUICKSCORE2 = 200,
		QUICKSCORE3 = 100;
	
	public static final int 
		PENALTY_FACTOR = 5,	
		FPS = 30,
		KEY_REPEAT = 30, //# time between repeating key events, keep a little lower than 1000 / FPS
		KEY_DELAY = 250,
		MENU_FONT_SIZE = 26,
		MENU_LINEFEED = 36;
	
	public static final int 
		MAX_ROUNDS = 0,
		MOVE_GAP = 30; // #how many pixel needed to trigger change for mouse
	
	public final class MouseButtons {
		public static final int 
			LEFT = 1,
			MIDDLE = 2,
			RIGHT = 3,
			WHEEL_UP = 4,
			WHEEL_DOWN = 5,
			VERT = 1,
			HORZ = 0;
	}
}
