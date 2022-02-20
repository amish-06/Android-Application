package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Pattern;

public class ResetPassword extends AppCompatActivity {

    private TextInputLayout newPass, reNewPass;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%&!^*])(?=\\S+$).{6,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        newPass = findViewById(R.id.newPassword);
        reNewPass = findViewById(R.id.reNewPassword);

        String passedEmail = getIntent().getStringExtra("passEmail");
        String passedPhone = getIntent().getStringExtra("passPhone");

        Button resetBtn = findViewById(R.id.resetPassButton);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset(v, passedEmail,passedPhone);
            }
        });
    }

    public void reset(View view,String email, String phone) {
        DBHelper dbHelper = new DBHelper(this);
        if(!validatePassword1() | !validatePassword2()) {
            return;
        }
        String pass1, pass2;
        pass1 = Objects.requireNonNull(newPass.getEditText().getText()).toString().trim();
        pass2 = Objects.requireNonNull(reNewPass.getEditText().getText()).toString().trim();
        if(pass1.equals(pass2)) {
            dbHelper.resetPassword(pass1, email, phone);
            Toast.makeText(this, "Password reset successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ResetPassword.this,Login.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this, "Passwords mismatch", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validatePassword1() {
        String passwordInput = newPass.getEditText().getText().toString().trim();
        if(passwordInput.isEmpty()) {
            newPass.setError("Field can't be empty");
            return false;
        }
        else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            newPass.setError("Enter a valid password");
            return false;
        }
        else {
            newPass.setError(null);
            newPass.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword2() {
        String passwordInput = reNewPass.getEditText().getText().toString().trim();
        if(passwordInput.isEmpty()) {
            reNewPass.setError("Field can't be empty");
            return false;
        }
        else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            reNewPass.setError("Enter a valid password");
            return false;
        }
        else {
            reNewPass.setError(null);
            reNewPass.setErrorEnabled(false);
            return true;
        }
    }
}