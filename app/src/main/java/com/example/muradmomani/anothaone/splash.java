package com.example.muradmomani.anothaone;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash);
        LinearLayout linearLayout = new LinearLayout(this);
        ImageView imageView = new ImageView(this);
        Display display = getWindowManager(). getDefaultDisplay();
        Point size = new Point();
        display. getSize(size);
        int width = size. x;
        int height = size. y;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
        imageView.setImageResource(R.drawable.backgroundlogo);

        linearLayout.addView(imageView, layoutParams);
        setContentView(linearLayout);
        final Intent mySuperIntent = new Intent(this, login.class);

        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(mySuperIntent);
                    /* This 'finish()' is for exiting the app when back button pressed
                     *  from Home page which is ActivityHome
                     */
                    finish();

                }


                //Do any action here. Now we are moving to next page

            }
        };
        timer.start();
    }
}

