package myrighttoplay.android.ROYGBIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;

public class ROYGBIVActivity extends Activity {
	private GameView gameview;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	gameview=new GameView(this);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(1);
        setContentView(gameview);
        meathod();
    }
    private  void meathod() {
    	try {
    	    // open the file for reading
    	    InputStream instream = openFileInput("myfilename.txt");
    	 
    	    // if file the available for reading
    	    if (instream != null) {
    	      // prepare the file for reading
    	      InputStreamReader inputreader = new InputStreamReader(instream);
    	      BufferedReader buffreader = new BufferedReader(inputreader);
    	 
    	      String line = buffreader.readLine(); 
    	      if(line.length()>0){
    	      int highscore = Integer.parseInt(line);
    	       gameview.highscore=highscore;
    	      }
    	    }
    	 
    	    // close the file again
    	    instream.close();
    	  } catch (java.io.FileNotFoundException e) {
    	    // do something if the myfilename.txt does not exits
    	  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void SaveMe(String thing){
    	try {
  		  // open myfilename.txt for writing
  		  OutputStreamWriter out = new OutputStreamWriter(openFileOutput("myfilename.txt",0));
  		  // write the contents on mySettings to the file
  		  out.write(thing);
  		  // close the file
  		  out.close();
  		} catch (java.io.IOException e) {
  		  //do something if an IOException occurs.
  		}
    }
	
	@Override
    public boolean onTouchEvent(MotionEvent event) {
		 if (event.getAction() == MotionEvent.ACTION_UP) {
			  gameview.touch=false;
		 }
		float X=event.getX();
		float Y=event.getY()-(gameview.getHeight()/20);
		synchronized(gameview.getHolder()){	
		if(gameview.save){
			gameview.save=false;
			String string =""+gameview.points;
			SaveMe(string);
		}
			
		if(gameview.display=="instructions" && event.getAction() == MotionEvent.ACTION_DOWN){
			gameview.insFrame++;
		}
		if(gameview.display=="play"){	
		if (System.currentTimeMillis() - gameview.lastClick > 1) {
			gameview.lastClick = System.currentTimeMillis();
			gameview.ShpereXf=X-(gameview.sphereBit.getWidth()/16);
			gameview.ShpereYf=Y-(gameview.sphereBit.getHeight()/8);
		  if (event.getAction() == MotionEvent.ACTION_UP) {
			  gameview.touch=false;
			  gameview.ShpereXf=0;
			  gameview.ShpereYf=0;
	          if(gameview.loser){
	        	  gameview.checker=true;
	          }
		 }else{
			 if(!gameview.loser){
				 gameview.touch=true;	
			 }else{
				 if(X>this.gameview.getWidth()/2-(gameview.game_over.getWidth()/2)&& X<(this.gameview.getWidth()/2-(gameview.game_over.getWidth()/2)+gameview.game_over.getWidth())&&Y>this.gameview.getHeight()/2-(gameview.game_over.getHeight()/2)&& Y<(this.gameview.getHeight()/2-(gameview.game_over.getHeight()/2)+gameview.game_over.getHeight())&& gameview.checker){
					 gameview.trails.clear();
					 gameview.upgrades.clear();
					 gameview.stars.clear();
					 gameview.Bars.clear();
					 gameview.sprites.clear();
					 gameview.touch=false;
					 gameview.pain=0;
					 gameview.points=0;
					 gameview.level=0;
					 gameview.sphereFrame=1;	
					 gameview.maxHealth=1;
					 gameview.rejoice=2;
					 gameview.durability=5;
					 gameview.starMove=false;
					 gameview.red=1;
					 gameview.orange=1;
					 gameview.yellow=1;
					 gameview.green=1;
					 gameview.blue=1;
					 gameview.bars=false;
					 gameview.swager=false;
					 gameview.loser=false;
					 gameview.checker=false;
					 gameview.kags.clear();
					 gameview.colorUpgrade=0;
					 gameview.starTimer=0;
					 gameview.totalTimer=0;
					 gameview.barTimer=0;
					 gameview.kagTimer=0;
					 gameview.kagSpawn=40;
					 gameview.starSpawn=25;
					 gameview.barSpawn=65;	
					 gameview.endColor=255;
					 gameview.praiselvl=5;
					 gameview.prayz=0;
					 gameview.praiser=false;
					 gameview.voice.release();
					 if(gameview.music==1){
						 gameview.hlr.release();
						 gameview.hlr=MediaPlayer.create(this, R.raw.hlr);
						 gameview.hlr.start();
					 }
			   		int test=gameview.rand.nextInt(5)+1;
			   		gameview.changeColor(test);
			   		 if(X<this.gameview.getWidth()/2){
			   			gameview.display="null";
			   			gameview.hlr.pause();
			   			gameview.menuMp3.release();
			   			gameview.menuMp3= MediaPlayer.create(this, R.raw.menu_mp3);
			   			gameview.menuMp3.start();
			   		 }
				 }
			 }
		 }
	  }
	}
	else if(gameview.display=="null"){
		if(X>gameview.getWidth()/2-100 && Y> gameview.getHeight()/3 && X<gameview.getWidth()/2+75 && Y<gameview.getHeight()/2+200){
			int Red= gameview.rand.nextInt(255);
			int Green= gameview.rand.nextInt(255);
			int Blue = gameview.rand.nextInt(255);
			gameview.painter1.setColor(Color.rgb(Red, Green, Blue));
			
			if(event.getAction() == MotionEvent.ACTION_UP){
				int xPos = (int) X;
				int yPos = (int) Y;
				gameview.xTest=xPos;
				gameview.yTest=yPos;
				Rect hitter = new Rect(xPos,yPos,xPos+10,yPos+10);
				 if(gameview.music_dst.intersect(hitter)){
					if(gameview.music==1){
						gameview.music=0;
					}else{
						gameview.music=1;
					}
				}else if(gameview.sound_dst.intersect(hitter)){
					if(gameview.sound==1){
						gameview.sound=0;
					}else{
						gameview.sound=1;
					}
				}else if(gameview.instrunction_dst.intersect(hitter)){
					gameview.display="instructions";
				}
				else if(gameview.quality_dst.intersect(hitter)){
					gameview.qual--;
					if(gameview.qual<1){
						gameview.qual=4;
					}
				}
				else if(gameview.startRec.intersect(hitter)){
						gameview.display="play";	
					}
			}
			
		}else{
			gameview.painter1.setColor(Color.GRAY);
		}
		
	}}
		return true;
	}
    
	protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        gameview.gameLoopThread.running=true;
        gameview.music=1;
        gameview.sound=1;
    }
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        gameview.gameLoopThread.running=false;
        gameview.music=0;
        gameview.menuMp3.stop();
        gameview.hlr.stop();
        this.finish();
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.runFinalizersOnExit(true);
        System.exit(0);
        // The activity is about to be destroyed.
    }
}