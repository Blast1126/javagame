package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Gameobject  {

Handler handler;
	public Block(int x,int y,ID id,Handler handler ) {
	super(x,y,id);
	this.handler=handler;
	}


	@Override
	public void update() {
	
	
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(x, y, 150, 1000);
	
		
	}

	@Override
	public Rectangle collision() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,150,1000);
	}

}
