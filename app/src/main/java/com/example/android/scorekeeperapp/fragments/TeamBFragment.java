package com.example.android.scorekeeperapp.fragments;

import android.content.Context;
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
import com.example.android.scorekeeperapp.databinding.TeamBButtonsLayoutBinding;

public class TeamBFragment extends Fragment {
    TeamBButtonListener buttonListener;
    TeamBButtonsLayoutBinding teamBButtonsLayoutBinding;
    CustomAnimator customAnimator;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        buttonListener = (TeamBButtonListener) context;
        customAnimator = new CustomAnimator(context);
        if (buttonListener == null)
            throw new ClassCastException();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        teamBButtonsLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.team_b_buttons_layout, container, false);
        View v = teamBButtonsLayoutBinding.getRoot();
        implementListeners();
        return v;
    }

    private void implementListeners() {
        customAnimator.setButtonAnimationListener(teamBButtonsLayoutBinding.teamBGoalButton);
        customAnimator.setButtonAnimationListener(teamBButtonsLayoutBinding.teamBFoulButton);
        customAnimator.setButtonAnimationListener(teamBButtonsLayoutBinding.teamBRedButton);
        customAnimator.setButtonAnimationListener(teamBButtonsLayoutBinding.teamBYellowButton);
        teamBButtonsLayoutBinding.teamBGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener.onTeamBGoalButtonClicked();
            }
        });
        teamBButtonsLayoutBinding.teamBRedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener.onTeamBRedButtonClicked();
            }
        });
        teamBButtonsLayoutBinding.teamBYellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener.onTeamBYellowButtonClicked();
            }
        });
        teamBButtonsLayoutBinding.teamBFoulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener.onTeamBFoulButtonClicked();
            }
        });
    }

    public interface TeamBButtonListener {
        void onTeamBGoalButtonClicked();

        void onTeamBRedButtonClicked();

        void onTeamBYellowButtonClicked();

        void onTeamBFoulButtonClicked();
    }
}
