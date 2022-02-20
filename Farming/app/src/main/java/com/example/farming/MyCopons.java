package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyCopons extends AppCompatActivity {

    Button r_button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_copons);

        r_button = (Button)findViewById(R.id.r_button);
        editText= (EditText)findViewById(R.id.editText);

        r_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText.getText().toString().isEmpty())
                {
                    Toast.makeText(MyCopons.this,"Please Enter Your Coupon Code First",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MyCopons.this,"Sorry!! Invalid Coupon Code",Toast.LENGTH_SHORT).show();
                    editText.getText().clear();
                }

            }
        });

    }
}