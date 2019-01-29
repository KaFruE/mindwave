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
	int a,b,c,d = 0;
	
	public void setup() {
	  size(1000,1000);

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
		  int x,y;
		  
		  a= 500;
          b= 500;

		  
		  //랜덤값 받아내기
		  for(int i=1; i<100000; i++){
		   
		  //Dimension dm = this.getSize();
/*		  text("Attention: " + attention,10,30);
		  text("Meditation: " + meditation,10,50); */
		  //int red = (int)(Math.random()*256);
		  //int green = (int)(Math.random()*256);
		  //int blue = (int)(Math.random() * 256);

		 // x = (int)(Math.random() * dm.getWidth()); //너비와 높이값 제한하기 
		 // y = (int)(Math.random() * dm.getHeight());		  
 
			  int max = 0;
	          int k = 0;
	          Delta = Delta /10;
	          Theta = Theta / 10;
	          int arr[] = {Delta, Theta, Low_alpha, High_alpha, Low_beta, High_beta,Low_gamma, Mid_gamma};
	          
	          for(int j=0; j<6; j++){
	        	 if(max<arr[j])
	      		{
	      			max = arr[j];
	      			k = j;
	      		}
	          }

	         

		 
/*		  if(meditation == 0 && attention == 0){y=y+3;}         // 아무 상태 아닐떄는 아래로 3씩
		  else if(attention>50 || meditation>50){             // 집중력 혹은 명상력이 50 이상일때     
		  	if(attention-meditation<0){x=x-3; y=y-3;}       // 집중력이 명상력 보다 클떄는 왼쪽 3 과 위로 둘다 3씩
		  	else if(attention-meditation>0){x=x+3; y=y-3;}        // 집중력과 명상력이 같을때는 위로 3씩
		  }
		  else if(attention-meditation>0){x=x+3; y=y+3;}             // 집중력이 명상력 보다 클떄는 오른쪽과 아래로 둘다 3씩
		  else if(attention-meditation<0){x=x-3; y=y+3;}       // 집중력이 명상력 보다 클떄는 왼쪽과 위로 둘다 3씩
		  else if(attention-meditation==0){x=x; y=y+3;}        // 집중력과 명상력이 같을때는 위로 3씩
		  
*/
		  /* x=x+attention-meditation;
		  y=y+(attention-meditation)+1; */

          
          Color color1 = new Color(255,0,0);
          Color color2 = new Color(255,128,0);
          Color color3 = new Color(255,255,0);
          Color color4 = new Color(0,255,0);
          Color color5 = new Color(0,0,255);
          Color color6 = new Color(128,0,255);
          
          if(arr[k] == arr[0])
          {
        	 g.setColor(color6);
          }
          else if(arr[k]==arr[1])
          {
        	  g.setColor(color5);
          }
          else if(arr[k]==arr[2])
          {
        	  g.setColor(color4);
          }
          else if(arr[k]==arr[3])
          {
        	  g.setColor(color3);
          }
          else if(arr[k]==arr[4])
          {
        	  g.setColor(color2);
          }
          else if(arr[k]==arr[5])
          {
        	  g.setColor(color1);
          }
          
        
          c = attention*10;
          d = meditation*10;
          
          
          g.drawLine(a,b,c,d);
		  
          a = c;
          b = d;
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
/*      println("delta Level: " + delta);
	  println("theta Level: " + theta);
	  println("low_alpha Level: " + low_alpha);
	  println("high_alpha Level: " + high_alpha);
	  println("low_beta Level: " + low_beta);
	  println("high_beta Level: " + high_beta);
	  println("low_gamma Level: " + low_gamma);
	  println("mid_gamma Level: " + mid_gamma);
	  */
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
