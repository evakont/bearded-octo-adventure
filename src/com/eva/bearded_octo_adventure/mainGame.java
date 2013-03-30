package com.eva.bearded_octo_adventure;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class mainGame  extends SurfaceView implements SurfaceHolder.Callback{

private static final String TAG = mainGame.class.getSimpleName();
	
	private MainThread thread;
	private shark shark;
	private shark shark2;private shark shark3;
	
	private boolean isAlive;

	public ArrayList <shark> octoList;
	
	public mainGame(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
		
		shark3 = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 50, getRandomBegingPos() , getRandomX(), getRandomY());		

		
		// create shark and load bitmap                                              x cord ,  y cord	
		shark = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 50, getRandomBegingPos() , getRandomX(), getRandomY());		
		shark2 = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 50, getRandomBegingPos(), getRandomX(), getRandomY());
		
		// fill the list with the sharks
		
		octoList = new ArrayList<shark>();
		octoList.add(shark);octoList.add(shark2);octoList.add(shark3);
		
		// create the game loop thread
		thread = new MainThread(getHolder(), this);
		isAlive = true;
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// at this point the surface is created and
		// we can safely start the game loop
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(TAG, "Surface is being destroyed");
		// tell the thread to shut down and wait for it to finish
		// this is a clean shutdown
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// try again shutting down the thread
			}
		}
		Log.d(TAG, "Thread was shut down cleanly");
	}

	// gia tin wra as min kanei tpt otan to akoumpaw
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		ArrayList <Integer> posX = new ArrayList<Integer>();
		ArrayList <Integer> posY = new ArrayList<Integer>();
		
		posX.add(octoList.get(0).getX());posX.add(octoList.get(1).getX());posX.add(octoList.get(2).getX());
		posY.add(octoList.get(0).getY());posY.add(octoList.get(1).getY());posY.add(octoList.get(2).getY());
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
//			Log.w("x tou xtapodioy", String.valueOf(shark.getX()));
//			Log.w("y tou xtapodioy", String.valueOf(shark.getY()));
//			Log.w("x pou patisa", String.valueOf(event.getX()));
//			Log.w("y pou patisa", String.valueOf(event.getY()));
			
//			@SuppressWarnings("unused")
//			int eventX = (int) event.getX(); 
//			@SuppressWarnings("unused")
//			int eventY = (int) event.getY();
//			int xtapodiX = shark3.getX();
//			int xtapodiY = shark3.getY();
//			@SuppressWarnings("unused")
//			int prosXtapX = (int) (shark3.getX()+(0.05*shark3.getX())); 
//			int prosXtapXneg = (int) (shark3.getX()+((-1)*0.05*shark3.getX())); 
//			int prosXtapY = (int) (shark3.getY()+(0.05*shark3.getY()));
//			int prosXtapYneg = (int) (shark3.getX()+((-1)*0.05*shark3.getX()));
			
			
			
			
			
			
			for(int i = 0; i < octoList.size(); i++){
				//octoList.get(i).handleActionDown((int)event.getX(), (int)event.getY());
				if((  (int) event.getX() <= posX.get(i)+50 &&  (int) event.getX() >= posX.get(i)-50 ) && ( (int) event.getY() <= posY.get(i)+50   &&  (int) event.getY() > posY.get(i)-50 )){
					octoList.get(i).setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.splashredsmall));
				}
			}
//			thread.setRunning(false);
//			((Activity)getContext()).finish();
			posX.clear();
			posY.clear();
			
			//if((  (int) event.getX() <= shark3.getX()+50 &&  (int) event.getX() >= shark3.getX()-50 ) && ( (int) event.getY() <= shark3.getY()+50   &&  (int) event.getY() > shark3.getY()-50 )){
			//	shark3 = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.splashredsmall), (int) event.getX(), (int) event.getY() , 0, 0);
//				shark2.setTouched(false);
//				shark3.destroy(shark);
//				isAlive =  false;
				
			//}
//			if(((int) event.getX() < shark2.getX()+(0.05*shark2.getX()) ||  (int) event.getX() > shark2.getX()+((-1)*0.05*shark2.getX()))  && ( (int) event.getY() < shark2.getY()+(0.05*shark2.getY()) ||  (int) event.getY() > shark2.getY()+((-1)*0.05*shark2.getY()) ) ){
//				shark2 = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.splashredsmall), (int) event.getX(), (int) event.getY() , 0, 0);
//				shark.setTouched(false);
//				shark2.destroy(shark2);
//				isAlive =  false;
//			}
//			if(shark3.getX() == (int) event.getX() && shark3.getY() == (int) event.getY()){
//				shark3 = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.splashredsmall), (int) event.getX(), (int) event.getY() , 0, 0);
//			}
//			shark.handleActionDown((int)event.getX(), (int)event.getY());
//			shark = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.splashredsmall), (int) event.getX(), (int) event.getY() , 0, 0);
		}
		
