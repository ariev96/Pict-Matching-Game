package com.badlogic.pictmatchinggame.events.ui;

import com.badlogic.pictmatchinggame.common.Music;
import com.badlogic.pictmatchinggame.events.AbstractEvent;
import com.badlogic.pictmatchinggame.events.EventObserver;

/**
 * When the 'back to menu' was pressed.
 */
public class BackGameEvent extends AbstractEvent {

	public static final String TYPE = BackGameEvent.class.getName();

	@Override
	protected void fire(EventObserver eventObserver) {
		eventObserver.onEvent(this);

	}

	@Override
	public String getType() {
		return TYPE;
	}

}
