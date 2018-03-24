package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Cubenemy extends Gameobject{

private Handler handler;
private Storage storage;
private int timer =400;
private int health;
	public Cubenemy(int x,int y,ID id,Handler handler ,Storage storage,int health) {
		super(x,y,id);
		this.handler=handler;
		this.storage=storage;
		this.health=health;
		velx=3;
	}

	@Override
	public void update() {
		
    x+=velx;		
	Random random=new Random();
	
	if(x>=Game.width||x<=0){		
		velx*=-1;
		y+=50;
		
	}
	
	
	
	if(timer>=0){
		timer--;
	}
	
	if(timer==0){
		handler.addobject(new Bulletenemy(x,y,ID.bulletenemy,storage,handler) );
		timer+=400;
	}
	
	collided();
	
	if(health<=0){
		handler.removeobject(this);
		storage.score+=10;
	
	}
	
	}

	@Override
	public void render(Graphics g) {
		
	g.setColor(Color.BLACK);
	g.fillRect(x, y, 60, 60);
	
	}
	
	private void collided(){
		
		for(int x=0;x<handler.object.size();x++){
		Gameobject tempobject=handler.object.get(x);
		
		if(tempobject.getId()==ID.bullet){
			if(this.collision().intersects(tempobject.collision())){
				handler.removeobject(tempobject);
				health-=20;
			}
		}
		}
	}

	@Override
	public Rectangle collision() {
	return new Rectangle(x,y,50,50);
	}

}
