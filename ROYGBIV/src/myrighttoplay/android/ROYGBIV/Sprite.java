package myrighttoplay.android.ROYGBIV;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Sprite {
	private int color;
	private int columns;
	private int rows;
	private Bitmap bit;
	private int x;
	public int y;
	private int frame=0;
	private boolean start=true;
	private int size;
	private int objective;
	private String score;
	private int starPoints;
	private int red;
	private int blue;
	private int green;
	private int timer=100;
	public boolean death=false;
	public Sprite(int color, int columns, int rows, Bitmap bit, int x, int y,int size,GameView game,int objective, int starPoints){
    	this.color=color;
    	this.columns=columns;
    	this.rows=rows;
    	this.bit=bit;
    	this.x=x;
    	this.y=y;
    	this.size=size;
    	this.objective=objective;
    	this.starPoints=starPoints;
    }
    public void onDraw(Canvas canvas){
    	if(objective==0){
    	Rect src=new Rect((bit.getWidth()/rows)*(color-1),(bit.getHeight()/columns)*frame,(bit.getWidth()/rows)*(color-1)+(bit.getWidth()/rows),((bit.getHeight()/columns)*frame)+bit.getHeight()/columns);
        Rect dstr=new Rect(x,y,x+(bit.getWidth()*size/30),y+(bit.getWidth()*size/30));
        canvas.drawBitmap(bit, src , dstr, null);
		frame++;
    	}else{
    		if(color==1 && start){
    			red=255;
    			green=124;
    			blue=124;
    		}else if(color==2 && start){
    			red=124;
    			green=176;
    			blue=255;
    		}else if(color==3 && start){
    			red=255;
    	    	green=247;
    	    	blue=182;
    		}else if(color==4&& start){
    			red=163;
    	    	green=231;
    	    	blue=130;
    		}else if(color==5 && start){
    			red=255;
    	    	green=195;
    	        blue=105;
    		}
    		 Paint paint = new Paint();
    	     paint.setColor(Color.rgb(red,green,blue));
    	     paint.setTextSize(20);
    	     paint.setAntiAlias(true);
    	     paint.setAlpha(timer);
    	     score="+"+starPoints;
    	     canvas.drawText(score, x, y, paint);
    	     start=false;
    	     timer-=3;
    	     if(timer<1){
    	    	 death=true;
    	     }
    	}
    	y-=10;
    }
	
}
