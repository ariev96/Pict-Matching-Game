package com.badlogic.pictmatchinggame.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.badlogic.pictmatchinggame.R;
import com.badlogic.pictmatchinggame.common.Music;
import com.badlogic.pictmatchinggame.common.Shared;
import com.badlogic.pictmatchinggame.utils.FontLoader;
import com.badlogic.pictmatchinggame.utils.FontLoader.Font;

public class PopupSettingsView extends LinearLayout {

	private ImageView mSoundImage;
	private TextView mSoundText;

	public PopupSettingsView(Context context) {
		this(context, null);
	}

	public PopupSettingsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(LinearLayout.VERTICAL);
		setBackgroundResource(R.drawable.settings_popup);
		LayoutInflater.from(getContext()).inflate(R.layout.popup_settings_view, this, true);
		mSoundText = (TextView) findViewById(R.id.sound_off_text);
		TextView rateView = (TextView) findViewById(R.id.rate_text);
		TextView reportView = (TextView) findViewById(R.id.report_text);
		mSoundText.setTextColor(Color.parseColor("#844325"));
		rateView.setTextColor(Color.parseColor("#844325"));
		reportView.setTextColor(Color.parseColor("#844325"));
		FontLoader.setTypeface(context, new TextView[] { mSoundText, rateView }, Font.GROBOLD);
		FontLoader.setTypeface(context, new TextView[] { mSoundText, reportView }, Font.GROBOLD);
		mSoundImage = (ImageView) findViewById(R.id.sound_image);
		View soundOff = findViewById(R.id.sound_off);
		soundOff.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Music.OFF = !Music.OFF;
				setMusicButton();
			}
		});
		View rate = findViewById(R.id.rate);
		rate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final String appPackageName = Shared.context.getPackageName();
				try {
					Shared.activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
				} catch (android.content.ActivityNotFoundException anfe) {
					Shared.activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
				}
			}
		});

        View laporbug = findViewById(R.id.reportbug);
        laporbug.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "idlabs.developer@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "[Report Bug] Pict Matching Game");
               // intent.putExtra(Intent.EXTRA_TEXT, "mail body");
               	Shared.activity.startActivity(intent);
            }
        });
		setMusicButton();
	}

	private void setMusicButton() {
		if (Music.OFF) {
			mSoundText.setText("Sound OFF");
			mSoundImage.setImageResource(R.drawable.button_music_off);
		} else {
			mSoundText.setText("Sound ON");
			mSoundImage.setImageResource(R.drawable.button_music_on);
		}
	}
}
