package com.example.android.scorekeeperapp;

import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.example.android.scorekeeperapp.animations.CustomAnimator;
import com.example.android.scorekeeperapp.databinding.ActivityMainBinding;
import com.example.android.scorekeeperapp.fragments.ScoreFragment;
import com.example.android.scorekeeperapp.fragments.TeamAFragment;
import com.example.android.scorekeeperapp.fragments.TeamBFragment;

public class MainActivity extends AppCompatActivity implements TeamBFragment.TeamBButtonListener, TeamAFragment.TeamAButtonListener {
    ScoreFragment scoreFragment;
    ActivityMainBinding activityMainBinding;
    MediaPlayer mMediaPlayer;
    CustomAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = new Explode();
            explode.setDuration(800);
            getWindow().setEnterTransition(explode);
        }
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mAnimator = new CustomAnimator(getApplicationContext());
        scoreFragment = (ScoreFragment) getSupportFragmentManager().findFragmentById(R.id.score_fragment);
        scoreFragment.reset();
        mMediaPlayer = MediaPlayer.create(this, R.raw.button_click);
        setAnimation();
    }

    private void setAnimation() {
        //reset button animations
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(4000);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setInterpolator(new LinearInterpolator());
        activityMainBinding.resetButton.startAnimation(rotate);
        mAnimator.setButtonAnimationListener(activityMainBinding.resetImageView);
        activityMainBinding.resetImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset(v);
            }
        });
    }

    public void reset(View v) {
        activityMainBinding.resetImageView.setVisibility(View.INVISIBLE);
        mAnimator.setResetAnimatorOnResetButton(activityMainBinding.resetButton);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                scoreFragment.reset();
                activityMainBinding.resetImageView.setVisibility(View.VISIBLE);
            }
        }, 800);

    }

    private void playClickSound() {
        if (mMediaPlayer.isPlaying())
            mMediaPlayer.seekTo(0);
        mMediaPlayer.start();
    }

    @Override
    public void onTeamAGoalButtonClicked() {
        playClickSound();
        scoreFragment.increaseTeamAMainScore();
    }

    @Override
    public void onTeamARedButtonClicked() {
        playClickSound();
        scoreFragment.increaseTeamARedCardScore();
    }

    @Override
    public void onTeamAYellowButtonClicked() {
        playClickSound();
        scoreFragment.increaseTeamAYellowCardScore();
    }

    @Override
    public void onTeamAFoulButtonClicked() {
        playClickSound();
        scoreFragment.increaseTeamAFoulCardScore();
    }

    @Override
    public void onTeamBGoalButtonClicked() {
        playClickSound();
        scoreFragment.increaseTeamBMainScore();
    }

    @Override
    public void onTeamBRedButtonClicked() {
        playClickSound();
        scoreFragment.increaseTeamBRedCardScore();
    }

    @Override
    public void onTeamBYellowButtonClicked() {
        playClickSound();
        scoreFragment.increaseTeamBYellowCardScore();
    }

    @Override
    public void onTeamBFoulButtonClicked() {
        playClickSound();
        scoreFragment.increaseTeamBFoulCardScore();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMediaPlayer.release();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
