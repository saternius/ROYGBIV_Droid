package myrighttoplay.android.ROYGBIV;

import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Bar {
public List<Bar> Bars;
private GameView gameView;
private int type;
private Bitmap bit;
private boolean start=true;
public int yPos;
private Rect dst;
private Rect orb_rect;
public Bar(List<Bar> temps, GameView gameView,int type, Bitmap bit){
	  this.Bars=temps;
	  this.gameView=gameView;
	  this.type=type;
	  this.bit=bit;
  }
  public void onDraw(Canvas canvas){
	  if(start){
		  start=false;
		  yPos=gameView.getHeight();
	  }
	  Rect src=new Rect(0,0,2,2);
      dst=new Rect(0,yPos,gameView.getWidth(),yPos+(gameView.getHeight()/50));
      canvas.drawBitmap(bit, src , dst, null);
	  animate();
  }
private void animate() {
	yPos-=10;
	orb_rect=gameView.dst;
	if(orb_rect.intersect(dst) && type!=gameView.color){
		if(gameView.sound==1){
		gameView.hurt2.start();
		}
		gameView.pain+=(gameView.strength/10)*2;
	}
}
}
