package com.example.farming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ScanandEarnHomePage2 extends AppCompatActivity {

    Button scan_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanand_earn_home_page2);
        scan_button=findViewById(R.id.scan_button);
        scan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScanandEarnHomePage2.this, QRScan.class);
                // myIntent.putExtra("key", value); //Optional parameters
                ScanandEarnHomePage2.this.startActivity(myIntent);
            }
        });
    }
}