package com.example.demo1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.example.demo1.MyRectF;

public class MyView1 extends View {

	int screenHeight;
	int screenWidth;

	float circleXCoordinate, circleYCoordinate;
	int numberOfSection, numberOfSubSection;
	int sectionSelected;

	float touchX, touchY;
	MyRectF sectionArcOuter, sectionArcInner, subSectionArc;
	String text;
	
	MyPaint paint1, paint2, paint3, paint4, paint5, paint6, paint7, paint8;
	
	float[] x;
	float[] y;
	float[] xT;
	float[] yT;
	int sectionValue[];

	int flag;
	
	public void setPaintColor(MyPaint paint,String color){
		
		paint.setColor(Color.parseColor(color));
	}

	public int getNumberOfSection() {
		return numberOfSection;
	}

	public void setNumberOfSection(int numberOfSection) {
		this.numberOfSection = numberOfSection;
	}

	public int getNumberOfSubSection() {
		return numberOfSubSection;
	}

	public void setNumberOfSubSection(int numberOfSubSection) {
		this.numberOfSubSection = numberOfSubSection;
	}


	public MyView1(Context context) {
		super(context);

		init();
		// TODO Auto-generated constructor stub
	}

	public MyView1(Context context, AttributeSet attrs) {
		super(context, attrs);
		// this constructor used when creating view through XML
		init();
	}

