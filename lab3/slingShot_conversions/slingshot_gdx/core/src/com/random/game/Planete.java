package com.random.game;

/**
#    This file is part of Slingshot.
#
# Slingshot is a two-dimensional strategy game where two players attempt to shoot one
# another through a section of space populated by planets.  The main feature of the
# game is that the shots, once fired, are affected by the gravity of the planets.

# Slingshot is Copyright 2007 Jonathan Musther and Bart Mak. It is released under the
# terms of the GNU General Public License version 2, or later if applicable.

# Slingshot is free software; you can redistribute it and/or modify it under the terms
# of the GNU General Public License as published by the Free Software Foundation; either
# version 2 of the License, or any later version.

# Slingshot is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
# without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
# See the GNU General Public License for more details.

# You should have received a copy of the GNU General Public License along with Slingshot;
# if not, write to
# the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA 
*/

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Planete extends Sprite {
	private Sprite spr;
	private int n;
	private int r;
	private Pos pos;
	private float mass;
	
	public Planete(String filename){
		spr = new Sprite(new Texture(filename));
		n= (int) Math.random()*7+1;
	}
	
	public int get_n(){
		return n;
	}
	
	public int get_radius(){
		return r;
	}
		
	public float get_mass(){
		return mass;
	}
		
	public Pos get_pos(){
		return pos;
	}
		
	/*
	public void fade(f){
		self.image = self.fade_image;
		self.image.set_alpha(255 - round(f * 2.55));
	}
	*/
}
