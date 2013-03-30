package com.eva.bearded_octo_adventure;

import android.app.Activity;
import android.content.Context;
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
	private shark shark2;
	
	public static octo octo;

	public mainGame(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
		
		
		
		// create shark and load bitmap                                              x cord ,  y cord
		
		octo = new octo(BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), 500, 500);		
		

		
		
		shark = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.shark), 50, getRandomBegingPos() , getRandomX(), getRandomY());		
		shark2 = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.shark), 50, getRandomBegingPos(), getRandomX(), getRandomY());
		System.out.println(getRandomBegingPos());
		// create the game loop thread
		thread = new MainThread(getHolder(), this);
		
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
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			// delegating event handling to the droid
			octo.handleActionDown((int)event.getX(), (int)event.getY());
			
			// check if in the lower part of the screen we exit
			if (event.getY() > getHeight() - 50) {
				thread.setRunning(false);
				((Activity)getContext()).finish();
			} else {
				Log.d(TAG, "Coords: x=" + event.getX() + ",y=" + event.getY());
			}
		} if (event.getAction() == MotionEvent.ACTION_MOVE) {
			// the gestures
			if (octo.isTouched()) {
				// the droid was picked up and is being dragged
				octo.setX((int)event.getX());
				octo.setY((int)event.getY());
			}
		} if (event.getAction() == MotionEvent.ACTION_UP) {
			// touch was released
			if (octo.isTouched()) {
				octo.setTouched(false);
			}
		}
	return true;
	}

	public void render(Canvas canvas) {
//		Resources res = getResources();
//		 
//		Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.back);
//		canvas.drawBitmap(bitmap, 0, 0, null);
		canvas.drawColor(Color.BLACK);
		shark.draw(canvas);
		shark2.draw(canvas);
		octo.draw(canvas);
	}

		public void update() {
//			// check collision with right wall if heading right
//			if (shark.getSpeed().getxDirection() == Speed.DIRECTION_RIGHT
//					&& shark.getX() + shark.getBitmap().getWidth() / 2 >= getWidth()) {
//				shark.getSpeed().toggleXDirection();
//	//			shark.getSpeed().setxDirection(0);
//			}
//			// check collision with left wall if heading left
//			if (shark.getSpeed().getxDirection() == Speed.DIRECTION_LEFT
//					&& shark.getX() - shark.getBitmap().getWidth() / 2 <= 0) {
//				shark.getSpeed().toggleXDirection();
//	//			shark.getSpeed().setxDirection(0);
//			}
//			// check collision with bottom wall if heading down
//			if (shark.getSpeed().getyDirection() == Speed.DIRECTION_DOWN
//					&& shark.getY() + shark.getBitmap().getHeight() / 2 >= getHeight()) {
//				shark.getSpeed().toggleYDirection();
//	//			shark.getSpeed().setyDirection(0);
//			}
//			// check collision with top wall if heading up
//			if (shark.getSpeed().getyDirection() == Speed.DIRECTION_UP
//					&& shark.getY() - shark.getBitmap().getHeight() / 2 <= 0) {
//				shark.getSpeed().toggleYDirection();
//	//			shark.getSpeed().setyDirection(0);
//			}

			
			//	Update the shark
			
			
			
			octo = new octo(BitmapFactory.decodeResource(getResources(), R.drawable.octopus92), octo.getX(), octo.getY());
			
			if(shark.getSpeed().getxDirection() == Speed.DIRECTION_RIGHT
				&& shark.getX() + shark.getBitmap().getWidth() / 2 >= getWidth()){
				shark = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.shark), 50, getRandomBegingPos() , getRandomX(), getRandomY());
			}
			if(shark.getSpeed().getyDirection() == Speed.DIRECTION_DOWN
					&& shark.getY() + shark.getBitmap().getHeight() / 2 >= getHeight()){
				shark = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.shark), 50, getRandomBegingPos() , getRandomX(), getRandomY());
			}
			
			if(shark2.getSpeed().getxDirection() == Speed.DIRECTION_RIGHT
					&& shark2.getX() + shark2.getBitmap().getWidth() / 2 >= getWidth()){
					shark2 = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.shark), 50, getRandomBegingPos(), getRandomX(), getRandomY());
			}
			if(shark2.getSpeed().getyDirection() == Speed.DIRECTION_DOWN
					&& shark2.getY() + shark2.getBitmap().getHeight() / 2 >= getHeight()){
				System.out.println(getRandomBegingPos());
				shark2 = new shark(BitmapFactory.decodeResource(getResources(), R.drawable.shark), 50, getRandomBegingPos() , getRandomX(), getRandomY());
			}
			shark.update();
			shark2.update();
			
			octo.update();
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
