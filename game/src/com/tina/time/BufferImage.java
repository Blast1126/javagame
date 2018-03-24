package com.tina.time;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferImage {
BufferedImage image=null; 

	public BufferImage() {
		// TODO Auto-generated constructor stub
	}

	public BufferedImage getimage(String path){
		try {
			image=ImageIO.read((new File(path)));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

}
