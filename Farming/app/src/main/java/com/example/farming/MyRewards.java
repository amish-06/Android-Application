package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyRewards extends AppCompatActivity {

    Button refer_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rewards);

        refer_button=findViewById(R.id.refer_button);
        refer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MyRewards.this, Refer.class);
                // myIntent.putExtra("key", value); //Optional parameters
                MyRewards.this.startActivity(myIntent);
            }
        });
    }
}