	public MyView1(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public void init() {
		paint1 = new MyPaint("#EEFFFF", true, 25);
		paint2 = new MyPaint("#E87ACC");
		paint3 = new MyPaint("#F244AE");
		paint4 = new MyPaint("#A04040");
		paint5 = new MyPaint("#104040", true, 40);
		paint6 = new MyPaint("#233467");
		paint7 = new MyPaint("#C456FF");
		paint8 = new MyPaint("#BBBFFF");
		/*
		 * paint1.setColor(Color.parseColor("#EEFFFF"));// ("#233467"));
		 * paint2.setColor(Color.parseColor("#E87ACC"));
		 * paint3.setColor(Color.parseColor("#F244AE"));
		 * paint4.setColor(Color.parseColor("#A04040"));// select
		 * paint5.setColor(Color.parseColor("#104040"));
		 * paint6.setColor(Color.parseColor("#233467"));// ("#FFFFFF"));
		 * paint7.setColor(Color.parseColor("#C456FF"));
		 * 
		 * paint8.setColor(Color.parseColor("#BBBFFF"));
		 * 
		 * paint1.setAntiAlias(true); paint1.setTextSize(25);
		 * paint5.setAntiAlias(true); paint5.setTextSize(40);
		 */
		subSectionArc = new MyRectF(0, 0, 0, 0);
		sectionArcOuter = new MyRectF(0, 0, 0, 0);
		sectionArcInner = new MyRectF(0, 0, 0, 0);

		numberOfSection = 1;
		numberOfSubSection = 6;
		touchX = 0;
		touchY = 0;
		sectionValue = new int[100];//int[numberOfSection];
		sectionSelected = 0;
		flag = 0;

		for (int i = 0; i < 100; i++) {
			sectionValue[i] = 0;
		}
	}

	public void setflag(int flag){
		this.flag=flag;
	}
	public int smallestSize(int h, int w) {
		circleXCoordinate = w / 2;
		circleYCoordinate = h / 2;
		if (h > w)
			return w;
		else
			return h;
	}

	private void getPointsSection(int x0, int y0, double radius,
			int noOfDividingPoints) {

		double angle = 0;

		x = new float[noOfDividingPoints];
		y = new float[noOfDividingPoints];

		for (int i = 0; i < noOfDividingPoints; i++) {
			angle = i * (360 / noOfDividingPoints);

			x[i] = (float) (x0 + radius * Math.cos(Math.toRadians(angle)));
			y[i] = (float) (y0 + radius * Math.sin(Math.toRadians(angle)));

		}

	}


	private void getPointsSectionT(int x0, int y0, double radius,
			int noOfDividingPoints) {

		double angle = 0;

		xT = new float[noOfDividingPoints];
		yT = new float[noOfDividingPoints];

		for (int i = 0; i < noOfDividingPoints; i++) {
			angle = i * (360 / noOfDividingPoints);

			xT[i] =  (float) (x0 + radius * Math.cos(Math.toRadians(angle)));
			yT[i] =  (float) (y0 + radius * Math.sin(Math.toRadians(angle)));

		}

	}
	public void setTouchPoint(float x, float y) {
		touchX = x;
		touchY = y;
		// flag=1;
	}

	/*
	 * public double setSectionTouch(float touchPointX, float touchPointY, float
	 * circleCenterPointX, float circleCenterPointY, float radius){
	 * 
	 * double dx = touchPointX - circleCenterPointX; // Minus to correct for
	 * coord re-mapping double dy = -(touchPointY -circleCenterPointY );
	 * 
	 * double inRads = Math.atan2(dy,dx);
	 * 
	 * // We need to map to coord system when 0 degree is at 3 O'clock, 270 at
	 * 12 O'clock if (inRads < 0) inRads = Math.abs(inRads); else inRads =
	 * 2*Math.PI - inRads; Log.v("Angle",""+Math.toDegrees(inRads)); return
	 * Math.toDegrees(inRads); }
	 */
	/*
	 * public double setSectionTouch(float touchPointX, float touchPointY, float
	 * circleCenterPointX, float circleCenterPointY, float radius) {
	 * 
	 * double anglesOppositeSideLength = distanceBetweenLine(touchPointX,
	 * touchPointY, circleCenterPointX, circleCenterPointY); double
	 * anglesAdjacentSideLength = distanceBetweenLine(touchPointX,
	 * circleCenterPointY, circleCenterPointX, circleCenterPointY);
	 * 
	 * // double angle = //
	 * Math.atan(anglesOppositeSideLength/anglesAdjacentSideLength); double
	 * angle = Math.atan2(anglesOppositeSideLength, anglesAdjacentSideLength);
	 * // return Math.toRadians(angle); return Math.toDegrees(angle); }
	 */
	public float areaOfTriangle(float pointX1, float pointY1, float pointX2,
			float pointY2, float pointX3, float pointY3) {
		
		return( Math.abs((pointX1 * (pointY2 - pointY3) + pointX2
				* (pointY3 - pointY1) + pointX3 * (pointY1 - pointY2)) / 2));
		
	}

	public void setSectionTouch(float touchPointX, float touchPointY,
			float circleCenterPointX, float circleCenterPointY) {
		float areaFullSection, areaPartSection1, areaPartSection2, areaPartSection3, areaAddPart;

		for (int i = 0; i < numberOfSection; i++) {
			areaFullSection = areaOfTriangle(xT[i], yT[i], xT[(i + 1)
					% numberOfSection], yT[(i + 1) % numberOfSection],
					circleCenterPointX, circleCenterPointY);
			areaPartSection1 = areaOfTriangle(xT[i], yT[i], xT[(i + 1)
					% numberOfSection], yT[(i + 1) % numberOfSection],
					touchPointX, touchPointY);
			areaPartSection2 = areaOfTriangle(xT[i], yT[i], touchPointX,
					touchPointY, circleCenterPointX, circleCenterPointY);
			areaPartSection3 = areaOfTriangle(xT[(i + 1) % numberOfSection],
					yT[(i + 1) % numberOfSection], touchPointX, touchPointY,
					circleCenterPointX, circleCenterPointY);

			areaAddPart = areaPartSection1 + areaPartSection2
					+ areaPartSection3;
			// areaAddPart=(areaAddPart*100)/100;

			if ((areaFullSection == areaAddPart)||((areaFullSection-areaAddPart)<=1 &&  (areaFullSection-areaAddPart)>=-1 )){
				sectionSelected = i;
			} else {
				//sectionSelected = i;
			}
		}
	}

	public double distanceBetweenLine(float touchPointX, float touchPointY,
			float circleCenterPointX, float circleCenterPointY) {
		return (Math.sqrt((touchPointX - circleCenterPointX)
				* (touchPointX - circleCenterPointX)
				+ (touchPointY - circleCenterPointY)
				* (touchPointY - circleCenterPointY)));
	}

	public boolean isInsideCircle(float touchPointX, float touchPointY,
			float circleCenterPointX, float circleCenterPointY, float radius) {
		float distance = (float) distanceBetweenLine(touchPointX, touchPointY,
				circleCenterPointX, circleCenterPointY);
		// Log.v("distance", "" + distance);
		if ((distance - radius) <= 0)
			return true;
		return false;
	}

	/*
	 * public boolean isInsideCircle(float touchPointX, float touchPointY, float
	 * circleCenterPointX, float circleCenterPointY, float radius) { float
	 * distance = (float) Math.sqrt((touchPointX - circleCenterPointX)
	 * (touchPointX - circleCenterPointX) + (touchPointY - circleCenterPointY)
	 * (touchPointY - circleCenterPointY)); //Log.v("distance", "" + distance);
	 * if ((distance - radius) > 0) return false; return true; }
	 */

	public float getTouchPointX() {
		return touchX;

	}

	public float getTouchPointY() {
		return touchY;

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);

		float touchX = getTouchPointX();
		float touchY = getTouchPointY();

		int screenHeight = getHeight();
		int screenWidth = getWidth();

		int circleCenterPointY = screenHeight / 2;
		int circleCenterPointX = screenWidth / 2;

		int minScreenSide = smallestSize(screenHeight, screenWidth);

		/*
		 * subSectionArc = new RectF(circleCenterPointX-minScreenSide / 3 -
		 * 5,circleCenterPointY-minScreenSide / 3 -
		 * 5,circleCenterPointX+minScreenSide / 3 +
		 * 5,circleCenterPointY+minScreenSide / 3 + 5); sectionArcOuter = new
		 * RectF(circleCenterPointX-minScreenSide /
		 * 2-10,circleCenterPointY-minScreenSide /
		 * 2-10,circleCenterPointX+minScreenSide /
		 * 2+10,circleCenterPointY+minScreenSide / 2+10);////// sectionArcInner
		 * = new RectF(circleCenterPointX-minScreenSide / 3 +
		 * 5,circleCenterPointY-minScreenSide / 3 + 5
		 * ,circleCenterPointX+minScreenSide / 3 -
		 * 5,circleCenterPointY+minScreenSide / 3 - 5 );/////
		 */

		subSectionArc.setRectFParams(
				circleCenterPointX - minScreenSide / 3 - 5, circleCenterPointY
						- minScreenSide / 3 - 5, circleCenterPointX
						+ minScreenSide / 3 + 5, circleCenterPointY
						+ minScreenSide / 3 + 5);
		sectionArcOuter.setRectFParams(
				circleCenterPointX - minScreenSide / 2+10,
				circleCenterPointY - minScreenSide / 2+10,
				circleCenterPointX + minScreenSide / 2-10,
				circleCenterPointY + minScreenSide / 2-10);// ////
		sectionArcInner.setRectFParams(circleCenterPointX - minScreenSide / 3
				+ 5, circleCenterPointY - minScreenSide / 3 + 5,
				circleCenterPointX + minScreenSide / 3 - 5, circleCenterPointY
						+ minScreenSide / 3 - 5);// ///

	//	canvas.drawRect(sectionArcOuter, paint8);

		canvas.drawCircle(circleCenterPointX, circleCenterPointY,
				minScreenSide / 2 - 10, paint1);// circle 1

		canvas.drawArc(sectionArcOuter, sectionSelected
				* (360 / numberOfSection), (360 / numberOfSection), true,
				paint7);

		canvas.drawCircle(circleCenterPointX, circleCenterPointY,
				minScreenSide / 3 + 5, paint2);// circle 2

		getPointsSection(circleCenterPointX, circleCenterPointY,
				minScreenSide / 3 + 5, numberOfSection * numberOfSubSection);
		for (int i = 0; i < (numberOfSection * numberOfSubSection); i++) {
			canvas.drawLine(x[i], y[i], circleCenterPointX, circleCenterPointY,
					paint5);// chote line
		}

		for (int i = 0; i < numberOfSection; i++) {
			canvas.drawArc(subSectionArc, i * (360 / numberOfSection),
					(360/(numberOfSection*numberOfSubSection)) * sectionValue[i], true, paint4);
		}

		canvas.drawCircle(circleCenterPointX, circleCenterPointY,
				minScreenSide / 3 - 5, paint1);// circle 3

		canvas.drawArc(sectionArcInner, sectionSelected
				* (360 / numberOfSection), (360 / numberOfSection), true, paint7);

		getPointsSection(circleCenterPointX, circleCenterPointY,
				minScreenSide / 2 - 10, numberOfSection);
		for (int i = 0; i < numberOfSection; i++) {
			canvas.drawLine(x[i], y[i], circleCenterPointX, circleCenterPointY,
					paint6); // bade line
		}

		canvas.drawCircle(circleCenterPointX, circleCenterPointY,
				minScreenSide / 4, paint7);// circle 4

		// canvas.drawCircle(circleCenterPointX, circleCenterPointY,
		// minScreenSide / 40, paint3);

		canvas.drawCircle(circleCenterPointX, circleCenterPointY,
				minScreenSide / 5, paint8);// circle 5

		canvas.drawText("+", circleCenterPointX - minScreenSide / 80,
				circleCenterPointY - minScreenSide / 10, paint5);
		canvas.drawText("_", circleCenterPointX - minScreenSide / 80,
				circleCenterPointY + minScreenSide / 8, paint5);

		// canvas.drawCircle(touchX, touchY, minScreenSide / 30, paint1);//touch
		// point wala circle

		if (isInsideCircle(touchX, touchY, circleCenterPointX,
				circleCenterPointY, minScreenSide / 5) && flag == 1) {
			flag = 0;
			
			if (touchY < circleCenterPointY) {
				if (sectionValue[sectionSelected] < 6)
					sectionValue[sectionSelected]++;
			} else {
				if (sectionValue[sectionSelected] > 0)
					sectionValue[sectionSelected]--;
			}

		} else if (isInsideCircle(touchX, touchY, circleCenterPointX,
				circleCenterPointY, minScreenSide / 2 - 10)&&flag==1) {
			flag=0;
			canvas.drawText("Touch Inside Outer Circle", minScreenSide / 30,
					minScreenSide / 25, paint6);
			if(numberOfSection>2){
			getPointsSectionT(circleCenterPointX, circleCenterPointY,
					(minScreenSide / 2 - 10) * (5), numberOfSection);
			setSectionTouch(touchX, touchY, circleCenterPointX,
					circleCenterPointY);
			}
			else if(numberOfSection==2){
				if(touchY < circleCenterPointY)
					sectionSelected=1;
				else
					sectionSelected=0;
			}

		} else if (!(isInsideCircle(touchX, touchY, circleCenterPointX,
				circleCenterPointY, minScreenSide / 2 - 10))) {
			canvas.drawText("Touch Outside Outer Circle", minScreenSide / 30,
					minScreenSide / 25, paint6);
		}

		canvas.drawText("" + sectionValue[sectionSelected],
				circleCenterPointX - 7, circleCenterPointY + 12, paint5);// ////

		
		invalidate();
	}

}


