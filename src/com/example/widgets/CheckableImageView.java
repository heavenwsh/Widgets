package com.example.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;

public class CheckableImageView extends ImageView implements Checkable {
	
	public CheckableImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public CheckableImageView(Context context) {
		super(context, null);
		// TODO Auto-generated constructor stub
	}

	private boolean isChecked;
	private static final int[] CHECK_STATE = new int[] { android.R.attr.state_checked };


	@Override
	public int[] onCreateDrawableState(int extraSpace) {
		int[] states = super.onCreateDrawableState(extraSpace + 1);
		if (isChecked()) {
			mergeDrawableStates(states, CHECK_STATE);
		}
		return states;
	}

	/**
	 * Change the checked state of the view
	 *
	 * @param checked
	 *            The new checked state
	 */
	@Override
	public void setChecked(boolean checked) {
		if (this.isChecked != checked) {
			this.isChecked = checked;
			refreshDrawableState();
		}
	}

	/**
	 * @return The current checked state of the view
	 */
	@Override
	public boolean isChecked() {
		return isChecked;
	}

	/**
	 * Change the checked state of the view to the inverse of its current state
	 */
	@Override
	public void toggle() {
		setChecked(!isChecked);
	}

}
