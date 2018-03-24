package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class normalenemy extends Gameobject  {

private Handler handler;
private Storage storage;
private int timer=600;
private int health;


	public normalenemy(int x,int y,ID id,Handler handler,Storage storage ,int health ) {
		super(x,y,id);
		this.handler=handler;
		this.storage=storage;
		velx=5;
		this.health=health;
	}

	public void update() {
	
	x+=velx;
	if(timer>=0){
		timer--;
	}
	
	if(timer==0){
		handler.addobject(new Ebullets(x,y,ID.normalbullets));
		timer+=600;
	}
	
	if(x>=Game.width-32){
		velx*=-1;
		y+=50;
	}
	
	if(x<=0){
		velx*=-1;
		y+=50;
	}
	
	this.collided();
	
	if(health<=0){
		handler.removeobject(this);
		storage.score+=10;
	}
	}

	@Override
	public void render(Graphics g) {
	
	g.setColor(Color.CYAN);
	g.fillRect(x, y, 64, 64);
		
	}
	
	private void collided(){
		
    for(int x=0;x<handler.object.size();x++){
    	
      Gameobject tempobject=handler.object.get(x);
      
      if(tempobject.getId()==ID.bullet){
    	  
    	 if(tempobject.collision().intersects(this.collision())){
    		 handler.removeobject(tempobject);
           health-=20;
          
    	 }
      }
    		  
    }
	}

	@Override
	public Rectangle collision() {	
		
		return new Rectangle(x,y,64,64);
	}


}
