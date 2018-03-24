package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullets extends Gameobject{

Handler handler ;
int health=100;
private float distancex,distancey;
private float magnitude;
private Storage storage;

	public Bullets(int x,int y,ID id ,int bx,int by ,Handler handler,int  damage,Storage storage  ) {
		super(x,y,id);
		
		distancex=bx-x;
		distancey=by-y;
		
		magnitude=(float) Math.sqrt(Math.pow(distancex, 2)+Math.pow(distancey, 2));
		
		this.handler=handler;
		velx=(distancex/magnitude)*10;
		vely=(distancey/magnitude)*10;
		this.storage=storage;
	}
			
		
	


	@Override
	public void update() {

	x+=velx;
	y+=vely;
	
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
		
	}
	


	@Override
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 12, 12);
		
		
	}

	@Override
	public Rectangle collision() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,12,12);
	}

	
}
