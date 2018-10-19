package com.badlogic.pictmatchinggame.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.badlogic.pictmatchinggame.R;
import com.badlogic.pictmatchinggame.common.Shared;
import com.badlogic.pictmatchinggame.events.ui.BackGameEvent;
import com.badlogic.pictmatchinggame.utils.FontLoader;

/**
 * Created by arief budiman on 20/01/2018.
 */

public class PopupPauseView extends LinearLayout {

    private TextView mPauseText;
    private Button mButtonOK;
    private Button mButtonCancel;


    public PopupPauseView(Context context) {
        super(context, null);
    }

    public PopupPauseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundResource(R.drawable.settings_popup);
        LayoutInflater.from(getContext()).inflate(R.layout.popup_pause_view, this, true);
        mPauseText = (TextView) findViewById(R.id.pause_text);
        Button btnOK = (Button) findViewById(R.id.button_ok);
        Button btnCancel = (Button) findViewById(R.id.button_cancel);
        FontLoader.setTypeface(context, new TextView[] { mPauseText, btnOK }, FontLoader.Font.GROBOLD);
        FontLoader.setTypeface(context, new TextView[] { mPauseText, btnCancel }, FontLoader.Font.GROBOLD);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Shared.eventBus.notify(new BackGameEvent());
            }
        });

    }



}
