package com.example.demo1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Myview2 extends View {

	MyPaint paint1, paint2, paint3, paint4, paint5, paint6, paint7, paint8;
	int counter, count;

	public Myview2(Context context) {
		super(context);
		init();
		// TODO Auto-generated constructor stub
	}

	public Myview2(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
		// TODO Auto-generated constructor stub
	}

	public Myview2(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		paint1 = new MyPaint("#233467");
		paint2 = new MyPaint("#987ACC");
		paint3 = new MyPaint("#F244AE");
		paint4 = new MyPaint("#A04040");
		paint5 = new MyPaint("#104040");
		paint6 = new MyPaint("#FFFFFF");
		paint7 = new MyPaint("#DFFFFF");
		paint8 = new MyPaint("#BBBFFF");
/*
		paint1.setColor(Color.parseColor("#233467"));
		paint2.setColor(Color.parseColor("#987ACC"));
		paint3.setColor(Color.parseColor("#F244AE"));
		paint4.setColor(Color.parseColor("#A04040"));
		paint5.setColor(Color.parseColor("#104040"));
		paint6.setColor(Color.parseColor("#FFFFFF"));
		paint7.setColor(Color.parseColor("#DFFFFF"));
		paint8.setColor(Color.parseColor("#BBBFFF"));
*/
		counter = 0;
		count = 0;
	}

	public int smallestSize(int h, int w) {

		if (h > w)
			return w;
		else
			return h;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		/*
		 * canvas.drawPaint(paint1); canvas.drawPaint(paint2);
		 * canvas.drawPaint(paint3); canvas.drawPaint(paint4);
		 * canvas.drawPaint(paint5); canvas.drawPaint(paint6);
		 * canvas.drawPaint(paint7); canvas.drawPaint(paint8);
		 */
		int screenHeight = getHeight();
		int screenWidth = getWidth();

		int circleCenterPointY = screenHeight / 2;
		int circleCenterPointX = screenWidth / 2;

		int minScreenSide = smallestSize(screenHeight, screenWidth);

		canvas.drawCircle(circleCenterPointX, circleCenterPointY,
				minScreenSide / 2, paint6);

		canvas.drawCircle(circleCenterPointX, circleCenterPointY, minScreenSide
				/ ((counter + 2)), paint8);

		/*
		 * canvas.drawCircle(circleCenterPointX,
		 * circleCenterPointY,minScreenSide / 2 , paint1);//circle 1
		 * canvas.drawCircle(circleCenterPointX, circleCenterPointY,
		 * minScreenSide / 2-minScreenSide / 10 , paint2);//circle 2
		 * canvas.drawCircle(circleCenterPointX, circleCenterPointY,
		 * minScreenSide / 3 , paint3);//circle 3
		 * canvas.drawCircle(circleCenterPointX, circleCenterPointY,
		 * minScreenSide / 4 , paint8);//circle 4
		 */
		canvas.drawCircle(circleCenterPointX, circleCenterPointY,
				minScreenSide / 6, paint3);// circle 5
		if (counter == 4) {

			canvas.drawCircle(circleCenterPointX - (minScreenSide / 9),
					circleCenterPointY, minScreenSide / 30, paint2);// chota
																	// circle 1
		} else if (counter == 3) {

			canvas.drawCircle(circleCenterPointX - (minScreenSide / 10),
					circleCenterPointY - (minScreenSide / 13),
					minScreenSide / 30, paint2);// chota circle 2
		} else if (counter == 2) {

			canvas.drawCircle(circleCenterPointX, circleCenterPointY
					- (minScreenSide / 9), minScreenSide / 30, paint2);// chota
																		// circle
																		// 3
		} else if (counter == 1) {

			canvas.drawCircle(circleCenterPointX + (minScreenSide / 10),
					circleCenterPointY - (minScreenSide / 13),
					minScreenSide / 30, paint2);// chota circle 4
		} else if (counter == 0) {

			canvas.drawCircle(circleCenterPointX + (minScreenSide / 9),
					circleCenterPointY, minScreenSide / 30, paint2);// chota
																	// circle 5
		}
		if (count == 0) {

			counter--;
			if (counter == -1)
				counter = 4;
		}
		count++;
		if (count == 25)
			count = 0;
		invalidate();
	}
}
