package com.tina.time;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class enemy extends Gameobject {

private Handler handler;
private Box box;
	public enemy(int x,int y,ID id,Box box) {

		super(x,y,id );
		this.box=box;
		
		/*for (int i = 0; i < 300; i++) {
			box.xQueue.add((float) 0.0);
			box.yQueue.add((float) 0.0);
		}*/
			
	}

	
	public void update() {
	
	
  //velx= box.xQueue.remove();
  //vely=box.yQueue.remove();
	x+=velx;
	y+=vely;
	
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(x, y, 45, 45);
		
	}

	@Override
	public Rectangle collision() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,45,45);
	}



}
