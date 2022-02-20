package com.example.farming;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 2000;
    Animation leftAnim, rightAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        leftAnim = AnimationUtils.loadAnimation(this,R.anim.left_animation);
        rightAnim = AnimationUtils.loadAnimation(this,R.anim.right_animation);

        ImageView logo = findViewById(R.id.appLogo);
        TextView welcomeUser = findViewById(R.id.welcomeText);

        logo.setAnimation(leftAnim);
        welcomeUser.setAnimation(rightAnim);

        String user = getIntent().getStringExtra("username");
        welcomeUser.setText("Hi, "+user+".");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this,MainActivity2.class);
                intent.putExtra("username",user);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}