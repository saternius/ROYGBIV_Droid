package myrighttoplay.android.ROYGBIV;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Star {
    private Bitmap starBit;
	private int bitWidth;
	private int bitHeight;
	private GameView gameView;
	private int frame=1;
	Random rand=new Random();
	private boolean begin=true;
	public int startX;
	public int startY;
	public int change;
	private int startPos;
	private int xPos=0;
	public Rect dst;
	public int startSize;
	public int why;
	public int starColor;
	private boolean move;
	private int xSpeed;
	public int changer;
	private int dir=1;
	public int hex;
	public Star(Bitmap starBit, int starColor, int starSize, GameView gameView, boolean move){
    	this.starBit=starBit;
    	this.bitWidth=starBit.getWidth();
    	this.bitHeight=starBit.getHeight();
    	this.gameView=gameView;
    	this.starColor=starColor+1;
    	this.startPos=starColor*(bitHeight/5);
    	this.startSize=starSize;
    	this.move=move;
    }
    public void onDraw(Canvas canvas){
		if(begin){
    		begin=false;
    		startX=rand.nextInt(gameView.getWidth());
    		startY=gameView.getHeight();
    		if(move){
    			xSpeed=rand.nextInt(15);
    		}
    	}
    	animate();	
    	Rect src=new Rect(xPos,startPos,(bitWidth/4)+xPos,(bitHeight/5)+startPos);
        dst=new Rect(startX+changer,startY-change,startX+(bitWidth*startSize/50)+changer,startY+(bitWidth*startSize/50)-change);
        canvas.drawBitmap(starBit, src , dst, null);
    }
	private void animate() {
		why=startY-change;
		hex=startX+changer;
		xPos=frame*(bitWidth/4);
		frame++;
		if(frame>3){
			frame=0;
		}
		change+=10;
		changer+=xSpeed*dir;
		if(startX+(bitWidth*startSize/50)+changer>gameView.getWidth()){
			dir=-1;
		}
		if(startX+changer<1){
			dir=1;
		}
		
	}
}
