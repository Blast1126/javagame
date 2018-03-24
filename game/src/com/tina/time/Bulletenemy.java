package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bulletenemy extends Gameobject {

private Storage storage ;
private Handler handler ;
	public Bulletenemy(int x,int y,ID id ,Storage storage ,Handler handler) {
     
	super(x,y,id);
	
	velx=1.5f;
	vely=-1.5f;
	
	this.storage=storage;
	}

	public void update() {
    
	
	x+=velx;
	y+=vely;
	
	if(y<=0||y>=Game.height){
		vely*=-1;
	}
	
	if(x>=Game.width||x<=0){
		velx*=-1;
	}
	
	
	}

	@Override
	public void render(Graphics g) {
	
	g.setColor(Color.PINK);
	g.fillRect(x, y, 12, 12);
		
	}
	
	private void collided(){
		
	for(int x=0;x<handler.object.size();x++){
		
	Gameobject temptobject=handler.object.get(x);
	
	if(temptobject.getId()==ID.player){
		if(this.collision().intersects(temptobject.collision())){
			
			storage.health-=10;
		}
	}
	
	}

	}

	@Override
	public Rectangle collision() {
		return new Rectangle(x,y,12,12);
	}

}
