package com.example.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class CustomSkinProgressbar1 extends View {
	
	private Drawable mBase, mTracker, mProgress, mDefaultPosition;
	
	private int mWidth, mHeight;
	
	public CustomSkinProgressbar1(Context context) {
		super(context, null);
		// TODO Auto-generated constructor stub
	}

	public CustomSkinProgressbar1(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		drawBottomProgress(canvas);
		drawTracker(canvas);
		super.onDraw(canvas);
	}

	private void drawTracker(Canvas canvas) {
		// TODO Auto-generated method stub
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.RED);
		
		canvas.drawCircle(100, 38/2, 38/2, paint);
	}

	private void drawBottomProgress(Canvas canvas) {
		// TODO Auto-generated method stub
		RectF bottomRect = getBottomProgressRect();
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.RED);
		canvas.drawRoundRect(bottomRect, 2, 2, paint);
		Log.d("debugwidget", ">>>>>> drawBottom >> ");
	}

	private RectF getBottomProgressRect() {
		RectF rectf = new RectF();
		rectf.left = 19;
		rectf.top = 17;
		rectf.right = mWidth - 38;
		rectf.bottom = 21;
		
		return rectf;
	}

	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		mWidth = MeasureSpec.getSize(widthMeasureSpec);
		mHeight = MeasureSpec.getSize(heightMeasureSpec);
		Log.d("debugwidget", ">>>>>> onMeasure >>mWidth " + mWidth);
		Log.d("debugwidget", ">>>>>> onMeasure >>mHeight " + mHeight);
	}
	
}
