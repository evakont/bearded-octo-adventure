package com.eva.bearded_octo_adventure;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class octo {
	private Bitmap bitmap;	// the actual bitmap
	private float x;			// the X coordinate
	private float y;			// the Y coordinate
	private boolean touched;	// if droid is touched/picked up

												// dx = kateuthinsi gia x
												// dy = kateuthinsi gia y
	public octo(Bitmap bitmap, float x, float y) {
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
	}
	
	public Bitmap getBitmap() {
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}

	public boolean isTouched() {
		return touched;
	}

	public void setTouched(boolean touched) {
		this.touched = touched;
	}


	public void draw(Canvas canvas) {

		canvas.drawBitmap(bitmap, x, y, null);
	}
	
	public void move(float f, float g){
		x = (int) (this.x + (f));
		y = (int) (this.y + (g)) ;
	}

	/**
	 * Method which updates the droid's internal state every tick
	 */
	public void update() {
		if (!touched) {

		}
	}
	
	
	/**
	 * Handles the {@link MotionEvent.ACTION_DOWN} event. If the event happens on the 
	 * bitmap surface then the touched state is set to <code>true</code> otherwise to <code>false</code>
	 * @param eventX - the event's X coordinate
	 * @param eventY - the event's Y coordinate
	 */
	public void handleActionDown(int eventX, int eventY) {
		if (eventX >= (x - bitmap.getWidth() / 2) && (eventX <= (x + bitmap.getWidth()/2))) {
			if (eventY >= (y - bitmap.getHeight() / 2) && (y <= (y + bitmap.getHeight() / 2))) {
				
				setTouched(true);
			} else {
				setTouched(false);
			}
		} else {
			setTouched(false);
		}

	}
}
