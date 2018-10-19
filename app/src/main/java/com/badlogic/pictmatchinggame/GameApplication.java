package com.badlogic.pictmatchinggame;

import android.app.Application;

import com.badlogic.pictmatchinggame.utils.FontLoader;

public class GameApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		FontLoader.loadFonts(this);

	}
}
