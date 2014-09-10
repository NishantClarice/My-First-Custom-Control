package com.example.demo1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.android.customviews.PieChart;
//import com.example.android.customviews.R;
import com.example.demo1.MyView1;

public class PieActivity extends Activity {

	// Myview1 myniew1;
	String text;
	TextView textViewTesting;
	int value;
	float touchX, touchY;
	Button buttonMinus, buttonPlus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		value = 0;
		/*
		 * setContentView(R.layout.activity_pie); v=new Myview(this); v=(Myview)
		 * findViewById(R.id.myview1); setContentView(new Myview(this));
		 * 
		 * //new Myview(new Myview(this);
		 * 
		 * //setContentView(v); t=(TextView)findViewById(R.id.textView1Pie);
		 */

		Resources res = getResources();

		setContentView(R.layout.activity_pie);

		final MyView1 myView1 = (MyView1) this.findViewById(R.id.myview1);
		// final Myview2 myview2 = (Myview2) this.findViewById(R.id.myview2);

		buttonMinus = (Button) findViewById(R.id.minus);
		buttonPlus = (Button) findViewById(R.id.plus);
		textViewTesting = (TextView) findViewById(R.id.textView1Pie);

		myView1.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				/*textViewTesting.setText("Touch ("
						+ String.valueOf(event.getX()) + ":"
						+ String.valueOf(event.getY()) + ")");
*/
				touchX = event.getX();
				touchY = event.getY();

				if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
					// Log.d("TouchTest", "Touch down");
					myView1.setflag(1);
					myView1.setTouchPoint(touchX, touchY);

				} else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
					myView1.setflag(0);
					myView1.setTouchPoint(touchX, touchY);
					// Log.d("TouchTest", "Touch up");
				}
				// myview1.flag=1;
				// t.setText(""+Math.atan2(touchX, touchY));
				return true;
				// return false;
			}
		});
		buttonMinus.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// int value=Integer.parseInt((String) t.getText());
				if(myView1.numberOfSection>1){
					myView1.numberOfSection--;
					myView1.sectionSelected=0;
				}
			}
		});
		buttonPlus.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// int value=Integer.parseInt((String) t.getText());
				if(myView1.numberOfSection<6)	
					myView1.numberOfSection++;
			/*	myView1.sectionSelected = (myView1.sectionSelected + 1)
						% myView1.numberOfSection;
			*/
			}
		});

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
}
