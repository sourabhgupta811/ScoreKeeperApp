package com.example.android.scorekeeperapp.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.scorekeeperapp.R;
import com.example.android.scorekeeperapp.animations.CustomAnimator;
import com.example.android.scorekeeperapp.databinding.ScoreBoardLayoutBinding;

public class ScoreFragment extends Fragment {
    ScoreBoardLayoutBinding scoreBoardLayoutBinding;
    CustomAnimator animator;
    int teamARedCardScoreNumber;
    int teamAMainScoreNumber;
    int teamAYellowCardScoreNumber;
    int teamAFoulCardScoreNumber;
    int teamBRedCardScoreNumber;
    int teamBMainScoreNumber;
    int teamBYellowCardScoreNumber;
    int teamBFoulCardScoreNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        scoreBoardLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.score_board_layout, container, false);
        animator = new CustomAnimator(getActivity());
        return scoreBoardLayoutBinding.getRoot();

    }

    public void reset() {
        teamARedCardScoreNumber = 0;
        teamAMainScoreNumber = 0;
        teamAYellowCardScoreNumber = 0;
        teamAFoulCardScoreNumber = 0;
        teamBRedCardScoreNumber = 0;
        teamBMainScoreNumber = 0;
        teamBYellowCardScoreNumber = 0;
        teamBFoulCardScoreNumber = 0;
        scoreBoardLayoutBinding.teamARedCardScore.setText(String.valueOf(0));
        scoreBoardLayoutBinding.teamAScore.setText(String.valueOf(0));
        scoreBoardLayoutBinding.teamAYellowCardScore.setText(String.valueOf(0));
        scoreBoardLayoutBinding.teamAFoulScore.setText("Foul : " + String.valueOf(0));
        scoreBoardLayoutBinding.teamBRedCardScore.setText(String.valueOf(0));
        scoreBoardLayoutBinding.teamBScore.setText(String.valueOf(0));
        scoreBoardLayoutBinding.teamBYellowCardScore.setText(String.valueOf(0));
        scoreBoardLayoutBinding.teamBFoulScore.setText("Foul : " + String.valueOf(0));

    }

    public void increaseTeamARedCardScore() {
        teamARedCardScoreNumber++;
        animator.startAnimationOnTextView(scoreBoardLayoutBinding.teamARedCardScore);
        scoreBoardLayoutBinding.teamARedCardScore.setText(String.valueOf(teamARedCardScoreNumber));

    }

    public void increaseTeamAMainScore() {
        teamAMainScoreNumber++;
        animator.startAnimationOnTextView(scoreBoardLayoutBinding.teamAScore);
        scoreBoardLayoutBinding.teamAScore.setText(String.valueOf(teamAMainScoreNumber));
    }

    public void increaseTeamAYellowCardScore() {
        teamAYellowCardScoreNumber++;
        animator.startAnimationOnTextView(scoreBoardLayoutBinding.teamAYellowCardScore);
        scoreBoardLayoutBinding.teamAYellowCardScore.setText(String.valueOf(teamAYellowCardScoreNumber));
    }

    public void increaseTeamAFoulCardScore() {
        teamAFoulCardScoreNumber++;
        animator.startAnimationOnTextView(scoreBoardLayoutBinding.teamAFoulScore);
        scoreBoardLayoutBinding.teamAFoulScore.setText("Foul : " + String.valueOf(teamAFoulCardScoreNumber));
    }

    public void increaseTeamBRedCardScore() {
        teamBRedCardScoreNumber++;
        animator.startAnimationOnTextView(scoreBoardLayoutBinding.teamBRedCardScore);
        scoreBoardLayoutBinding.teamBRedCardScore.setText(String.valueOf(teamBRedCardScoreNumber));
    }

    public void increaseTeamBMainScore() {
        teamBMainScoreNumber++;
        animator.startAnimationOnTextView(scoreBoardLayoutBinding.teamBScore);
        scoreBoardLayoutBinding.teamBScore.setText(String.valueOf(teamBMainScoreNumber));
    }

    public void increaseTeamBYellowCardScore() {
        teamBYellowCardScoreNumber++;
        animator.startAnimationOnTextView(scoreBoardLayoutBinding.teamBYellowCardScore);
        scoreBoardLayoutBinding.teamBYellowCardScore.setText(String.valueOf(teamBYellowCardScoreNumber));
    }

    public void increaseTeamBFoulCardScore() {
        teamBFoulCardScoreNumber++;
        animator.startAnimationOnTextView(scoreBoardLayoutBinding.teamBFoulScore);
        scoreBoardLayoutBinding.teamBFoulScore.setText("Foul : " + String.valueOf(teamBFoulCardScoreNumber));
    }
}
