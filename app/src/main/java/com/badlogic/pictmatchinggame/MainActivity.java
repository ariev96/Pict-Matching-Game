package com.badlogic.pictmatchinggame;



import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.badlogic.pictmatchinggame.common.Shared;
import com.badlogic.pictmatchinggame.engine.Engine;
import com.badlogic.pictmatchinggame.engine.ScreenController;
import com.badlogic.pictmatchinggame.engine.ScreenController.Screen;
import com.badlogic.pictmatchinggame.events.EventBus;
import com.badlogic.pictmatchinggame.events.ui.BackGameEvent;
import com.badlogic.pictmatchinggame.ui.PopupManager;
import com.badlogic.pictmatchinggame.utils.Utils;

/**
 * Created by arief budiman on 17/01/2018.
 */


public class MainActivity extends FragmentActivity {

	private ImageView mBackgroundImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Shared.context = getApplicationContext();
		Shared.engine = Engine.getInstance();
		Shared.eventBus = EventBus.getInstance();

		setContentView(R.layout.activity_main);


		mBackgroundImage = (ImageView) findViewById(R.id.background_image);

		Shared.activity = this;
		Shared.engine.start();
		Shared.engine.setBackgroundImageView(mBackgroundImage);

		// set background
		setBackgroundImage();

		// set menu
		ScreenController.getInstance().openScreen(Screen.MENU);


	}

	@Override
	protected void onDestroy() {
		Shared.engine.stop();
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {
		if (PopupManager.isShown()) {
			PopupManager.closePopup();
			if (ScreenController.getLastScreen() == Screen.GAME) {
				Shared.eventBus.notify(new BackGameEvent());
			}
		} else if (ScreenController.getInstance().onBack()) {
			super.onBackPressed();
		}
	}

	private void setBackgroundImage() {
		Bitmap bitmap = Utils.scaleDown(R.drawable.background_2, Utils.screenWidth(), Utils.screenHeight());
		bitmap = Utils.crop(bitmap, Utils.screenHeight(), Utils.screenWidth());
		bitmap = Utils.downscaleBitmap(bitmap, 2);
		mBackgroundImage.setImageBitmap(bitmap);
	}


}
