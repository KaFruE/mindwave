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
    public static final int DELTA = 1;
    public static final int ARC_ANGLE = 20;
    public static final int PREF_W = 1000;
    public static final int PREF_H = PREF_W;
    public static final int LOOP_MAX = 100000;
	int c,d = 0;
	int a,b,e,f;
	int x=0;
	int y=0;
	public void setup() {
	  size(2000,1000);

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
		 
		 int x = PREF_W / 2;
		  int y = PREF_H /2;
		  int width = 1;
		  int height = 1;
		  int startAngle = 0;
		  int arcAngle = ARC_ANGLE;
		  int result=0;
		  int result_width = 0;
		  
		  for (int i = 0; i < LOOP_MAX; i++) {

			  if(attention>meditation)
			  {
				  result_width = attention/10;
			  }
			  else if(attention==meditation)
			  {
				  result_width = 5;
			  }
			  else
			  {
				  result_width = -(meditation/10);
			  }
			  g.drawArc(x, y, width, height, startAngle, arcAngle);
			  x = x - DELTA;
			  y = y - DELTA;
			  
			  if(result_width<1)
			  {
				  result_width = 1;
			  }
			  
			  width += 1 * (result_width) ;
			  height += 1 * (result_width) ;

			  //height += 2* DELTA;
			  startAngle = startAngle - arcAngle;
			  try{
				   Thread.sleep(200);
				  }catch(Exception ee){
				   
				  }
				  
		  }
		  
	/*	  a = 500;
          b = 400;
     
          
		  
		  //랜덤값 받아내기
		  for(int i=1; i<100000; i++){
		   
		  //Dimension dm = this.getSize();
		  text("Attention: " + attention,10,30);
		  text("Meditation: " + meditation,10,50); 
		  //int red = (int)(Math.random()*256);
		  //int green = (int)(Math.random()*256);
		  //int blue = (int)(Math.random() * 256);

		 // x = (int)(Math.random() * dm.getWidth()); //너비와 높이값 제한하기 
		 // y = (int)(Math.random() * dm.getHeight());		  
 
			  int max = 0;
			  int k=0;

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

	         

		 
		  if(meditation == 0 && attention == 0){y=y+3;}         // 아무 상태 아닐떄는 아래로 3씩
		  else if(attention>50 || meditation>50){             // 집중력 혹은 명상력이 50 이상일때     
		  	if(attention-meditation<0){x=x-3; y=y-3;}       // 집중력이 명상력 보다 클떄는 왼쪽 3 과 위로 둘다 3씩
		  	else if(attention-meditation>0){x=x+3; y=y-3;}        // 집중력과 명상력이 같을때는 위로 3씩
		  }
		  else if(attention-meditation>0){x=x+3; y=y+3;}             // 집중력이 명상력 보다 클떄는 오른쪽과 아래로 둘다 3씩
		  else if(attention-meditation<0){x=x-3; y=y+3;}       // 집중력이 명상력 보다 클떄는 왼쪽과 위로 둘다 3씩
		  else if(attention-meditation==0){x=x; y=y+3;}        // 집중력과 명상력이 같을때는 위로 3씩
		  

		  x=x+attention-meditation;
		  y=y+(attention-meditation)+1; 

          
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
          
          if(attention>90)
          {
        	  y=500;
          }
          else if(attention>80)
          {
        	  y=450;
          }
          else if(attention>70)
          {
        	  y=400;
          }
          else if(attention>60)
          {
        	  y=350;
          }
          else if(attention>50)
          {
        	  y=300;
          }
          else if(attention>40)
          {
        	  y=250;
          }
          else if(attention>30)
          {
        	  y=200;
          }
          else if(attention>20)
          {
        	  y=150;
          }
          else if(attention>10)
          {
        	  y=100;
          }
          else 
          {
        	  y=50;
          }
          //y = attention;
         x++;
         
         if(x==1)
         {
        	 e=0;
         }
         else if(x==2)
         {
        	 e=180;
        	 x=0;
         }

         c=y;
         d=y;
         f=180;
         println("a : "+a);
         println("b : "+b);
         println("c : "+c);
         println("d : "+d);
         g.drawArc(a,  b,  c,  d ,e ,f);
          a = a+c;
          b = b+ d/2;
          
          println("a! : "+a);
          println("b! : "+b);
          println("c! : "+c);
          println("d! : "+d);
		 // g.fillOval(x, y, w, h); //원의 시작지점(x,y) 너비와 높이 (w,h). 원을 랜덤하게 그리기 
		 */

		  }
		  
//		 }


	public void poorSignalEvent(int sig) {
	 // println("SignalEvent "+sig);
	}

	public void attentionEvent(int attentionLevel) {
	 // println("Attention Level: " + attentionLevel);
	  attention = attentionLevel;
	}


	public void meditationEvent(int meditationLevel) {
	 // println("Meditation Level: " + meditationLevel);
	  meditation = meditationLevel;
	}

	public void blinkEvent(int blinkStrength) {

	 // println("blinkStrength: " + blinkStrength);
	}

	 public void eegEvent(int delta, int theta, int low_alpha, int high_alpha, int low_beta, int high_beta, int low_gamma, int mid_gamma) {
	 // println("Attention : " + attention);
	//  println("Meditation : " + meditation);
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
	  println("rawEvent Level: " + raw);
	}	

	public void stop() {
	  neuroSocket.stop();
	  super.stop();
	}

	
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { thinkgeardemo.ThinkGearDemo.class.getName() });
	}
}
