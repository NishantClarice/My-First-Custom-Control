package com.example.demo1;

import android.graphics.Color;
import android.graphics.Paint;

public class MyPaint extends Paint {
	public MyPaint(String color){
		super();
		super.setColor(Color.parseColor(color));
	}
	public MyPaint(){
		super();
	}
	public MyPaint(String color,boolean antiAlias){
		super();
		super.setColor(Color.parseColor(color));
		super.setAntiAlias(antiAlias);
	}
	public MyPaint(String color,boolean antiAlias,int textSize){
		super();
		super.setColor(Color.parseColor(color));
		super.setAntiAlias(antiAlias);
		super.setTextSize(textSize);
	}
	public MyPaint(String color,int textSize){
		super();
		super.setColor(Color.parseColor(color));
		//super.setAntiAlias(antiAlias);
		super.setTextSize(textSize);
	}
}
