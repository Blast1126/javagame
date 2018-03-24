package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Crazybullet extends Gameobject {
Handler handler;

	public Crazybullet(int x,int y ,ID id,Handler handler ) {
	
	super(x,y ,id);
	this.handler=handler;
	}


	@Override
	public void update() {
	
	x+=velx;
	y+=vely;
	
	if(handler.isDown1()){
		vely=2;
	}
	
	if(handler.isLeft1()){
		velx=-2;
	}
	
	if(handler.isRigh1t()){
		velx=2;
	}
	
	if(handler.isUp1()){
		vely=-2;
	}
	
	
	for(int x=0;x<handler.object.size();x++){
		Gameobject temptobject=handler.object.get(x);
		
		if(temptobject.getId()==ID.Block){
			if(this.collision().intersects(temptobject.collision())){
				handler.removeobject(this);
			}
		}
	}
	
	 for(int i=0;i<handler.object.size();i++){
	    	
	    	Gameobject temptobjet2=handler.object.get(i);
	    	
	    	if(temptobjet2.getId()==ID.player){
	    	if(this.collision().intersects(temptobjet2.collision())){
	    		handler.removeobject(this);
	    		handler.removeobject(temptobjet2);
	    	}
	
	}
	 }
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 12, 12);
		
	}

	@Override
	public Rectangle collision() {
	
		return new Rectangle(x,y,12,12);
	}

}
