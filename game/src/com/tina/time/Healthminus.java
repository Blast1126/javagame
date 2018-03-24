package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Healthminus extends Gameobject {

Handler handler;
Storage storage;
	public Healthminus(int x,int y,ID id,Handler handler,Storage storage ) {
		
	super(x,y,id);
	this.handler=handler;
	this.storage=storage;
	}

	@Override
	public void update() {

	collided();
		
	}
	
	private void collided(){
	
	
		for(int x=0;x<handler.object.size();x++){

			Gameobject tempobject=handler.object.get(x);

			if(tempobject.getId()==ID.Magician){

				if(this.collision().intersects(tempobject.collision())){
					storage.health-=45;
					storage.score+=10;
					handler.removeobject(tempobject);
				}
			}

			if(tempobject.getId()==ID.normalenemy){
				if(this.collision().intersects(tempobject.collision())){
					storage.health-=10;
					storage.score+=10;
					handler.removeobject(tempobject);
				}
			}

			if(tempobject.getId()==ID.cubenemy){
				if(this.collision().intersects(tempobject.collision())){
					storage.health-=25;
					storage.score+=10;
					handler.removeobject(tempobject);
				}
			}
			
			

			if(tempobject.getId()==ID.Enemy4){
				if(this.collision().intersects(tempobject.collision())){
					storage.health-=10;
					handler.removeobject(tempobject);
					storage.score+=10;
				}
			}
			
			
			if(tempobject.getId()==ID.normalbullets){
				if(this.collision().intersects(tempobject.collision())){
					storage.health-=10;
					handler.removeobject(tempobject);
				}
			}
			
			
			if(tempobject.getId()==ID.bulletenemy){
				if(this.collision().intersects(tempobject.collision())){
					storage.health-=10;
					handler.removeobject(tempobject);
				}
			}
	
		}
     	}

	@Override
	public void render(Graphics g) {
	
	g.setColor(Color.blue);
	g.fillRect(x, y, 100, 100);
	}

	@Override
	public Rectangle collision() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,100,100);
	}

}