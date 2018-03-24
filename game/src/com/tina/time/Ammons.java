package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ammons extends Gameobject {

Handler handler ;
Storage storage ;
	public Ammons(int x,int y,ID id,Handler handler ,Storage storage) {
		super(x,y,id);
	    this.handler=handler;
	    this.storage=storage;
	}

	@Override
	public void update() {
	
	for(int x=0;x<handler.object.size();x++){
		Gameobject temptobject=handler.object.get(x);
		
		if(temptobject.getId()==ID.player){
			if(this.collision().intersects(temptobject.collision())){
				storage.ammon+=1000;
				handler.removeobject(this);
			
			}
		}
	}
		
	}

	@Override
	public void render(Graphics g) {
	
	g.setColor(Color.YELLOW);
	g.fillRect(x, y, 16, 16);	
	}

	@Override
	public Rectangle collision() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,16,16);
	}



}
