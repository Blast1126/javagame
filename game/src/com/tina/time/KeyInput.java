package com.tina.time;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	Handler handler;
	Box box;
	Player2 player2;
   

	public KeyInput(Handler handler,Box box,Player2 player2   ) {
	 
	this.handler=handler;	       
	//why we are not going to do Handler=new handler()   //beacuse we don't want to create a dulpicate of variables 
	this.box=box;
	this.player2=player2;
	
	}

	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();//it will get the key that you preessed 

for(int x=0;x<handler.object.size();x++ ){
	Gameobject temptobject=handler.object.get(x);

	if(temptobject.getId()==ID.player){
		if(key==KeyEvent.VK_W){
			
			handler.setUp(true);
			handler.setDirection("up");
		//	handler.addobject(new normalbullets(box.getX(),box.getY(),ID.normalbullets,handler));
		}
		if(key==KeyEvent.VK_S){
			
			handler.setDown(true);
			handler.setDirection("down");
		//	handler.addobject(new normalbullets(box.getX(),box.getY(),ID.normalbullets,handler));
		}

		if(key==KeyEvent.VK_A){
			
			handler.setLeft(true);
			handler.setDirection("left");
			//handler.addobject(new normalbullets(box.getX(),box.getY(),ID.normalbullets,handler));
			
		}

		if(key==KeyEvent.VK_D){
		
			handler.setRight(true);
			handler.setDirection("right");
			//handler.addobject(new normalbullets(box.getX(),box.getY(),ID.normalbullets,handler));

		}

		/*if(key==KeyEvent.VK_SPACE){
          handler.addobject(new normalbullets(box.getX(),box.getY(),ID.normalbullets,handler));
          
		}*/
		
		
	}
}

for(int i=0;i<handler.object.size();i++){

	Gameobject temptobject=handler.object.get(i);

	if(temptobject.getId()==ID.player2){

		if(key==KeyEvent.VK_UP){
          handler.setUp1(true);
		}
		if(key==KeyEvent.VK_DOWN){
         handler.setDown1(true);
		}
		if(key==KeyEvent.VK_RIGHT){
          handler.setRigh1t(true);
		}

		if(key==KeyEvent.VK_LEFT){
          handler.setLeft1(true);
		}
		
		/*if(key==KeyEvent.VK_ENTER){
			handler.addobject(new Crazybullet(player2.getX(),player2.getY(),ID.crazybullet,handler));
		}*/
	}
}
	}

	
	public void keyReleased(KeyEvent e){
		int key=e.getKeyCode();
		for(int x=0;x<handler.object.size();x++){
			
			Gameobject temptobject=handler.object.get(x);
			
			if(temptobject.getId()==ID.player){
				if(key==KeyEvent.VK_W){
				
					handler.setUp(false);
				
				}
				
				if(key==KeyEvent.VK_S){
					handler.setDown(false);
					
				}
				
				 if(key==KeyEvent.VK_D){
					handler.setRight(false);
					
				}
				
				 if(key==KeyEvent.VK_A){
					handler.setLeft(false);
					
				}
					 
			}
		}
	
	for(int i=0;i<handler.object.size();i++){

		Gameobject temptobject=handler.object.get(i);

		if(temptobject.getId()==ID.player2){

			if(key==KeyEvent.VK_UP){
	          handler.setUp1(false);
			}
			if(key==KeyEvent.VK_DOWN){
	         handler.setDown1(false);
			}
			if(key==KeyEvent.VK_RIGHT){
	          handler.setRigh1t(false);
			}

			if(key==KeyEvent.VK_LEFT){
	          handler.setLeft1(false);
			}
			
			
		}
	}
	
}
}
