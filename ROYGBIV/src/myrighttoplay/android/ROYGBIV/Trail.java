package myrighttoplay.android.ROYGBIV;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


public class Trail {
private String color;
private float x;
private float y;

public int why=700;
private int trailSize;
private Paint paint;
int timer=150;


public Trail(String sphereTrail, float x, float y, int trailSize){
	   this.color=sphereTrail;
	   this.x=x;
	   this.y=y;
	   this.trailSize=trailSize;
	   paint = new Paint();
	   paint.setAntiAlias(true);
   }

    public void onDraw(Canvas canvas) {
    	if(color=="red"){
			paint.setColor(Color.RED);
		}else if(color=="orange"){
			paint.setColor(Color.rgb(255, 153, 0));
		}else if(color=="yellow"){
			paint.setColor(Color.rgb(255, 255, 0));
		}else if(color=="green"){
			paint.setColor(Color.GREEN);
		}else if(color=="blue"){
			paint.setColor(Color.BLUE);
		}else{ 
			paint.setColor(Color.rgb(155, 89, 255));
		}
    	update();
    	canvas.drawCircle(x+7, y, trailSize*2+4, paint);
       
    }

	private void update() {
		why=(int) y;
		y-=10;
		paint.setAlpha(timer);
		timer-=5;
	}
}
