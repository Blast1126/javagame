package com.tina.time;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseLisetner extends MouseAdapter{
	
private Handler handler;
private Storage storage;
public boolean end=false;
Font font ;
public boolean game=false;
private Box box;
public Gamestate state=Gamestate.menu;
	public MouseLisetner(Handler handler,Storage storage ,Box box ) {
		this.box=box;
		this.handler=handler;
		this.storage=storage;}
	
	
	public void mousePressed(MouseEvent e){
		
		
		
		if(state==Gamestate.game){
		if(storage.ammon>=0){
			storage.ammon--;
			}
		
		}
	
		
		
		int playerx;
		int playery;
		int  mx=e.getX();//it will return the position of y 
		 int my=e.getY();//it will return the position of x 
		
		for(int x=0;x<handler.object.size();x++){
			Gameobject tempobject=handler.object.get(x);
			
			if(tempobject.getId()==ID.player&&storage.ammon>=0&&state==Gamestate.game){
				playerx=tempobject.getX();
				playery=tempobject.getY();
				
				handler.addobject(new Bullets(tempobject.getX(),tempobject.getY(),ID.bullet,mx,my,handler,5,storage));
			
			}
			
			
		}
		
		if(mx>600&&mx<750){
	     if(my>500&&my<580){
	    	 state=Gamestate.game;
	    	
	     }
		}
		
		
		if(state==Gamestate.gameover){
		if(mx>470&&mx<1000){//when you click back to menu
		if(my>660&&my<750){	
        state=Gamestate.menu;
        handler.removeall();
        storage.health+=90;
        storage.check=0;
        storage.ammon=1;
        storage.score=0;
        storage.level=0;
        
    	handler.addobject(box);
		//handler.addobject(new Ammons(500,800,ID.bullet,handler,storage ));
		handler.addobject(new Healthminus(700,900,ID.damageobject,handler,storage));
		handler.addobject(new Healthminus(400,900,ID.damageobject,handler,storage));
		handler.addobject(new Healthminus(1000,900,ID.damageobject,handler,storage));

			}
		
		}
		}
		
		}
	
	
	public void rendermenu(Graphics g ){
    
	font =new Font("arial",1,57);//name ,style size
	Font font1 =new Font("arial",1,80);//name ,style size
	
	
	g.setFont(font1);
	g.setColor(Color.BLACK);
	g.drawString("2D Cube adventure ", 200, 200);
	
	g.setFont(font);
	g.setColor(Color.gray);
	g.drawRect(600, 500, 150, 80);
	g.setColor(Color.orange);
	g.drawString("play", 600, 545);
	
	

	
	
	}
	
	
	public void rendergameover(Graphics g ){
		
		
		Font font1 =new Font("arial",1,80);//name ,style size
		
		
		g.setFont(font1);
		g.setColor(Color.gray);
		g.drawRect(480, 500, 440, 80);
		g.setColor(Color.RED);
		g.drawString("Game over ", 500, 570);
		
		
		
		g.setFont(font);
		g.setColor(Color.GRAY);
		g.drawRect(470, 660, 530, 90);
		g.setColor(Color.BLUE);
		g.drawString(" back to main menu ", 470, 720);
		
	}
	
	
	

	

}
