package com.example.changishaapp.classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.changishaapp.R;
import com.example.changishaapp.classes.MainActivity;

public class Splash extends AppCompatActivity {

    Animation zoom;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        zoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        img = findViewById(R.id.imageView);
        img.startAnimation(zoom);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class );
                startActivity(i);

                finish();

            }
        },4000);
    }
}