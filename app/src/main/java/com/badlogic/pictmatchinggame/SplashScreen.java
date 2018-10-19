package com.badlogic.pictmatchinggame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;


/**
 * Created by arief budiman on 17/01/2018.
 */

public class SplashScreen extends FragmentActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen_view);




        Thread myThread = new Thread(){

            @Override
            public void run() {
                super.run();
                try {

                    sleep(3000);

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }


}
