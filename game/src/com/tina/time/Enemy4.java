package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy4  extends Gameobject {
	
private Handler handler;
private int health;
private Storage storage ;

	public Enemy4(int x ,int y,ID id,Handler handler ,Storage storage ,int health ) {
		
		super(x,y,id);
		this.health=health;
		this.handler=handler;
		this.storage=storage;
		vely=2;
	}

	@Override
	public void update() {
	
	y+=vely;
	
	if(y>Game.height-32||y<=0){
		vely*=-1;
		x-=150;
	}
	
	collided();
	
	if(health<=0){
		handler.removeobject(this);
		storage.score+=10;
	}
		
	}

	@Override
	public void render(Graphics g) {
	
	g.setColor(Color.GREEN);
	g.fillRect(x, y, 80,80);
		
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
		// TODO Auto-generated method stub
		return new Rectangle(x,y ,80,80);
	}

	

}
