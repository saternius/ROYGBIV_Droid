package myrighttoplay.android.ROYGBIV;

import java.util.List;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Kag {
    private Bitmap kagBit;
	private String kagTrail;
	private GameView gameView;
	Random rand = new Random();
	private boolean start=true;
	public int xPos;
	public Rect dstr;
	public int yPos;
	private int xDes;
	private int yDes;
	private int SphereX=0;
	private int SphereY=0;
	private List<Trail> trails;
	public Kag(Bitmap kagBit, String string, GameView gameView,List<Trail> trails){
    	this.kagBit=kagBit;
    	this.kagTrail=string;
    	this.gameView=gameView;
    	this.trails=trails;
    }
    public void onDraw(Canvas canvas){
    	
    	if(start){
    		start=false;
    		xPos=rand.nextInt(gameView.getWidth());
    		yPos=gameView.getHeight();
    	}
    	animate();
    	  Rect src=new Rect(0,0,kagBit.getWidth(),kagBit.getHeight());
          dstr=new Rect(xPos,yPos,xPos+(kagBit.getWidth()/3),yPos+(kagBit.getHeight()/3));
          canvas.drawBitmap(kagBit, src , dstr, null);
    	
    }
	private void animate() {
		SphereX=(int) gameView.ShpereXf;
		SphereY=(int) gameView.ShpereYf;
		if(SphereX>10){
		xDes=((SphereX/25)-xPos/25)*2;
		yDes=((SphereY/25)-yPos/25)*2;
		}
		xPos+=xDes*2;
		yPos+=yDes*2;
		trails.add(new Trail(kagTrail,xPos,yPos,2));
		
	}
}
