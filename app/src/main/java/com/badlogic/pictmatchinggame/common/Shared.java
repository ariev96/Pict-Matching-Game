package com.badlogic.pictmatchinggame.common;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.badlogic.pictmatchinggame.engine.Engine;
import com.badlogic.pictmatchinggame.events.EventBus;

public class Shared {

	public static Context context;
	public static FragmentActivity activity; // it's fine for this app, but better move to weak reference
	public static Engine engine;
	public static EventBus eventBus;

}
