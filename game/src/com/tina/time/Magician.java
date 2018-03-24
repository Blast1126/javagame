package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Magician extends Gameobject {

private int timer=100;
private int health=100;
private Handler handler;
private Storage storage;

	public Magician(int x,int y ,ID id ,Handler handler,Storage storage,int health) {
	
	super(x,y,id);
	this.handler=handler;
	this.storage=storage;
	this.health=health;
	velx=1;
	}

	@Override
	public void update() {
		
	
		x+=velx;
		y+=vely;
		if(timer>=0){
			timer--;
		}
		
		if(timer==0){
			handler.addobject(new Chasingenemy(x,y,ID.chasingenemy,handler,20,storage));
			timer+=100;
		}
		
		if(x>=Game.width||x<=0){		
			velx*=-1;
			y+=200;
			
		}
		
		if(health<=0){
			storage.score+=10;
			handler.removeobject(this);
		}
		collided();
	}

	@Override
	public void render(Graphics g) {
	
    g.setColor(Color.RED);	
	g.fillRect(x, y, 128, 128);
	}

	
	 private void collided(){
		 for(int i=0;i<handler.object.size();i++){
			 Gameobject temptobject=handler.object.get(i);

			 if(temptobject.getId()==ID.bullet){

			 if(this.collision().intersects(temptobject.collision())){
			 handler.removeobject(temptobject);
			 health-=20;
				 }

			 }
			  }
	 }

	@Override
	public Rectangle collision() {
	
		return new Rectangle(x,y,128,128);
	}

}
