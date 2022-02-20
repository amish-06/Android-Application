package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;

public class ForgotPassVerification extends AppCompatActivity {

    private TextInputLayout vEmail, vPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass_verification);

        vEmail = findViewById(R.id.verifyEmail);
        vPhone = findViewById(R.id.verifyPhone);

        Button verifyBtn = findViewById(R.id.forgotPassVerifyButton);
        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify(v);
            }
        });
    }

    public void verify(View view) {
        DBHelper dbHelper = new DBHelper(this);
        if(!validateEmail() | !validatePhone()) {
            return;
        }
        String email, phone;
        email = Objects.requireNonNull(vEmail.getEditText().getText()).toString().trim();
        phone = Objects.requireNonNull(vPhone.getEditText().getText()).toString().trim();
        if(!dbHelper.checkeEmailAndPhone(email, phone)) {
            Toast.makeText(this, "MISMATCH: Account having above Email and Phone does not exists", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Verified", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ForgotPassVerification.this,ResetPassword.class);
            intent.putExtra("passEmail",email);
            intent.putExtra("passPhone",phone);
            startActivity(intent);
        }
    }

    private boolean validateEmail() {
        String emailInput = vEmail.getEditText().getText().toString().trim();
        if(emailInput.isEmpty()) {
            vEmail.setError("Field can't be empty");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            vEmail.setError("Enter a valid email address");
            return false;
        }
        else {
            vEmail.setError(null);
            vEmail.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhone() {
        String phoneInput = vPhone.getEditText().getText().toString().trim();
        if(phoneInput.isEmpty()) {
            vPhone.setError("Field can't be empty");
            return false;
        }
        else if(phoneInput.length() != 10) {
            vPhone.setError("Must contain 10 digits");
            return false;
        }
        else {
            vPhone.setError(null);
            vPhone.setErrorEnabled(false);
            return true;
        }
    }
}