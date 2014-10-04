package myrighttoplay.android.ROYGBIV;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;




import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView {
	public List<Trail> trails = new ArrayList<Trail>();
	public List<Upgrade> upgrades = new ArrayList<Upgrade>();
	public List<Star> stars = new ArrayList<Star>();
	public List<Bar> Bars = new ArrayList<Bar>();
	public List<Kag> kags = new ArrayList<Kag>();
	public List<Sprite> sprites = new ArrayList<Sprite>();
	public List<Bitmap> bitz = new ArrayList<Bitmap>();
	//public List<MediaPlayer> mp = new ArrayList<MediaPlayer>();
	private SurfaceHolder holder;
	public GameLoopThread gameLoopThread;
	Bitmap sphereBit;
	boolean touch=false;
	private String sphereTrail;
	long lastClick;
	public int SphereX;
	public int SphereY;
	public float ShpereXf;
	public float ShpereYf;
	private int sphereWidth;
	private int sphereHeight;
	private Bitmap healthpanel;
	private int panelWidth;
	private int panelHeight;
	private Bitmap healthBar;
	public int pain=0;
	int colorUpgrade;
	public int points=0;
	public int sphereFrame=1;
	public String score="Score: "+points;
	Random rand = new Random();
	private int typ;
	public int color=1;
	int maxHealth=1;
	int rejoice=20;
	public int durability=50;
	int starTimer;
	private Bitmap starBit;
	private Rect src;
	public Rect dst;
	public int strength=100;
	private int colorSpawn;
	int starSpawn;
	boolean starMove=false;
	private boolean move;
	int totalTimer;
	int level;
	private int trailSize;
    int red=1;
    int orange=1;
    int yellow=1;
    int green=1;
    int blue=1;
	int barTimer;
	int barSpawn=65;
	boolean bars=false;
	boolean swager=false;
	int kagSpawn;
	int kagTimer;
	private Bitmap explosions;
	private Bitmap kag_explosion;
	boolean loser=false;
	Bitmap game_over;
	private String BestColor;
	private int redP;
	private int blueP;
	private int yellowP;
	private int greenP;
	private int orangeP;
	boolean checker=false;
	Paint painter1;
    public  String display="null";
	private Bitmap instructions_p1;
	int insFrame=1;
	private Bitmap instructions_p2;
	private Bitmap instructions_p3;
	private Bitmap instructions_p4;
	
	MediaPlayer menuMp3;
	MediaPlayer hlr;
	MediaPlayer upgrade;
	MediaPlayer star;
	MediaPlayer hurt;
	MediaPlayer hurt2;

	private Bitmap sound_options;
	public int music=1;
	public int sound=1;
	Rect music_dst;
	Rect sound_dst;
	float xTest=100;
	float yTest=100;
	Rect instrunction_dst;
	public int endColor=255;
	private Bitmap p1;
	private Bitmap p2;
	private Bitmap p3;
	private Bitmap p4;
	private Bitmap p5;
	private Bitmap p6;
	private Bitmap p7;
	private Motivation praise;
	public boolean praiser;
	public int praiselvl=5;
	public int prayz=0;
	public int highscore=0;
	public boolean save;
	private Bitmap title;
	private int flTimer;
	MediaPlayer voice;
	private Context context;
    Rect quality_dst;
	public int qual=4;
	Rect startRec;
	public GameView(Context context) {
		super(context);
		gameLoopThread=new GameLoopThread(this);
		holder=getHolder();
		holder.addCallback(new Callback() {
			
			public void surfaceDestroyed(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				
			}
			
			public void surfaceCreated(SurfaceHolder holder) {
			  gameLoopThread.setRunning(true);
			  gameLoopThread.start();
			}
			
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				// TODO Auto-generated method stub
				
			}
		});
		
		menuMp3= MediaPlayer.create(context, R.raw.menu_mp3);
		hlr= MediaPlayer.create(context, R.raw.hlr);
		upgrade= MediaPlayer.create(context, R.raw.eoeu);
		upgrade.setLooping(false);
		star= MediaPlayer.create(context, R.raw.uee);
		star.setLooping(false);
		hurt= MediaPlayer.create(context, R.raw.ugh);
		hurt.setLooping(false);
		hurt2= MediaPlayer.create(context, R.raw.errg);
		hurt2.setLooping(false);
		
		sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.red_orb1);
	    sphereTrail="red";
	    healthpanel= BitmapFactory.decodeResource(getResources(), R.drawable.healthbar);
	    healthBar=BitmapFactory.decodeResource(getResources(), R.drawable.healthsquare);
	    starBit=BitmapFactory.decodeResource(getResources(), R.drawable.stars);
	    explosions=BitmapFactory.decodeResource(getResources(), R.drawable.explosion);
	    kag_explosion=BitmapFactory.decodeResource(getResources(), R.drawable.puple_splosion);
	    game_over=BitmapFactory.decodeResource(getResources(), R.drawable.game_over);
	    instructions_p1= BitmapFactory.decodeResource(getResources(), R.drawable.tester);
	    instructions_p2=BitmapFactory.decodeResource(getResources(), R.drawable.instructions_p2);
	    instructions_p3=BitmapFactory.decodeResource(getResources(), R.drawable.instructions_p3);
	    instructions_p4=BitmapFactory.decodeResource(getResources(), R.drawable.instructions_pt4);
	    sound_options=BitmapFactory.decodeResource(getResources(), R.drawable.sound_options);
	    title= BitmapFactory.decodeResource(getResources(), R.drawable.title);
	    p1=BitmapFactory.decodeResource(getResources(), R.drawable.praise_keepitup);
	    p2=BitmapFactory.decodeResource(getResources(), R.drawable.praise_good);
	    p3=BitmapFactory.decodeResource(getResources(), R.drawable.praise_greatjob);    
	    p4=BitmapFactory.decodeResource(getResources(), R.drawable.praise_super);	    
	    p5=BitmapFactory.decodeResource(getResources(), R.drawable.praise_awsome);	    
	    p6=BitmapFactory.decodeResource(getResources(), R.drawable.praise_fantastic);    
	    p7=BitmapFactory.decodeResource(getResources(), R.drawable.praise_bodacious);
	    bitz.add(p1);
	    bitz.add(p2);
	    bitz.add(p3);
	    bitz.add(p4);
	    bitz.add(p5);
	    bitz.add(p6);
	    bitz.add(p7);
	    praise=new Motivation(p1,this);
	    panelWidth=healthpanel.getWidth();
	    panelHeight=healthpanel.getHeight();
	    sphereWidth=sphereBit.getWidth();
	    sphereHeight=sphereBit.getHeight();
	    colorSpawn=50;
	    starSpawn=25;
	    kagSpawn=100;
	    painter1 = new Paint();
	     painter1.setColor(Color.WHITE);
	     painter1.setTextSize(18);
	     painter1.setAntiAlias(true);
	     this.context=context;
	     changeColor(rand.nextInt(5)+1);
	    
	}
	protected void onDraw(Canvas canvas){
		
		if(music==1 && display!="play"){
		     menuMp3.start();
		     
		     }else{
		    	 menuMp3.pause();
		}
	
		
		if(display=="play"){	
		
			
		
			
			
		if(music==1){
			hlr.start();
		}
		
		if(!loser){	
		canvas.drawColor(Color.WHITE);
		}else{
		canvas.drawColor(Color.rgb(endColor, endColor, endColor));
		if(endColor>14){
			endColor-=10;
		}
		}
		objectUpdate();
		SphereX = (int)ShpereXf;
		SphereY = (int)ShpereYf;
		
		

		Rect src2=new Rect(0,0,panelWidth,panelHeight);
        Rect dst2=new Rect(0,0,this.getWidth(),this.getHeight()/10);
        if(flTimer>0 && qual>3){
        flash(canvas);
        }
        if(qual!=1){
		for (Trail pathway : trails) {
            pathway.onDraw(canvas);
        }
        }
		for (Upgrade oneUp : upgrades) {
            oneUp.onDraw(canvas);
        }
		for (Star sparkle: stars){
			sparkle.onDraw(canvas);
		}
		for(Bar bars: Bars){
			bars.onDraw(canvas);
		}
		for(Kag kagr: kags){
			kagr.onDraw(canvas);
		}
		if(qual>2){
		for(Sprite coke: sprites){
			coke.onDraw(canvas);
		}
		}
		
		
		praise.onDraw(canvas);
		
		
		
		
		
		
		
		
		
		if(touch && !loser){
			
			src=new Rect(0,0,sphereWidth,sphereHeight);
	        dst=new Rect(SphereX-(sphereWidth/12),SphereY,SphereX+(sphereWidth/3)-(sphereWidth/12),SphereY+(sphereHeight/3));
	        canvas.drawBitmap(sphereBit, src , dst, null);
		}else{
			dst= new Rect(-300,-200,-300,-200);
		}
		
		//int painer= (int)pain*(this.getWidth()/200);
		int painerz=384-pain;
		Rect src3=new Rect(0,0,2,2);
        Rect dst3=new Rect(this.getWidth()*10/95,this.getHeight()/100,this.getWidth()*painerz/400,this.getHeight()*1/11);
        Paint panl = new Paint();
        panl.setColor(Color.rgb(205, 206, 207));
        canvas.drawRect(dst2, panl);
        canvas.drawBitmap(healthBar, src3 , dst3, null);
        canvas.drawBitmap(healthpanel, src2 , dst2, null);
       
        
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(10);
        paint.setAntiAlias(true);
        Paint plaint = new Paint();
        plaint.setColor(Color.WHITE);
        plaint.setTextSize(15);
        plaint.setAntiAlias(true);
        Paint paintr = new Paint();
        paintr.setTextSize(10);
        paintr.setAntiAlias(true);
        score="Score: "+points+" Level:"+level;
        canvas.drawText(score, this.getWidth()*1/4, this.getHeight()/35, plaint);
        if(loser){
        	starSpawn=0;
        	if(redP>blueP && redP>yellowP && redP>greenP && redP>orangeP){
        		BestColor="Red";
        		paintr.setColor(Color.RED);
        	}else if(blueP>redP && blueP>yellowP && blueP>greenP && blueP>orangeP){
        		BestColor="Blue";
        		paintr.setColor(Color.BLUE);
        	}else if(yellowP>blueP && yellowP>redP && yellowP>greenP && yellowP>orangeP){
        		BestColor="Yellow";
        		paintr.setColor(Color.YELLOW);
        	}else if(greenP>blueP && greenP>yellowP && greenP>redP && greenP>orangeP){
        		BestColor="Green";
        		paintr.setColor(Color.GREEN);
        	}else{
        		BestColor="Orange";
        		paintr.setColor(Color.rgb(255, 195, 105));
        	}
        	if(points>highscore){
        		save=true;
        		highscore=points;
        	}
        	canvas.drawBitmap(game_over,this.getWidth()/2-(game_over.getWidth()/2),this.getHeight()/2-(game_over.getHeight()/2), null);
            String mLevel="You reached level "+level;
            String mScore="While accumulating "+points+" points";
            String mColor="Your power seems to rely";
            String mColor2="on the color ";
            canvas.drawText(mLevel, this.getWidth()*1/4, this.getHeight()/2-25, paint);
            canvas.drawText(mScore, this.getWidth()*1/4, this.getHeight()/2, paint);
            canvas.drawText(mColor, this.getWidth()*1/4, this.getHeight()/2+25, paint);
            canvas.drawText(mColor2, this.getWidth()*1/4, this.getHeight()/2+50, paint);
            canvas.drawText(BestColor, this.getWidth()*1/4+80, this.getHeight()/2+50, paintr);
            hlr.setVolume(0, 0);
        }
        TrailUpdate();
		}else if(display=="instructions"){
			canvas.drawColor(Color.WHITE);
	        if(insFrame==1){
	        Rect src5=new Rect(0,0,instructions_p1.getWidth(),instructions_p1.getHeight());
		    Rect dst5=new Rect(0,0,this.getWidth(),this.getHeight());
	        canvas.drawBitmap(instructions_p1,src5,dst5,null);
	        }else if(insFrame==2){
	        Rect src5=new Rect(0,0,instructions_p2.getWidth(),instructions_p2.getHeight());
		    Rect dst5=new Rect(0,0,this.getWidth(),this.getHeight());
	        canvas.drawBitmap(instructions_p2,src5,dst5,null);
	        }else if(insFrame==3){
	        Rect src5=new Rect(0,0,instructions_p3.getWidth(),instructions_p3.getHeight());
		    Rect dst5=new Rect(0,0,this.getWidth(),this.getHeight());
	        canvas.drawBitmap(instructions_p3,src5,dst5,null);
	        }else if(insFrame==4){
	        	Rect src5=new Rect(0,0,instructions_p4.getWidth(),instructions_p4.getHeight());
			    Rect dst5=new Rect(0,0,this.getWidth(),this.getHeight());
		        canvas.drawBitmap(instructions_p4,src5,dst5,null);
	        }else{
	        	display="null";
	        	insFrame=1;
	        }
		}else{
			System.currentTimeMillis();
			Rect titleDim= new Rect(0,0,title.getWidth(),title.getHeight());
			 Rect titleSize=new Rect(0,0,this.getWidth(), this.getHeight());
			 canvas.drawBitmap(title,titleDim,titleSize,null);
			 Paint paintr = new Paint();
		        paintr.setTextSize(12);
		        paintr.setAntiAlias(true);
		        painter1.setColor(Color.WHITE);
		     String quality="Best";
		     if(qual==3){
		    	 quality="High";
		     }else if(qual==2){
		    	 quality="Medium";
		     }else if(qual==1){
		    	 quality="Low";
		     }
		     canvas.drawText("Start", this.getWidth()/2-20, this.getHeight()*2/5, painter1);
		     canvas.drawText("Instructions", this.getWidth()/2-54, this.getHeight()*2/5+45, painter1);
		     canvas.drawText("Quality: "+quality, this.getWidth()/2-56, ((this.getHeight()*2/5+45)+(this.getHeight()/2+90))/2, painter1);
		     instrunction_dst=new Rect(this.getWidth()/2-57,this.getHeight()*2/5+30,this.getWidth()*2/3,this.getHeight()*2/5+60);
		     quality_dst=new Rect(this.getWidth()/2-57,-15+((this.getHeight()*2/5+45)+(this.getHeight()/2+90))/2,this.getWidth()*2/3,12+((this.getHeight()*2/5+45)+(this.getHeight()/2+90))/2);
		     startRec = new Rect(this.getWidth()/2-57,(this.getHeight()/3),this.getWidth()*2/3,(this.getHeight()*2/5)+5);

		    /* Paint painttest = new Paint();
		     painttest.setColor(Color.RED);
		     canvas.drawRect(instrunction_dst, painttest);
		     painttest.setColor(Color.GREEN);
		     canvas.drawRect(startRec, painttest);
*/
		     
		     
		     int music_bitWidth;
		     int music_bitHeight;
		     int width_start;
		     int height_start;
		     int music_bitWidth2;
		     int music_bitHeight2;
		     int width_start2;
		     int height_start2;
		     if(music==1){
		    	 width_start=0;
		    	 height_start=0;
		    	 music_bitHeight=sound_options.getHeight()/2;
		    	 music_bitWidth=sound_options.getWidth()/2;
		     }else{
		    	 width_start=0;
		    	 height_start=sound_options.getHeight()/2;
		    	 music_bitHeight=sound_options.getHeight();
		    	 music_bitWidth=sound_options.getWidth()/2;
		     }
		     if(sound==1){
		    	 width_start2=sound_options.getWidth()/2;
		    	 height_start2=0;
		    	 music_bitHeight2=sound_options.getHeight()/2;
		    	 music_bitWidth2=sound_options.getWidth();
		     }else{
		    	 width_start2=sound_options.getWidth()/2;
		    	 height_start2=sound_options.getHeight()/2;
		    	 music_bitHeight2=sound_options.getHeight();
		    	 music_bitWidth2=sound_options.getWidth();
		     }
		     Rect src5=new Rect(width_start,height_start,music_bitWidth,music_bitHeight);
		     int sound_size=this.getHeight()/10;
			 music_dst=new Rect(this.getWidth()/2-(this.getWidth()/6),this.getHeight()*3/4,this.getWidth()/2-(this.getWidth()/6)+sound_size,this.getHeight()*3/4+sound_size);
			 Rect src=new Rect(width_start2,height_start2,music_bitWidth2,music_bitHeight2);
			 sound_dst=new Rect(this.getWidth()/2+(this.getWidth()/12),this.getHeight()*3/4,this.getWidth()/2+sound_size+(this.getWidth()/12),this.getHeight()*3/4+sound_size);
			 canvas.drawBitmap(sound_options,src,sound_dst,null);
		     canvas.drawBitmap(sound_options,src5,music_dst,null);
		     String HighScore = "Highscore: "+highscore;
		     canvas.drawText(HighScore, (this.getWidth()/2)-(HighScore.length()*4)-4, this.getHeight()/2+90, painter1);
		     canvas.drawText("Menu Music By: Drury Graham", this.getWidth()-170, this.getHeight()-22, paintr);
		     
		}
  }

	private void objectUpdate() {
		synchronized(getHolder()){
			sphereChange();
   		 colorUpgrade++;
   		 starTimer++;
   		 totalTimer++;
   		 barTimer++;
   		 kagTimer++;
   		 if(totalTimer>30 && !loser){
   			 totalTimer=0;
   			 if(starSpawn>3){
   			 starSpawn--;
   			 }
   			 if(barSpawn>7 && bars){
   				 barSpawn--;
   			 }
   			 if(kagSpawn>250 && swager){
   				 kagSpawn-=10;
   			 }
   			 level++;
   			 praiser=true;
   			 points+=(level*5)+500;
   		 }
   		 if(level==praiselvl && praiser && prayz<6){
   			praise.bit=bitz.get(prayz);
   			if(sound==1){
   				if(prayz==0){
   				voice= MediaPlayer.create(context, R.raw.lolipop);
   				voice.setLooping(false);
   				voice.start();
   				}else if(prayz==1){
   				voice.release();
   			    voice= MediaPlayer.create(context, R.raw.getn);
   	   			voice.setLooping(false);
   	   			voice.start();
   				}else if(prayz==2){
   					voice.release();
   	   			    voice= MediaPlayer.create(context, R.raw.timneric);
   	   	   			voice.setLooping(false);
   	   	   			voice.start();
   				}else if(prayz==3){
   					voice.release();
   	   			    voice= MediaPlayer.create(context, R.raw.epic);
   	   	   			voice.setLooping(false);
   	   	   			voice.start();
   				}
   				else if(prayz==4){
   					voice.release();
   	   			    voice= MediaPlayer.create(context, R.raw.blowshom);
   	   	   			voice.setLooping(false);
   	   	   			voice.start();
   				}else if(prayz==5){
   					voice.release();
   	   			    voice= MediaPlayer.create(context, R.raw.kantaztic);
   	   	   			voice.setLooping(false);
   	   	   			voice.start();
   				}else{
   					voice.release();
   	   			    voice= MediaPlayer.create(context, R.raw.bowdaysheus);
   	   	   			voice.setLooping(false);
   	   	   			voice.start();
   				}
   			}
   			 praise.timer=0;
   			 praiselvl+=8;
   			 praiser=false;
   			 prayz++;
   		 }
   		 if(level>7){
   			 starMove=true;
   		 }
   		 if(level>14){
   			 bars=true;
   		 }
   		 if(level>30){
   			 swager=true;
   		 }
   		 
   		 if(kagTimer>kagSpawn && swager){
   			 kagTimer=0;
   			 Bitmap kagBit=BitmapFactory.decodeResource(getResources(), R.drawable.kag);
   			 kags.add(new Kag(kagBit,"purple",this,trails));
   		 }
   		 if(barTimer>barSpawn && bars){
   			 barTimer=0;
   			 int tipe=rand.nextInt(5)+1;
   			 Bitmap bit;
   			 if(tipe==1){
   				 bit=BitmapFactory.decodeResource(getResources(), R.drawable.healthsquare);
   			 }else if(tipe==2){
   				bit=BitmapFactory.decodeResource(getResources(), R.drawable.blue_bar);
   			 }else if(tipe==3){
   				bit=BitmapFactory.decodeResource(getResources(), R.drawable.yellow_bar);
   			 }else if(tipe==4){
   				bit=BitmapFactory.decodeResource(getResources(), R.drawable.green_bar);
   			 }else{
   				bit=BitmapFactory.decodeResource(getResources(), R.drawable.orange_bar);
   			 }
   			 Bars.add(new Bar(Bars,this,tipe,bit));
   			 
   		 }
   		 if(colorUpgrade>colorSpawn){
   			 colorUpgrade=0;
   			typ= rand.nextInt(5)+1;
   			upgrades.add(new Upgrade(Culorz(typ),this,typ));
   		 }
   		 if(starTimer>starSpawn){
   			 starTimer=0;
   			 int movement=rand.nextInt(2)+1;
   			 if(movement>1 && starMove){
   			     move=true;
   			 }else{
   				 move=false;
   			 }
   			 int starTyp = rand.nextInt(5);
   			 int starSize = rand.nextInt(7)+1;
   			 stars.add(new Star(starBit,starTyp,starSize,this,move));
   		 }
        }
	}
	private Bitmap Culorz(int type) {
		Bitmap bitz;
		if(type==1){
			 bitz = BitmapFactory.decodeResource(getResources(), R.drawable.red_upgrade);
		}else if(type==2){
			 bitz = BitmapFactory.decodeResource(getResources(), R.drawable.blue_upgrade);
		}else if(type==3){
			 bitz = BitmapFactory.decodeResource(getResources(), R.drawable.yellow_upgrade);
		}else if(type==4){
			 bitz = BitmapFactory.decodeResource(getResources(), R.drawable.green_upgrade);
		}else{
			 bitz = BitmapFactory.decodeResource(getResources(), R.drawable.orange_upgrade);
		}
		return bitz;
	}
	private void sphereChange() {
		if(color==1){
		if(sphereFrame==1){
			sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.red_orb1);
		}else if(sphereFrame==2){
			sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.red_orb2);
		}else{
			sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.red_orb3);
		}
		}
		else if(color==4){
			if(sphereFrame==1){
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.green_orb1);
			}else if(sphereFrame==2){
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.green_orb2);
			}else{
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.green_orb3);
			}
		}else if(color==2){
			if(sphereFrame==1){
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.blue_orb1);
			}else if(sphereFrame==2){
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.blue_orb2);
			}else{
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.blue_orb3);
			}
		}else if(color==3){
			if(sphereFrame==1){
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.yellow_orb);
			}else if(sphereFrame==2){
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.yellow_orb2);
			}else{
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.yellow_orb3);
			}
		}else{
			if(sphereFrame==1){
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.orange_orb1);
			}else if(sphereFrame==2){
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.orange_orb2);
			}else{
				sphereBit= BitmapFactory.decodeResource(getResources(), R.drawable.orange_orb3);
			}
		}
		sphereFrame++;
		if(sphereFrame>3){
			sphereFrame=1;
		}
	}
	private void TrailUpdate() {
		synchronized(getHolder()){
		 if(pain>384){
    		 loser=true;
    	 }
         if(touch){
        	 
    				 for (int i = upgrades.size()-1; i >= 0; i--) {
    		             Upgrade bread = upgrades.get(i);
    		             if(bread.why<1){
    		            	 upgrades.remove(bread);
    		             }
    		             if (dst.intersect(bread.dst)) {
    		            	 if(sound==1){
    		            	 upgrade.start();
    		            	 }
    		                 changeColor(bread.type);   
    		            	 upgrades.remove(bread);
    		             }
    				 }
    				 for (int s = sprites.size()-1; s >= 0; s--) {
    					 Sprite sprit = sprites.get(s);
    					 if(sprit.death){
    						 sprites.remove(sprit);
    					 }
    				 }
    				 for (int e = stars.size()-1; e >= 0; e--) {
    		             Star shiny = stars.get(e);
    		             if(shiny.why<1){
    		            	 stars.remove(shiny);
    		             }
    		             if (dst.intersect(shiny.dst)) {  
    		            	 int bigness=shiny.startSize;
    		            	 int theX=shiny.hex;
    		            	 int theY=shiny.why;
    		            	 int starColor=shiny.starColor;
    		            	 if(shiny.starColor==color && !loser){
    		            	if(sound==1){	 
    		            	 star.start();
    		            	}
    		            	 points+=shiny.startSize*10;
    		            	 flTimer=5;
    		            	 colorCounter(shiny.startSize*10,color);
    		            	 sprites.add(new Sprite(starColor,11,5,explosions,theX,theY,bigness,this,1,shiny.startSize*10));		            	 
    		            	 }else{
    		            		 if(sound==1){
    		            		 hurt.start();
    		            		 }
    		            		 pain+=shiny.startSize*20*strength/100;
        		            	 sprites.add(new Sprite(starColor,11,5,explosions,theX,theY,bigness,this,0,0));
    		            		 if(color==1){
    		            			 if(red>0){
    		            			 red-=3;
    		            			 }else{
    		            			 red-=2;
    		            			 }
    		            		 }
    		            		 else if(color==2){
    		            			 if(blue>0){
    		            			 blue-=3;
    		            			 }else{
    		            			  blue-=2;
    		            			 }
    		            		 }
    		            		 else if(color==3){
    		            			 if(yellow>0){
    		            			 yellow-=3;
    		            			 }else{
    		            			  yellow-=2;	 
    		            			 }
    		            		 }
    		            		 else if(color==4){
    		            			 if(green>0){
    		            			 green-=3;
    		            			 }else{
    		            				 green-=2;
    		            			 }
    		            		 }else{
    		            			 if(orange>0){
    		            			 orange-=3;
    		            			 }else{
    		            				 orange-=2;
    		            			 }
    		            		 }
    		            		 changeColor(color);
    		            	 }
    		            	 stars.remove(shiny);
    		             }
    				 }
    			if(!loser){ 
        		 getPoints(ShpereXf,ShpereYf);
    			}
        		 colorCounter(5,color);
        		 if(pain>maxHealth){
        		 pain-=(rejoice/10);
        		 }
        		 trails.add(new Trail(sphereTrail,ShpereXf,ShpereYf,trailSize));
             
         }else{
        	 
        		 pain+=(durability/10);
             
         }
         
		 for (int i = trails.size()-1; i >= 0; i--) {
	            Trail dot = trails.get(i);
	            if(dot.timer<1){
	            	trails.remove(dot);
	            }
			}
		 for (int b = Bars.size()-1; b >= 0; b--) {
	            Bar sq = Bars.get(b);
	            if(sq.yPos<1){
	            	Bars.remove(sq);
	            }
			}
		 for (int s = sprites.size()-1; s >= 0; s--) {
	            Sprite sp = sprites.get(s);
	            if(sp.y<1){
	            	sprites.remove(sp);
	            }
			}
		 for (int k = kags.size()-1; k >= 0; k--) {
	            Kag kager = kags.get(k);
	            if(kager.dstr.intersect(dst) && touch){
	            	pain+=strength;
	            	kags.remove(kager);
	            }
	            if(kager.xPos<1 || kager.yPos<1 || kager.xPos>this.getWidth() || kager.yPos>this.getHeight()){
	            	Bitmap kagBit=BitmapFactory.decodeResource(getResources(), R.drawable.kag);
	    			sprites.add(new Sprite(1,11,1,kag_explosion,kager.xPos-(kagBit.getWidth()/2),kager.yPos,20,this,0,0));
	    			kags.remove(kager);
	    		}
			
         }
		}	
	}
	private void getPoints(float x, float y) {
		int hw=this.getWidth()/2;
		float man;
		if (x<hw) {

			points += (int)((x/hw)*3)+3;
			
		}
		if (x>hw) {
			man=(this.getWidth())-x;
			points += (int)((man/hw)*3)+3;
			
		}
	}
	private void flash(Canvas canvas) {
		Bitmap byt = BitmapFactory.decodeResource(getResources(), R.drawable.flash);
		int bH=byt.getHeight();
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setAlpha(flTimer*20);
		//paint.setColor(Color.WHITE);
		Rect rect = new Rect(0,(color-1)*(bH/5),byt.getWidth(),(color-1)*(bH/5)+(bH/5));
		Rect sec = new Rect(0,0,this.getWidth(),this.getHeight());
		canvas.drawBitmap(byt, rect,sec , null);
		canvas.drawRect(sec, paint);
		flTimer--;
		
	}
	private void colorCounter(int i, int color2) {
		if(color2==1){
			redP+=i;
		}else if(color2==2){
			blueP+=i;
		}else if(color2==3){
			yellowP+=i;
		}else if(color2==4){
			greenP+=i;
		}else{
			orangeP+=i;
		}
		
	}
	
	public void changeColor(int type) {
		if(type==1){
			if(red<10){
			red+=1;
			}
			trailSize=red;
			color=1;
			sphereTrail="red";
			healthpanel= BitmapFactory.decodeResource(getResources(), R.drawable.healthbar);
			healthBar=BitmapFactory.decodeResource(getResources(), R.drawable.healthsquare);
			maxHealth=1;
			strength=84-(red*3);
			if(pain<maxHealth){
				pain=maxHealth;
			}
			rejoice=12+(red*3);
			durability=72-(red*3);
		}else if(type==2){
			if(blue<10){
			blue+=2;
			}
			trailSize=blue;
			color=2;
			sphereTrail="blue";
			healthpanel= BitmapFactory.decodeResource(getResources(), R.drawable.blue_panel);
			healthBar=BitmapFactory.decodeResource(getResources(), R.drawable.blue_bar);
			maxHealth=190;
			if(pain<maxHealth){
			pain=maxHealth;
			}
			rejoice=9+(blue*3);
			durability=36-(blue*3);
			strength=42-(blue*3);
		}else if(type==3){
			if(yellow<10){
			yellow+=2;
			}
			trailSize=yellow;
			color=3;
			sphereTrail="yellow";
			healthpanel= BitmapFactory.decodeResource(getResources(), R.drawable.yellow_panel);
			healthBar=BitmapFactory.decodeResource(getResources(), R.drawable.yellow_bar);
			strength=96-(yellow*3);
			maxHealth=95;
			if(pain<maxHealth){
			pain=maxHealth;
			}
			rejoice=13+(yellow*3);
			durability=48-(yellow*3);
		}else if(type==4){
			if(green<10){
			green+=2;
			}
			trailSize=green;
			color=4;
			sphereTrail="green";
			healthpanel= BitmapFactory.decodeResource(getResources(), R.drawable.green_panel);
			healthBar=BitmapFactory.decodeResource(getResources(), R.drawable.green_bar);
			maxHealth=174;
			if(pain<maxHealth){
			pain=maxHealth;
			}
			rejoice=40+(green*3);
			durability=60-(green*3);
			strength=100-(green*3);
		}else{
			if(orange<10){
			orange+=2;
			}
			trailSize=orange;
			color=5;
			sphereTrail="orange";
			healthpanel= BitmapFactory.decodeResource(getResources(), R.drawable.orange_panel);
			healthBar=BitmapFactory.decodeResource(getResources(), R.drawable.orange_bar);
			strength=150-(orange*3);
			maxHealth=45;
			if(pain<maxHealth){
			pain=maxHealth;
			}
			rejoice=6+(orange*3);
			durability=30-(orange*3);
		}
		
	}
	
}
