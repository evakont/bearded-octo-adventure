package com.eva.bearded_octo_adventure;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;



public class game extends Activity{
	
	public static int xSize;
	public static int ySize;
	
	public static float xAcc;
	public static float yAcc;
	private SensorManager sensorManager;

	private Sensor accelerometer;

	
	
	private static final String TAG = game.class.getSimpleName();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requesting to turn the title OFF
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // making it full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // set our MainGamePanel as the View
		setContentView(new mainGame(this));
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		xSize = size.x;
		ySize = size.y;
		
		SensorManager mSensorManager;
		Sensor mAccelerometer;
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//		mSensorManager.registerListener(mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		mSensorManager.registerListener(new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				xAcc = event.values[0];
			    yAcc = event.values[1];
			    mainGame.octo.move(event.values[0], event.values[1]);
			    String pss = String.valueOf(xAcc);
			    String pff = String.valueOf(yAcc);
			    Log.w("xtapodia x ", pss);
			    Log.w("xtapodia y ", pff);
				
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
		}, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		
		
		
	}


	@Override
	protected void onDestroy() {
		Log.d(TAG, "Destroying...");
		super.onDestroy();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "Stopping..."); 
	}


}
