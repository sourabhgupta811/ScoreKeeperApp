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
    private static final String TEAM_A_RED_CARD_SCORE_KEY = "teamARedCardScoreNumber";
    private static final String TEAM_A_YELLOW_CARD_SCORE_KEY = "teamAYellowCardScoreNumber";
    private static final String TEAM_A_MAIN_CARD_SCORE_KEY = "teamAMainScoreNumber";
    private static final String TEAM_A_FOUL_CARD_SCORE_KEY = "teamAFoulCardScoreNumber";
    private static final String TEAM_B_RED_CARD_SCORE_KEY = "teamBRedCardScoreNumber";
    private static final String TEAM_B_YELLOW_CARD_SCORE_KEY = "teamBYellowCardScoreNumber";
    private static final String TEAM_B_MAIN_CARD_SCORE_KEY = "teamBMainScoreNumber";
    private static final String TEAM_B_FOUL_CARD_SCORE_KEY = "teamBFoulCardScoreNumber";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        scoreBoardLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.score_board_layout, container, false);
        animator = new CustomAnimator(getActivity());
        return scoreBoardLayoutBinding.getRoot();

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TEAM_A_RED_CARD_SCORE_KEY,teamARedCardScoreNumber);
        outState.putInt(TEAM_A_YELLOW_CARD_SCORE_KEY,teamAYellowCardScoreNumber);
        outState.putInt(TEAM_A_MAIN_CARD_SCORE_KEY,teamAMainScoreNumber);
        outState.putInt(TEAM_A_FOUL_CARD_SCORE_KEY,teamAFoulCardScoreNumber);
        outState.putInt(TEAM_B_RED_CARD_SCORE_KEY,teamBRedCardScoreNumber);
        outState.putInt(TEAM_B_YELLOW_CARD_SCORE_KEY,teamBYellowCardScoreNumber);
        outState.putInt(TEAM_B_MAIN_CARD_SCORE_KEY,teamBMainScoreNumber);
        outState.putInt(TEAM_B_FOUL_CARD_SCORE_KEY,teamBFoulCardScoreNumber);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null){
            teamARedCardScoreNumber = savedInstanceState.getInt(TEAM_A_RED_CARD_SCORE_KEY);
            teamAFoulCardScoreNumber = savedInstanceState.getInt(TEAM_A_FOUL_CARD_SCORE_KEY);
            teamAMainScoreNumber = savedInstanceState.getInt(TEAM_A_MAIN_CARD_SCORE_KEY);
            teamAYellowCardScoreNumber = savedInstanceState.getInt(TEAM_A_YELLOW_CARD_SCORE_KEY);
            teamBRedCardScoreNumber = savedInstanceState.getInt(TEAM_B_RED_CARD_SCORE_KEY);
            teamBFoulCardScoreNumber = savedInstanceState.getInt(TEAM_B_FOUL_CARD_SCORE_KEY);
            teamBMainScoreNumber = savedInstanceState.getInt(TEAM_B_MAIN_CARD_SCORE_KEY);
            teamBYellowCardScoreNumber = savedInstanceState.getInt(TEAM_B_YELLOW_CARD_SCORE_KEY);
            setState();
        }
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
        setState();
    }
    public void setState() {
        scoreBoardLayoutBinding.teamARedCardScore.setText(String.valueOf(teamARedCardScoreNumber));
        scoreBoardLayoutBinding.teamAScore.setText(String.valueOf(teamAMainScoreNumber));
        scoreBoardLayoutBinding.teamAYellowCardScore.setText(String.valueOf(teamAYellowCardScoreNumber));
        scoreBoardLayoutBinding.teamAFoulScore.setText("Foul : " + String.valueOf(teamAFoulCardScoreNumber));
        scoreBoardLayoutBinding.teamBRedCardScore.setText(String.valueOf(teamBRedCardScoreNumber));
        scoreBoardLayoutBinding.teamBScore.setText(String.valueOf(teamBMainScoreNumber));
        scoreBoardLayoutBinding.teamBYellowCardScore.setText(String.valueOf(teamBYellowCardScoreNumber));
        scoreBoardLayoutBinding.teamBFoulScore.setText("Foul : " + String.valueOf(teamBFoulCardScoreNumber));
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
