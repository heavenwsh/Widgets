package com.example.widgets;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	private TextView mTv1;
	
	private int mCount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		demoTv1();
		
		demoIv2();
		
		demoIv4();
		
		demoView();
	}

	private void demoView() {
		// TODO Auto-generated method stub
		View view = findViewById(R.id.view);
		Drawable d = getResources().getDrawable(R.drawable.shadow_drawable);
		view.setBackgroundDrawable(d);
	}

	private void demoIv4() {
		// TODO Auto-generated method stub
		ImageView iv = (ImageView) findViewById(R.id.iv4);
		ClipDrawable drawable = (ClipDrawable) getResources().getDrawable(R.drawable.clip_drawable);
		iv.setBackgroundDrawable(drawable);
		drawable.setLevel(drawable.getLevel() + 5000);
	}

	@TargetApi(Build.VERSION_CODES.M)
	private void demoIv2() {
		// TODO Auto-generated method stub
		ImageView iv = (ImageView) findViewById(R.id.iv2);
		final TransitionDrawable transition = (TransitionDrawable) getResources().getDrawable(R.drawable.expand_collapse);
		iv.setImageDrawable(transition);
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(++mCount / 2 == 0)
					transition.startTransition(1000);
				else
					transition.reverseTransition(1000);
			}
		});
		iv.setElevation(10);
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	private void demoTv1() {
		// TODO Auto-generated method stub
		mTv1 = (TextView) findViewById(R.id.tv1);
		Drawable shape = getResources().getDrawable(R.drawable.buttonstyle);
		mTv1.setBackground(shape);
	}
}
