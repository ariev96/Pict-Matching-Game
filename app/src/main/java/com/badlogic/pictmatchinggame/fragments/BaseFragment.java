package com.badlogic.pictmatchinggame.fragments;

import android.support.v4.app.Fragment;

import com.badlogic.pictmatchinggame.events.EventObserver;
import com.badlogic.pictmatchinggame.events.engine.FlipDownCardsEvent;
import com.badlogic.pictmatchinggame.events.engine.GameWonEvent;
import com.badlogic.pictmatchinggame.events.engine.HidePairCardsEvent;
import com.badlogic.pictmatchinggame.events.ui.BackGameEvent;
import com.badlogic.pictmatchinggame.events.ui.FlipCardEvent;
import com.badlogic.pictmatchinggame.events.ui.NextGameEvent;
import com.badlogic.pictmatchinggame.events.ui.PauseGameEvent;
import com.badlogic.pictmatchinggame.events.ui.ResetBackgroundEvent;
import com.badlogic.pictmatchinggame.events.ui.ThemeSelectedEvent;
import com.badlogic.pictmatchinggame.events.ui.DifficultySelectedEvent;
import com.badlogic.pictmatchinggame.events.ui.StartEvent;

public class BaseFragment extends Fragment implements EventObserver {

	@Override
	public void onEvent(FlipCardEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(DifficultySelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(HidePairCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(FlipDownCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(StartEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(ThemeSelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(GameWonEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(BackGameEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(NextGameEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(ResetBackgroundEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(PauseGameEvent pauseGameEvent) {
		throw new UnsupportedOperationException();
	}

}
