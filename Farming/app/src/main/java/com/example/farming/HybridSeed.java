package com.example.farming;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class HybridSeed extends AppCompatActivity {

    Spinner spinner;
    Button fab_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hybrid_seed);

        spinner = (Spinner) findViewById(R.id.spinner1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.crop_array2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.hybrid_array1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.hybrid_array2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.hybrid_array3, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                if (position == 0) {
                    spinner2.setAdapter(adapter1);
                } else if (position == 1) {
                    spinner2.setAdapter(adapter2);
                } else {
                    spinner2.setAdapter(adapter3);
                }

            }

            public void onNothingSelected(AdapterView<?> arg0) {// do nothing
            }

        });

        fab_button=findViewById(R.id.fab_button);
        fab_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spinner.getSelectedItem().toString().equals("Corn"))
                {
                   if(spinner2.getSelectedItem().toString().equals("P3401"))
                   {
                       String url = "https://www.upcaronline.org/page.php?title=Kharif%20Maize%20Report%20(2014)";
                       Intent i = new Intent(Intent.ACTION_VIEW);
                       i.setData(Uri.parse(url));
                       startActivity(i);

                   }
                    if(spinner2.getSelectedItem().toString().equals("P3377"))
                    {
                        String url = "https://www.researchgate.net/publication/225364395_Abscisic_acid-regulated_Glb1_transient_expression_in_cultured_maize_P3377_cells";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                }
                if(spinner.getSelectedItem().toString().equals("Rice"))
                {
                    if(spinner2.getSelectedItem().toString().equals("27P31"))
                    {
                        String url = "https://upcaronline.org/upload/5527c2a8139beKharif%20Rice%20Report%20(2014).pdf";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                    if(spinner2.getSelectedItem().toString().equals("27P63"))
                    {
                        String url = "https://upcaronline.org/upload/5527c2a8139beKharif%20Rice%20Report%20(2014).pdf";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                    if(spinner2.getSelectedItem().toString().equals("28P67"))
                    {
                        String url = "https://www.researchgate.net/publication/329767226_PERFORMANCE_OF_RICE_HYBRIDS_IN_EASTERN_GANGETIC_ALLUVIAL_ZONE_OF_WEST_BENGAL_INDIA";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                    if(spinner2.getSelectedItem().toString().equals("27P37"))
                    {
                        String url = "https://www.researchgate.net/publication/329767226_PERFORMANCE_OF_RICE_HYBRIDS_IN_EASTERN_GANGETIC_ALLUVIAL_ZONE_OF_WEST_BENGAL_INDIA";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                }
                if(spinner.getSelectedItem().toString().equals("Mustard"))
                {
                    if(spinner2.getSelectedItem().toString().equals("45S35"))
                    {
                        String url = "https://www.researchgate.net/publication/348929249_Evaluation_of_Mustard_hybrids_2019-20";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                    if(spinner2.getSelectedItem().toString().equals("45S46"))
                    {
                        String url = "https://www.ijcmas.com/10-1-2021/Tarun%20Thakur,%20et%20al.pdf";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                }
            }
        });

    }
}