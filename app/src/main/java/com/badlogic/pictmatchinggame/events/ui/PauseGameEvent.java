package com.badlogic.pictmatchinggame.events.ui;

import com.badlogic.pictmatchinggame.events.AbstractEvent;
import com.badlogic.pictmatchinggame.events.EventObserver;

/**
 * Created by arief budiman on 24/01/2018.
 */

public class PauseGameEvent extends AbstractEvent {

    public static final String TYPE = PauseGameEvent.class.getName();

    @Override
    protected void fire(EventObserver eventObserver) {
        eventObserver.onEvent(this);
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
