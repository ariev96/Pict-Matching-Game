package com.badlogic.pictmatchinggame.events;

import com.badlogic.pictmatchinggame.events.engine.FlipDownCardsEvent;
import com.badlogic.pictmatchinggame.events.engine.GameWonEvent;
import com.badlogic.pictmatchinggame.events.engine.HidePairCardsEvent;
import com.badlogic.pictmatchinggame.events.ui.BackGameEvent;
import com.badlogic.pictmatchinggame.events.ui.DifficultySelectedEvent;
import com.badlogic.pictmatchinggame.events.ui.FlipCardEvent;
import com.badlogic.pictmatchinggame.events.ui.NextGameEvent;
import com.badlogic.pictmatchinggame.events.ui.PauseGameEvent;
import com.badlogic.pictmatchinggame.events.ui.ResetBackgroundEvent;
import com.badlogic.pictmatchinggame.events.ui.StartEvent;
import com.badlogic.pictmatchinggame.events.ui.ThemeSelectedEvent;


public interface EventObserver {

	void onEvent(FlipCardEvent event);

	void onEvent(DifficultySelectedEvent event);

	void onEvent(HidePairCardsEvent event);

	void onEvent(FlipDownCardsEvent event);

	void onEvent(StartEvent event);

	void onEvent(ThemeSelectedEvent event);

	void onEvent(GameWonEvent event);

	void onEvent(BackGameEvent event);

	void onEvent(NextGameEvent event);

	void onEvent(ResetBackgroundEvent event);

    void onEvent(PauseGameEvent event);
}
