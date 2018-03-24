package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player2 extends Gameobject{
int hp=100;
Handler handler;
	public Player2(int x,int y,ID id,Handler handler ) {
		super(x,y,id);
		this.handler=handler;
	}

	@Override
	public void update() {
	
	x+=velx;
	y+=vely;

	if(handler.isRigh1t()){velx=3;
	}
	else if(!handler.isLeft1()){
		velx=0;
	}
	
	if(handler.isLeft1()){
		velx=-3;
	}
	else if(!handler.isRigh1t()){
		velx=0;
	}
	
	if(handler.isUp1()){
		vely=-3;
	}
	
	else if(!handler.isDown1()){
		vely=0;
	}
	
	if(handler.isDown1()){
		vely=3;
	}
	else if(!handler.isUp1()){
		vely=0;
	}
	
	 for(int i=0;i<handler.object.size();i++){
	    	
	    	Gameobject temptobjet2=handler.object.get(i);
	    	
	    	if(temptobjet2.getId()==ID.player){
	    	if(this.collision().intersects(temptobjet2.collision())){
	    		handler.removeobject(temptobjet2);
	    	}
	
	}
	 }
	 

	 for(int i=0;i<handler.object.size();i++){
	    	
	    	Gameobject temptobjet=handler.object.get(i);
	    	
	    	if(temptobjet.getId()==ID.bullet){
	    	if(this.collision().intersects(temptobjet.collision())){
	    		handler.removeobject(temptobjet);
	    	}
	
	}
	 }
		
	}

	@Override
	public void render(Graphics g) {
	g.setColor(Color.magenta);
	g.fillRect(x, y, 48, 48);
		
	}

	@Override
	public Rectangle collision() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,48,48);
	}


}
