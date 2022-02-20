package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CropProtection extends AppCompatActivity {

    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_protection);

        imageView1=findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CropProtection.this, Apple.class);
                // myIntent.putExtra("key", value); //Optional parameters
                CropProtection.this.startActivity(myIntent);
            }
        });

        imageView2=findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CropProtection.this, Onion.class);
                // myIntent.putExtra("key", value); //Optional parameters
                CropProtection.this.startActivity(myIntent);
            }
        });

        imageView3=findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CropProtection.this, Potato.class);
                // myIntent.putExtra("key", value); //Optional parameters
                CropProtection.this.startActivity(myIntent);
            }
        });

        imageView4=findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CropProtection.this, Cabbage.class);
                // myIntent.putExtra("key", value); //Optional parameters
                CropProtection.this.startActivity(myIntent);
            }
        });

        imageView5=findViewById(R.id.imageView5);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CropProtection.this, Chilli.class);
                // myIntent.putExtra("key", value); //Optional parameters
                CropProtection.this.startActivity(myIntent);
            }
        });

        imageView6=findViewById(R.id.imageView6);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CropProtection.this, Cotton.class);
                // myIntent.putExtra("key", value); //Optional parameters
                CropProtection.this.startActivity(myIntent);
            }
        });

        imageView7=findViewById(R.id.imageView7);
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CropProtection.this, Wheat.class);
                // myIntent.putExtra("key", value); //Optional parameters
                CropProtection.this.startActivity(myIntent);
            }
        });

        imageView8=findViewById(R.id.imageView8);
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CropProtection.this, Tomato.class);
                // myIntent.putExtra("key", value); //Optional parameters
                CropProtection.this.startActivity(myIntent);
            }
        });


    }
}