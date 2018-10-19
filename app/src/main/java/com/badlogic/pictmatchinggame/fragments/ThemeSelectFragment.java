package com.badlogic.pictmatchinggame.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.badlogic.pictmatchinggame.R;
import com.badlogic.pictmatchinggame.common.Memory;
import com.badlogic.pictmatchinggame.common.Music;
import com.badlogic.pictmatchinggame.common.Shared;
import com.badlogic.pictmatchinggame.events.ui.ThemeSelectedEvent;
import com.badlogic.pictmatchinggame.themes.Theme;
import com.badlogic.pictmatchinggame.themes.Themes;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import java.util.Locale;

/**
 * Created by arief budiman on 17/01/2018.
 */

public class ThemeSelectFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = LayoutInflater.from(Shared.context).inflate(R.layout.theme_select_fragment, container, false);
		View animals = view.findViewById(R.id.theme_animals_container);
		View monsters = view.findViewById(R.id.theme_monsters_container);
		View emoji = view.findViewById(R.id.theme_emoji_container);
		View vegetables = view.findViewById(R.id.tema_sayur);

		AdView mAdView = (AdView) view.findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);


		//Music.stopBackgroundMusic();

		final Theme themeAnimals = Themes.createAnimalsTheme();
		setStars((ImageView) animals.findViewById(R.id.theme_animals), themeAnimals, "animals");
		final Theme themeMonsters = Themes.createMosterTheme();
		setStars((ImageView) monsters.findViewById(R.id.theme_monsters), themeMonsters, "monsters");
		final Theme themeEmoji = Themes.createEmojiTheme();
		setStars((ImageView) emoji.findViewById(R.id.theme_emoji), themeEmoji, "emoji");
		final Theme themeVegetables = Themes.createVegetablesTheme();
		setStars((ImageView) vegetables.findViewById(R.id.gambar_sayur), themeVegetables, "vegetables");
		//setStars((ImageView) vegetables.findViewById(R.id.gambar_sayur), themeVegetables, "sayur");

		animals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeAnimals));
			}
		});

		monsters.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeMonsters));
			}
		});

		emoji.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeEmoji));
			}
		});

		vegetables.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeVegetables));
			}
		});

		/**
		 * Imporove performance first!!!
		 */
		animateShow(animals);
		animateShow(monsters);
		animateShow(emoji);
		animateShow(vegetables);

		

		return view;
	}

	private void animateShow(View view) {
		ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.5f, 1f);
		ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1f);
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.setDuration(300);
		animatorSet.playTogether(animatorScaleX, animatorScaleY);
		animatorSet.setInterpolator(new DecelerateInterpolator(2));
		view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		animatorSet.start();
	}

	private void setStars(ImageView imageView, Theme theme, String type) {
		int sum = 0;
		for (int difficulty = 1; difficulty <= 6; difficulty++) {
			sum += Memory.getHighStars(theme.id, difficulty);
		}
		int num = sum / 6;
		if (num != 0) {
			String drawableResourceName = String.format(Locale.US, type + "_theme_star_%d", num);
			int drawableResourceId = Shared.context.getResources().getIdentifier(drawableResourceName, "drawable", Shared.context.getPackageName());
			imageView.setImageResource(drawableResourceId);
		}
	}


}
