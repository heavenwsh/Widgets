package com.example.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class FooterTracker extends View {
	
	public FooterTracker(Context context) {
		super(context, null);
		// TODO Auto-generated constructor stub
	}

	public FooterTracker(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		setBackgroundColor(Color.GREEN);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Path path = new Path();
		path.moveTo(10, 10);
		path.lineTo(100, 20);
//		path.addArc(new RectF(0, 0, 45, 45), 30, 45);
		path.lineTo(1080, 10);
//		path.close();
		path.computeBounds(new RectF(), false);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.BLUE);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(4);
		paint.setPathEffect(null);
		canvas.drawPath(path, paint);
		
		paint.setColor(Color.RED);
		canvas.drawPath(makeFollowPath(), paint);
		super.onDraw(canvas);
	}
	
	private static Path makeFollowPath() {
        Path p = new Path();
        p.moveTo(0, 0);
        for (int i = 1; i <= 15; i++) {
            p.lineTo(i*20, (float)Math.random() * 35);
        }
        p.close();
        return p;
    }

}
