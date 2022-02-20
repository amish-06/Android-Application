package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Cotton extends AppCompatActivity {

    ImageView imageView3,imageView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotton);

        imageView3=findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.amazon.in/Tracer-7-ml-Dow-Agroscience/dp/B07MKG4QPN";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        imageView5=findViewById(R.id.imageView2);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.amazon.in/Vijaya-Agro-Industries-Predator-Insecticide-1/dp/B08C4YNKL7/ref=asc_df_B08C4YNKL7/?tag=googleshopdes-21&linkCode=df0&hvadid=397081037195&hvpos=&hvnetw=g&hvrand=1855700395880826129&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007824&hvtargid=pla-947079687098&psc=1&ext_vrnc=hi";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}