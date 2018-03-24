package com.tina.time;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Gameobject {
                    
protected int x,y;// a variable is only visible to the classes within the same package	
protected float velx,vely;
ID id;

	public Gameobject(int x,int y,ID id ) {
		this.x=x;
		this.y=y;
		this.id=id;
	}
	
	public abstract void update();
	public abstract void render(Graphics g );
	public abstract Rectangle collision();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelx() {
		return velx;
	}

	public void setVelx(float velx) {
		this.velx = velx;
	}

	public float getVely() {
		return vely;
	}

	public void setVely(float vely) {
		this.vely = vely;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	
	
}
