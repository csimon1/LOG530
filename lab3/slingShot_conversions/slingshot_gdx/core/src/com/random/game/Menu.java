package com.random.game;

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
		 // item, 0, 0, 1 
		final boolean tmp[] = {item, false, false, true};
		Arrays.asList(tmp);
		items.addAll();
		items.append((item, 0, False, True));
	}
				
	public addoption(item, v = False, a = True){
		items.append((item, 1, v, a));
	}
		
	public  up(){
		selected--;
		if (selected < 0) {
			selected = items.size() - 1;
		}
		if(items[self.selected][3] == false){
			up()
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
		if (items[self.selected][3] == false){
			down();
		}
	}
		
	public right(){
		down();
	}
		
	public select(){
		return items[selected][0];
	}
		
	public void reset(){
		self.selected = 0;
		self.choice = "";
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
	
	public select(){
		if (items[selected][1]){
			items[selected] = (items[selected][0], items[selected][1], not items[selected][2], items[selected][3]);
		}
		choice = items[selected][0];
	}
		
	public get_choice(){
		c = self.choice;
		self.choice = "";
		return c;
	}				
}
