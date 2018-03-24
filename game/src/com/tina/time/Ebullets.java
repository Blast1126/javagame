package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ebullets extends Gameobject {

	public Ebullets(int x,int y,ID id ) {
		
	super(x,y,id);
	
	vely=2;
	}

	@Override
	public void update() {
	
	y+=vely;
		
	}

	@Override
	public void render(Graphics g) {
		
	g.setColor(Color.white);
	g.fillRect(x, y, 12, 12);
	
		
	}
	
	

	@Override
	public Rectangle collision() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,12,12);
	}

}
