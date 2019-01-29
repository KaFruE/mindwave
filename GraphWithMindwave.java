package thinkgeardemo;

import processing.core.PApplet;
import processing.core.PFont;
import neurosky.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

import org.json.*;

public class ThinkGearDemo extends PApplet {
	
	public ThinkGearSocket neuroSocket;
	public int attention=10;
	public int meditation=10;
	public PFont font;
	public int Delta = 10;
	public int Theta = 10;
	public int High_alpha = 10;
	public int Low_alpha = 10;
	public int High_beta =10;
    public int Low_beta = 10;
    public int Mid_gamma = 10;
    public int Low_gamma = 10;
	
	public void setup(){
	  size(1000,800);
	  ThinkGearSocket neuroSocket = new ThinkGearSocket(this);

	  try {
	    neuroSocket.start();
	  } 
	  catch (Exception e) {
	    println("Is ThinkGear running??");
	  }
	  
	  smooth();
	  //noFill();
	  font = createFont("Verdana",12);
	  textFont(font);
	}
	
	 public void paint(Graphics g){
		  int x,y,w,h;
		  
		  //랜덤값 받아내기
		  for(int i=1; i<10000; i++){
		   
		  Dimension dm = this.getSize();
/*		  text("Attention: " + attention,10,30);
		  text("Meditation: " + meditation,10,50); */
		  //int red = (int)(Math.random()*256);
		  //int green = (int)(Math.random()*256);
		  //int blue = (int)(Math.random() * 256);

		 // x = (int)(Math.random() * dm.getWidth()); //너비와 높이값 제한하기 
		 // y = (int)(Math.random() * dm.getHeight());		  
		  
		  
		  x = i*5;
		  y = 5;
		  w = 5;
          h = 5;
		  if(i >= 1386){ y = 40;x = (i-1385)*5 ;}      // 그래프의 줄마다 달라지는 높이 및 시작 지점 설정 제어문
		  else if(i >= 1188){ y = 35; x = (i-1187)*5 ;}
		  else if(i >= 990){ y = 30; x = (i-989)*5 ;}
		  else if(i >= 792){ y = 25; x = (i-791)*5 ;}
		  else if(i >= 594){ y = 20; x = (i-593)*5 ;}
		  else if(i >= 198*2){ y = 5*3; x = (i-(198*2-1))*5 ;}
		  else if(i >= 198){ y = 10; x = (i-197)*5 ;}
		  
		  int k=40;
	        if(attention!=0){                                 // 집중력에 따른 그래프 투명도 분배
				  if(attention >= 80 ){
					  k=100;
				  }
				  else if(attention > 50)
				  {
					  k=80;
				  }
				  else if(attention > 30)
				  {
					  k=60;
				  }
				  else 
				  {
					k=40;
				  }
			  }
          Color color1 = new Color(255,0,0,k);
          Color color2 = new Color(255,128,0,k);
          Color color3 = new Color(255,255,0,k);
          Color color4 = new Color(0,255,0,k);
          Color color5 = new Color(0,0,255,k);
          Color color6 = new Color(128,0,255,k);
          
          if(meditation>=80){            // 명상력이 80 이상이면 노랑색
			  g.setColor(color6);
		  }
		  else if(meditation>=70)
		  {
			  g.setColor(color5);
		  }
		  else if(meditation>=60)
		  {
			  g.setColor(color4);
		  }
		  else if(meditation>=50)
		  {
			  g.setColor(color3);
		  }
		  else if(meditation>=40)
		  {
			  g.setColor(color2);
		  }
		  else
		  {
			  g.setColor(color1);
		  }
          
  
          

          g.fillRect(x, y, w, h);
/*
		  //사각형 그리기 
		  if(attention!=0){                                 // 집중력에 따른 그래프 높이 분배
			  if(attention >= 80 ){
				  h = 40;
				  y= y-35;
				  g.fillRect(x, y, w, h);
				  y = y+35;
			  }
			  else if(attention > 50)
			  {
				  h = 30;
				  y = y-25;
				  g.fillRect(x, y, w, h);
				  y = y+25;
			  }
			  else if(attention > 30)
			  {
				  h = 20;
				  y = y-15;
				  g.fillRect(x, y, w, h);
				  y = y+15;
			  }
			  else 
			  {
				  h = 5;
				  g.fillRect(x, y, w, h);
			  }
		  }
*/		  
		  
		 // g.fillOval(x, y, w, h); //원의 시작지점(x,y) 너비와 높이 (w,h). 원을 랜덤하게 그리기 
		  
		  try{
		   Thread.sleep(500);
		  }catch(Exception ee){
		   
		  }
		  
		  }
		  
		 }


	public void poorSignalEvent(int sig) {
	  println("SignalEvent "+sig);
	}

	public void attentionEvent(int attentionLevel) {
	  println("Attention Level: " + attentionLevel);
	  attention = attentionLevel;
	}


	public void meditationEvent(int meditationLevel) {
	  println("Meditation Level: " + meditationLevel);
	  meditation = meditationLevel;
	}

	public void blinkEvent(int blinkStrength) {

	  println("blinkStrength: " + blinkStrength);
	}

	 public void eegEvent(int delta, int theta, int low_alpha, int high_alpha, int low_beta, int high_beta, int low_gamma, int mid_gamma) {
	  println("Attention : " + attention);
	  println("Meditation : " + meditation);
      println("delta Level: " + delta);
	  println("theta Level: " + theta);
	  println("low_alpha Level: " + low_alpha);
	  println("high_alpha Level: " + high_alpha);
	  println("low_beta Level: " + low_beta);
	  println("high_beta Level: " + high_beta);
	  println("low_gamma Level: " + low_gamma);
	  println("mid_gamma Level: " + mid_gamma);
	     Delta = delta;
	     Theta = theta;
	     Low_alpha = low_alpha;
	     High_alpha = high_alpha;
	     Low_beta = low_beta;
	     High_beta = high_beta;
	     Low_gamma = low_gamma;
	     Mid_gamma = mid_gamma;
	}

	void rawEvent(int[] raw) {
	  //println("rawEvent Level: " + raw);
	}	

	public void stop() {
	  neuroSocket.stop();
	  super.stop();
	}

	
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { thinkgeardemo.ThinkGearDemo.class.getName() });
	}
}
