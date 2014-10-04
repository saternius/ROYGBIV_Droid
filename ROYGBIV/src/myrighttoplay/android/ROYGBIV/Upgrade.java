package myrighttoplay.android.ROYGBIV;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Upgrade {
    private Bitmap bit;
	public int bitHeight;
	public int bitWidth;
	Random rand=new Random();
	private GameView gameView;
	private boolean start=true;
	public int startX;
	public int startY;
	public int change=0;
	private int gameWidth;
	private int gameHeight;
	public int type;
	public Rect dst;
	public int why;
	public Upgrade(Bitmap bit, GameView gameView, int type){
		this.type=type;
		this.gameView=gameView;
    	this.bit=bit;
    	this.bitHeight=bit.getHeight();
    	this.bitWidth=bit.getWidth();
    }
	public void onDraw(Canvas canvas) {
		gameWidth=gameView.getWidth();
		gameHeight=gameView.getHeight();
		if(start){
			start=false;
			startX=rand.nextInt(gameWidth);
			startY=gameHeight;
		}
		update();
		Rect src=new Rect(0,0,bitWidth,bitHeight);
        dst=new Rect(startX,startY-change,startX+(bitWidth/8),startY+(bitHeight/8)-change);
        canvas.drawBitmap(bit, src , dst, null);
	}
	private void update() {
		change+=10;
		why=startY+(bitHeight/8)-change;
	}

}
