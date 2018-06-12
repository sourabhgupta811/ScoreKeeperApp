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
import com.example.android.scorekeeperapp.databinding.TeamAButtonsLayoutBinding;

public class TeamAFragment extends Fragment {
    TeamAButtonListener buttonListener;
    TeamAButtonsLayoutBinding teamABinding;
    CustomAnimator customAnimator;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        buttonListener = (TeamAButtonListener) context;
        customAnimator = new CustomAnimator(context);
        if (buttonListener == null)
            throw new ClassCastException();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        teamABinding = DataBindingUtil.inflate(inflater, R.layout.team_a_buttons_layout, container, false);
        View v = teamABinding.getRoot();
        implementListeners();
        return v;
    }

    private void implementListeners() {
        customAnimator.setButtonAnimationListener(teamABinding.teamAGoalButton);
        customAnimator.setButtonAnimationListener(teamABinding.teamAFoulButton);
        customAnimator.setButtonAnimationListener(teamABinding.teamAYellowButton);
        customAnimator.setButtonAnimationListener(teamABinding.teamARedButton);

        teamABinding.teamAGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener.onTeamAGoalButtonClicked();
            }
        });
        teamABinding.teamARedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener.onTeamARedButtonClicked();
            }
        });
        teamABinding.teamAYellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener.onTeamAYellowButtonClicked();
            }
        });
        teamABinding.teamAFoulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener.onTeamAFoulButtonClicked();
            }
        });
    }

    public interface TeamAButtonListener {
        void onTeamAGoalButtonClicked();

        void onTeamARedButtonClicked();

        void onTeamAYellowButtonClicked();

        void onTeamAFoulButtonClicked();

    }
}
