package com.badlogic.pictmatchinggame.events.ui;

import com.badlogic.pictmatchinggame.common.Music;
import com.badlogic.pictmatchinggame.events.AbstractEvent;
import com.badlogic.pictmatchinggame.events.EventObserver;
import com.badlogic.pictmatchinggame.themes.Theme;

public class ThemeSelectedEvent extends AbstractEvent {

	public static final String TYPE = ThemeSelectedEvent.class.getName();
	public final Theme theme;

	public ThemeSelectedEvent(Theme theme) {
		this.theme = theme;
	}

	@Override
	protected void fire(EventObserver eventObserver) {
		eventObserver.onEvent(this);

	}

	@Override
	public String getType() {
		return TYPE;

	}

}
