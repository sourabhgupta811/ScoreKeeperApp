package com.example.android.scorekeeperapp.animations;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.android.scorekeeperapp.R;

public class CustomAnimator implements View.OnTouchListener {
    private Animator mAnimatorStart;
    private Animator mAnimatorFinish;
    private Animator mAnimatorReverseStart;
    private Animator mAnimatorReverseFinish;
    private Animator mTextViewAnimator;
    private Animator resetAnimator;

    public CustomAnimator(Context context) {
        mAnimatorStart = AnimatorInflater.loadAnimator(context, R.animator.scale_animator);
        mAnimatorFinish = AnimatorInflater.loadAnimator(context, R.animator.scale_animator_finish);
        mAnimatorReverseStart = AnimatorInflater.loadAnimator(context, R.animator.scale_animator_reverse);
        mAnimatorReverseFinish = AnimatorInflater.loadAnimator(context, R.animator.scale_animator_reverse_finish);
        mTextViewAnimator = AnimatorInflater.loadAnimator(context, R.animator.textview_animator);
        resetAnimator = AnimatorInflater.loadAnimator(context, R.animator.reset_animator);
    }

    public void startAnimationOnTextView(TextView textview) {
        mTextViewAnimator.setTarget(textview);
        mTextViewAnimator.start();
    }

    public void setButtonAnimationListener(View v) {
        v.setOnTouchListener(this);
    }

    public void setResetAnimatorOnResetButton(View resetButton) {
        if (!resetAnimator.isRunning()) {
            resetAnimator.setTarget(resetButton);
            resetAnimator.start();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (v.getScaleX() < 0)
                mAnimatorStart = mAnimatorReverseStart;
            mAnimatorStart.setTarget(v);
            mAnimatorStart.start();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            v.performClick();
            if (v.getScaleX() < 0)
                mAnimatorFinish = mAnimatorReverseFinish;
            mAnimatorFinish.setTarget(v);
            mAnimatorFinish.start();
            return true;
        }
        return false;
    }
}