//		if (event.getAction() == MotionEvent.ACTION_MOVE) {
//			// the gestures
//			
//			for(int i = 0; i < octoList.size(); i++){
//				if (octoList.get(i).isTouched()) {
//					// the droid was picked up and is being dragged
//					octoList.get(i).setX((int)event.getX());
//					octoList.get(i).setY((int)event.getY());
//				}
//			}
//		}
		if (event.getAction() == MotionEvent.ACTION_UP) {
			// touch was released
			for(int i = 0; i < octoList.size(); i++){
				if((  (int) event.getX() <= posX.get(i)+50 &&  (int) event.getX() >= posX.get(i)-50 ) && ( (int) event.getY() <= posY.get(i)+50   &&  (int) event.getY() > posY.get(i)-50 )){
					octoList.get(i).setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.splashredsmall));
				}
			}
			posX.clear();
			posY.clear();
		}
		posX.clear();
		posY.clear();
	return true;
	}

	public void render(Canvas canvas) {
//		Resources res = getResources();
//		 
//		Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.back);
//		canvas.drawBitmap(bitmap, 0, 0, null);
		canvas.drawColor(Color.BLACK);
		for(int i = 0; i < octoList.size(); i++){
			octoList.get(i).draw(canvas);
		}
	}

		public void update() {
			//	Update the shark
			shark myShark;
			if(isAlive){
				
				for(int i = 0; i < octoList.size(); i++){
					if(octoList.get(i).getSpeed().getxDirection() == Speed.DIRECTION_RIGHT && octoList.get(i).getX() + octoList.get(i).getBitmap().getWidth() / 2 >= getWidth()){
						createNewOcto(i,BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 50, getRandomBegingPos() , getRandomX(), getRandomY());
//						myShark =  new shark(BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 50, getRandomBegingPos() , getRandomX(), getRandomY());
//						octoList.get(i).setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.splashredsmall));
//						octoList.get(i).setDir(getRandomX(), getRandomY());
//						octoList.get(i).setY(getRandomBegingPos());
//						octoList.remove(i);
//						octoList.add(i, myShark);
					}
					
					if(octoList.get(i).getSpeed().getyDirection() == Speed.DIRECTION_DOWN && octoList.get(i).getY() + octoList.get(i).getBitmap().getHeight() / 2 >= getHeight()){
						
						createNewOcto(i,BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 50, getRandomBegingPos() , getRandomX(), getRandomY());

//						octoList.remove(i);
						myShark =  new shark(BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 50, getRandomBegingPos() , getRandomX(), getRandomY());
//						octoList.get(i).setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.splashredsmall));
//
//						octoList.get(i).setDir(getRandomX(), getRandomY());
//						octoList.get(i).setY(getRandomBegingPos());
//						octoList.remove(i);
//						octoList.add(i, myShark);
					}
					octoList.get(i).update();
					
				}
				
				
				
//				if(shark.getSpeed().getxDirection() == Speed.DIRECTION_RIGHT
//					&& shark.getX() + shark.getBitmap().getWidth() / 2 >= getWidth()){
//					shark = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 50, getRandomBegingPos() , getRandomX(), getRandomY());
//				}
//				if(shark.getSpeed().getyDirection() == Speed.DIRECTION_DOWN
//						&& shark.getY() + shark.getBitmap().getHeight() / 2 >= getHeight()){
//					shark = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 50, getRandomBegingPos() , getRandomX(), getRandomY());
//				}
//				
//				if(shark2.getSpeed().getxDirection() == Speed.DIRECTION_RIGHT
//						&& shark2.getX() + shark2.getBitmap().getWidth() / 2 >= getWidth()){
//						shark2 = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 50, getRandomBegingPos(), getRandomX(), getRandomY());
//				}
//				if(shark2.getSpeed().getyDirection() == Speed.DIRECTION_DOWN
//						&& shark2.getY() + shark2.getBitmap().getHeight() / 2 >= getHeight()){
//					System.out.println(getRandomBegingPos());
//					shark2 = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 50, getRandomBegingPos() , getRandomX(), getRandomY());
//				}
				
				
//				shark.update();
//				shark2.update();shark3.update();
			}
		}
		
		public void createNewOcto(int i, Bitmap bitmap, int x, int y, int dx, int dy){
			shark myShark;
			myShark =  new shark(bitmap, x, y, dx, dy);

			octoList.remove(i);
			octoList.add(i, myShark);
		}
		
		public int getRandomX(){
			int randomX;
			randomX = (int)( 0 + (Math.random() * (5 - 0) + 1));
			return randomX;
		}
		
		public int getRandomY(){
			int randomY;
			randomY = (int)( 0 + (Math.random() * (5 - 0) + 1));
			return randomY;
		}
		
		public int getRandomBegingPos(){
			int y;
			y = (int) (50 + (Math.random() * (game.ySize - 50) + 1));
			return y;
		}
		
}
