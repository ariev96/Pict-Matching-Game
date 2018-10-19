package com.badlogic.pictmatchinggame.common;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.badlogic.pictmatchinggame.R;

/**
 * Created by arief budiman on 17/01/2018.
 */

public class Music {

	public static boolean OFF = false;
	public static boolean ON = true;

	public static void playCorrent() {
		if (!OFF) {
			MediaPlayer mp = MediaPlayer.create(Shared.context, R.raw.correct_answer);
			mp.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					mp.reset();
					mp.release();
					mp = null;
				}

			});
			mp.start();
		}
	}

	public static void playBackgroundMusic() {
		// TODO
		/*if (!OFF) {
			MediaPlayer mp = MediaPlayer.create(Shared.context, R.raw.background_music_3);
			mp.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					mp.reset();
					mp.release();
					mp = null;
				}

			});
			mp.start();
		}*/
	}

	public static void stopBackgroundMusic() {
		// TODO
		if (!ON) {
			MediaPlayer mp = MediaPlayer.create(Shared.context, R.raw.background_music_3);
			mp.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					mp.reset();
					mp.release();
					mp = null;
				}

			});
			mp.stop();
		}
	}

	public static void showStar() {
		if (!OFF) {
			MediaPlayer mp = MediaPlayer.create(Shared.context, R.raw.star);
			mp.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					mp.reset();
					mp.release();
					mp = null;
				}

			});
			mp.start();
		}
	}
}
