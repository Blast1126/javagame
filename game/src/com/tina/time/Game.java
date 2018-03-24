package com.tina.time;
import java.applet.AudioClip;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Box box ;
	private AudioClip clip;
	Player2 player2;
	Handler handler;
	Storage storage;
	public static int width=1500;
	public static int  height=1000;
	public int scale=3;
	private Thread gamethread;//sub process //Threads allow different tasks to be performed concurrently.
	private boolean running ;
	JFrame Frame;
	MouseLisetner menu;

	private BufferedImage image=null;
	BufferImage UFOimage;
	public Game() {
		
		Dimension size=new Dimension(width,height);
		this.setPreferredSize(size);//set the size for our Canvas
		
	    UFOimage =new  BufferImage ();	
		Frame=new JFrame();
		handler=new Handler();
		storage=new Storage(handler,box);
		box=new Box(720,800,ID.player,handler,storage,UFOimage);
		
		//player2=new Player2(1400,50,ID.player2,handler);
		BufferImage buffer =new BufferImage();
		menu=new MouseLisetner (handler,storage,box);
		this.addMouseListener(menu);
		this.addKeyListener(new KeyInput(handler,box,player2));
        
		handler.addobject(box);
		//handler.addobject(new Ammons(500,800,ID.bullet,handler,storage ));
		handler.addobject(new Healthminus(700,900,ID.damageobject,handler,storage));
		handler.addobject(new Healthminus(400,900,ID.damageobject,handler,storage));
		handler.addobject(new Healthminus(1000,900,ID.damageobject,handler,storage));

		//you have to do in the constructor y-p-down y-n-up
	}
	
	
	private void sound(String path) {
	

	}
	
	
	
	public synchronized void start(){//to prevent thread interfernce 
        running=true;
		gamethread=new Thread(this);//thread is attached to the game class
        gamethread.start();//we start the thread 
        
	}
	
	public synchronized void stop(){
		running=false;
		try{
			gamethread.join();
		}catch(InterruptedException e){
			e.printStackTrace();//print exception to the console .
		}
	}

	@Override
	public void run() {//when we start the thread,it's going to run the run method 
		// TODO Auto-generated method stub
		this.requestFocus();
		while(running){
			
		
			render();
			update();
			
			
			 
		}
	}
	

	
	
	public void render(){
		
		BufferStrategy bs=getBufferStrategy();//is a temporary place to store data
		
		
		
		if(bs==null){
			this.createBufferStrategy(3);//we want to create 3 buffer ,so we can render picture faster ,3 is maximum buffer that you can get
			return;//get out of if statement
		}
	//	 The getDrawGraphics creates a Graphics object that will draw to one of the buffers, 
		//if you are using 2 or more buffers this will be an offscreen buffer, 
		//allowing you to draw everything completely before displaying it 
		//which eliminates flickering and allows you to clear the buffer without the user noticing, 
		//////////////////////////////////////////
		Graphics  g=bs.getDrawGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
		if(menu.state==Gamestate.game){
			
			
			 handler.render(g);
		storage.renderhealth(g);
		storage.Loadlevel();
		menu.end=true;}
	
		if(menu.state==Gamestate.menu){
			menu.rendermenu(g);
		
			}
		
		
		if(storage.health<=0){
	      menu.state=Gamestate.gameover;
	      menu.rendergameover(g);  
	      storage.health=0;
		}
		
		
		/////////////////////////////////////////
		g.dispose();//at the end of frame you need to remove the graphic,
		//Because graphic from each frame is not going to be  removed  
		bs.show();//make the next buffer visible
	}
	
	
	
	

	
	
	public void update(){
		
		if(menu.state==Gamestate.game){
		handler.update();
	
		
       
		}
		
	}
	
	
	

	
	/*private void loadlevel (BufferedImage image){
		// for loop runs the size of image time
	int height=image.getHeight();
	int width=image.getWidth();
	int pixels; 
	int red,green,blue ;
	
	for(int y=0;y<height;y++){
		for(int x=0;x<width;x++ ){
			
			pixels=image.getRGB(x, y);
			
			 red=(pixels>>17)&0xff;
			 
			 blue=(pixels)&0xff;
			 
			if(red==255){
				handler.addobject(new Block(x*32,y*32,ID.Block));
			}
			
			if(blue==255){
				handler.addobject(new Box(x*32,y*32,ID.player,handler));
			}
		}
	}
		
		
	}*/
	
  

	public static void main(String[] args) {
		
	
		Game game=new Game();
	
		game.Frame.setResizable(false);
		game.Frame.setTitle("2D Cube");
		game.Frame.add(game);//we add the canvas to the game 
		game.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.Frame.pack();//frame changes the size for the canvas
		game.Frame.setLocationRelativeTo(null);
		game.Frame.setVisible(true);
		
		game.start();
	}
}
