package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Storage  {

public int ammon=10;
public int health=90;
public int score=0 ;
public int Cubehealth=20;
public int normalehealth=20;
public int check=0;
public int level=0;
private Handler handler;
private Box box; 

public Storage(Handler handler,Box box  ){
	
	this.handler=handler;
	this.box=box;

}
public void renderhealth(Graphics g){
  
  g.setColor(Color.red);
  g.fillRect(30, 30, 180, 50);
  g.setColor(Color.GREEN);
  g.fillRect(30, 30, health*2, 50);
  g.drawRect(30, 30, 180, 50);
  if(ammon>=0){
 g.drawString(Integer.toString(ammon), 50,100);}
  g.drawString(" your level",50,120);
  g.drawString(Integer.toString(level), 115,120);
  }

public void Loadlevel(){ 
	
	
  
    if(check==0){
    	
    	handler.addobject(new normalenemy(500,100,ID.normalenemy,handler,this,100));
    	handler.addobject(new normalenemy(200,200,ID.normalenemy,handler,this,100));
    	
    	
    	check++;
    	level++;
    	
    }
    
   if(check==1&&score==20){
    	handler.addobject(new Magician(200,200,ID.Magician,handler,this,600));
    	check++;
    	level++;
    }
    
    if(check==2&&score==30){
      handler.addobject(new Enemy4(1300,300,ID.Enemy4,handler,this,80));
      handler.addobject(new Enemy4(1100,0,ID.Enemy4,handler,this,80));
      check++;
      level++;
    }
    
    if(check==3&&score==50){
    	handler.addobject(new Cubenemy(200,200,ID.cubenemy,handler,this,600));
    	check++;
    	level++;
    }
    
    if(check==4&&score==60){

    	handler.addobject(new normalenemy(500,100,ID.normalenemy,handler,this,100));
    	handler.addobject(new normalenemy(200,200,ID.normalenemy,handler,this,100));
   
    	handler.addobject(new normalenemy(200,500,ID.normalenemy,handler,this,100));
       
    	check++;
    	level++;
    }
    
    if(check==5&&score==90){
    	handler.addobject(new Magician(0,0,ID.Magician,handler,this,300));
     	handler.addobject(new Magician(500,500,ID.Magician,handler,this,300));
    	check++;
    	level++;
    }
    
    
    
    
    
	


   

}
}
	
//}

