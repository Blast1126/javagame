package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss extends Gameobject {

private int health;
private int timer1=200 ;
private int timer2=500;
private Handler handler;
private Storage storage ;
private int hurt;
private boolean add=false;
Random random;

	public Boss(int x, int y ,ID id ,int health,Handler handler ,Storage storage ) {
	
	super(x,y,id);
	this.health=health;
	this.handler=handler;
	this.storage=storage;
	velx=3;
	}

	@Override
	public void update() {
	
		int timer = 0 ;
		
	random=new Random();
	x+=velx;
		if(x>=Game.width-32||x<=0){
		velx*=-1;
		
		
		
		}
		
		
		if(timer1>0){
			timer1--;
		}
		
		if(timer1==-5){
			handler.addobject(new Ebullets(x,y,ID.normalbullets));
			timer1+=305;}
		

         if(timer2>0){		
        	 timer2--;
         }
         
         if(timer2==-10){
        	 velx*=1.2;
        	 timer2+=810;
        	 
         }
    
		
	}
	
	

	
	@Override
	public void render(Graphics g) {

	g.setColor(Color.BLUE);
	g.fillRect(x, y, 100, 100);
		
	}

	@Override
	public Rectangle collision() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,100,100);
	}

    private void collided(){
    	
    	for(int x=0;x<handler.object.size();x++){

    	Gameobject tempobject=handler.object.get(x);

    	if(tempobject.getId()==ID.bullet){

    	if(tempobject.collision().intersects(this.collision())){
    		handler.removeobject(tempobject);
    		health-=20;
    		hurt++;

    			}
    		}
    	}
    }

}
