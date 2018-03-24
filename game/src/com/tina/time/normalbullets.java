package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class normalbullets extends Gameobject {
Handler handler ; 
	public normalbullets(int x,int y,ID id, Handler handler  ) {

		super(x,y,id);
		this.handler=handler;
	}

	@Override
	public void update() {
		
   
    x+=velx;
    y+=vely;
    
    
    if(handler.isRight()){
    	velx=1;
    	
    	
    }
    
    if(handler.isUp()){
       vely=-1;
       
      }    
    
    if(handler.isLeft()){
    	velx=-1;
    	
    }
    
    if(handler.isDown()){
    	vely=1;
    	
    }
    
    
	  if(y<0){	
		  handler.removeobject(this);
	  }
	  
	  if(y>=Game.height-32){
		 handler.removeobject(this);		 
	  }
	  
	  if(x<0){
		  handler.removeobject(this);
	  }
	  if(x>=Game.width-32){
		  handler.removeobject(this);
	  }
    
    for(int x=0;x<handler.object.size();x++){
    	
    	Gameobject temptobjet=handler.object.get(x);
    	
    	if(temptobjet.getId()==ID.Block){
    	if(this.collision().intersects(temptobjet.collision())){
    		handler.removeobject(this);
    	}
   
    	  for(int i=0;i<handler.object.size();i++){
    	    	
    	    	Gameobject temptobjet2=handler.object.get(i);
    	    	
   	    	if(temptobjet2.getId()==ID.player2){
   	    	if(this.collision().intersects(temptobjet2.collision())){
    	    		handler.removeobject(this);
    	    		handler.removeobject(temptobjet2);
       	}
    	
    	}
    }
    	}   
    }
    
		
	}

	@Override
	public void render(Graphics g) {
	
	g.setColor(Color.GREEN);
	g.fillRect(x, y, 12, 12);
		
	}

	@Override
	public Rectangle collision() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,12,12);
	}


	

}
