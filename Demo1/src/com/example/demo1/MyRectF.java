package com.example.demo1;

import android.graphics.Rect;
import android.graphics.RectF;

public class MyRectF extends RectF {

	public MyRectF() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyRectF(float left, float top, float right, float bottom) {
		super(left, top, right, bottom);
		// TODO Auto-generated constructor stub
	}

	public MyRectF(Rect r) {
		super(r);
		// TODO Auto-generated constructor stub
	}

	public MyRectF(RectF r) {
		super(r);
		// TODO Auto-generated constructor stub
	}

	public void setRectFParams(float left, float top, float right, float bottom) {
		super.left = left;
		super.right = right;
		super.top = top;
		super.bottom = bottom;
	}

}
