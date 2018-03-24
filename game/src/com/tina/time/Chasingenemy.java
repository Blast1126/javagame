package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Chasingenemy extends Gameobject  {

private float distancex,distancey,magnitude;
private Handler handler;
private int timer =10;
private int health;
private Storage storage;
	public Chasingenemy(int x,int y,ID id,Handler handler,int health, Storage storage  ) {
		super(x,y,id);
		this.handler=handler;
		this.health=health;
		this.storage=storage;
	}

	@Override
	public void update() {
		
		
	
		
		
		chasing();
		if(timer>=0){
			timer--;
		}
		
		if(timer<=0){
			x+=velx;
			y+=vely;
			timer+=10;
		}
		
		collided();
		
		if(health<=0){
			handler.removeobject(this);
		}
		
	}
	
	 private void chasing(){ 
		 
	  for(int xx=0;xx<handler.object.size();xx++){
		  
		 Gameobject tempobject=handler.object.get(xx);
		 
		 if(tempobject.getId()==ID.player){
			 distancex=tempobject.getX()-x;
			distancey=tempobject.getY()-y;
			magnitude=(float) Math.sqrt(Math.pow(distancex, 2)+Math.pow(distancey, 2));
			
			velx=(distancex/magnitude)*10;
			vely=(distancey/magnitude)*10;
			
			
		 }
	  }
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
		 
		 if(temptobject.getId()==ID.player){

			 if(this.collision().intersects(temptobject.collision())){
			 handler.removeobject(this);
			 storage.health-=20;
				 }

			 }
	 }
 }

	@Override
	public void render(Graphics g) {
		
	g.setColor(Color.YELLOW);
	g.fillRect(x, y, 48, 48);
		
	}

	@Override
	public Rectangle collision() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,48,48);
	}

}
