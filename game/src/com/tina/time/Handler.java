package com.tina.time;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {

private boolean up=false,down=false,left=false,right=false,shooting =false ;
private String direction ="right";
private boolean up1=false,down1=false,left1=false,righ1t=false,shooting1 =false ;

	LinkedList<Gameobject>object=new LinkedList<>();
	

	
	public Handler() {
		
	}
	

	public void addobject(Gameobject gameobject){
		object.add(gameobject);//object can be added to the end of arraylist 
	}
	
	
	public void removeobject(Gameobject gameobject){
		object.remove(gameobject);//remove what ever you want 
	}
	
	public void render(Graphics g){
		for(int x=0;x<object.size();x++){
			Gameobject temptobjet=object.get(x);
			temptobjet.render(g);
	
		}
	}

	public void update(){
		for(int x=0;x<object.size();x++){
			Gameobject temptobject=object.get(x);
			temptobject.update();
		}
	}
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public boolean isShooting() {
		return shooting;
	}

	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}
	
	public String getDirection() {
		return direction;
	}
	public void removeall(){
		
	object.removeAll(object);
	}
	
	public boolean isUp1() {
	return up1;
}


public void setUp1(boolean up1) {
	this.up1 = up1;
}


public boolean isDown1() {
	return down1;
}


public void setDown1(boolean down1) {
	this.down1 = down1;
}


public boolean isLeft1() {
	return left1;
}


public void setLeft1(boolean left1) {
	this.left1 = left1;
}


public boolean isRigh1t() {
	return righ1t;
}


public void setRigh1t(boolean righ1t) {
	this.righ1t = righ1t;
}


public boolean isShooting1() {
	return shooting1;
}


public void setShooting1(boolean shooting1) {
	this.shooting1 = shooting1;
}



}
