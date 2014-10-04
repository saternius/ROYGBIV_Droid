package myrighttoplay.android.ROYGBIV;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Motivation {

	public Bitmap bit;
	public int timer=60;
	private GameView gv;

	public Motivation(Bitmap p1,GameView gv) {
		this.bit=p1;
		this.gv=gv;
	}
	public void onDraw(Canvas canvas){
		if(timer<30){
			timer++;
			int fHeight=gv.getHeight()/15;
			int Width= fHeight*bit.getWidth()/bit.getHeight();
			Rect src= new Rect(0,0,bit.getWidth(),bit.getHeight());
			Rect dst= new Rect((gv.getWidth()/2)-(Width/2),(gv.getHeight()/2)-(fHeight/2),(gv.getWidth()/2)+(Width/2),(gv.getHeight()/2)+(fHeight/2));
		    canvas.drawBitmap(bit,src,dst,null);
		}
	}

}
