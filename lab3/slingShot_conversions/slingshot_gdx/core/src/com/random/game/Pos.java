package com.random.game;

public class Pos {
	float x;
	float y;

	public Pos(float d, float e) {
		x = d;
		y = e;
	}
	
	//lol
	public Pos(double d, double e) {
		x = (float) d;
		y = (float) e;
	}
	
	public void up(float x, float y){
		this.x = x;
		this.y =y;
	}
	
	public Pos diff(Pos v){
		return new Pos(x-v.x,y-v.y);
	}
	
	public float diffX(Pos p){
		return x-p.x;
	}
	
	public float diffY(Pos p){
		return y-p.y;
	}
}
