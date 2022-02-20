package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Chilli extends AppCompatActivity {

    ImageView imageView3,imageView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chilli);

        imageView3=findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.amazon.in/Oxyfluorfen-Spectrum-Selective-Herbicide-Onions/dp/B08N4X4FQ2/ref=asc_df_B08N4X4FQ2/?tag=googleshopdes-21&linkCode=df0&hvadid=397083402899&hvpos=&hvnetw=g&hvrand=12441468147301012030&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007824&hvtargid=pla-1365109508876&psc=1&ext_vrnc=hi";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        imageView5=findViewById(R.id.imageView2);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.soilhealth.dac.gov.in/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}