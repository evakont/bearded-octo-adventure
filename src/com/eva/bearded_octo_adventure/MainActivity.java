package com.eva.bearded_octo_adventure;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "Kankin.ttf");  
		TextView titleView = (TextView) findViewById(R.id.textView1); 
		titleView.setTypeface(font);
		 
		TextView subTitleView = (TextView) findViewById(R.id.textView3); 
		subTitleView.setTypeface(font);
		       
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void play(View view){
		Intent i = new Intent(this, game.class);
		startActivity(i);
	}

}
