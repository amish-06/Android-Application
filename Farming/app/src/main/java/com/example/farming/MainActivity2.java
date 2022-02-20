package com.example.farming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12;
    private TextView welcomeUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        imageView1=findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, BuySeed.class);
               // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        imageView2=findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, HybridSeed.class);
                // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        imageView3=findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, CropProtection.class);
                // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        imageView4=findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, ScanandEarnHomePage.class);
                // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        imageView5=findViewById(R.id.imageView5);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, CropAdvisory.class);
                // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        imageView6=findViewById(R.id.imageView6);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, CropDiagnostic.class);
                // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        imageView7=findViewById(R.id.imageView7);
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, SoilCheck.class);
                // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        imageView8=findViewById(R.id.imageView8);
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, SparyService.class);
                // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        imageView9=findViewById(R.id.imageView9);
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, MyRewards.class);
                // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        imageView10=findViewById(R.id.imageView10);
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, MyCopons.class);
                // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        imageView11=findViewById(R.id.imageView11);
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, ScanandEarnHomePage2.class);
                // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        imageView12=findViewById(R.id.imageView12);
        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(com.example.farming.MainActivity2.this, Refer.class);
                // myIntent.putExtra("key", value); //Optional parameters
                com.example.farming.MainActivity2.this.startActivity(myIntent);
            }
        });

        Button logoutButton = findViewById(R.id.log_out_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout(v);
            }
        });

        welcomeUser = findViewById(R.id.textView39);
        String user = getIntent().getStringExtra("username");
        welcomeUser.setText("Welcome "+user);
    }

    public void logout(View view) {
        Intent intent = new Intent(MainActivity2.this,Login.class);
        startActivity(intent);
        finish();
        Toast.makeText(this, "Successfully Logged Out", Toast.LENGTH_SHORT).show();
    }
}