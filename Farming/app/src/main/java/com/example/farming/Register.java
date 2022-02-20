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
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%&!^*])(?=\\S+$).{6,}$");
    private TextInputLayout regFullName, regUserName, regEmail, regPhone, regPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regFullName = findViewById(R.id.fullname);
        regUserName = findViewById(R.id.usernameR);
        regEmail = findViewById(R.id.email);
        regPhone = findViewById(R.id.phone);
        regPassword = findViewById(R.id.passwordR);

        Button oldUserBtn = findViewById(R.id.oldUserButton);
        oldUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { goToLogin(v);}
        });

        Button regBtn = findViewById(R.id.registerButton);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { registerUser(v);}
        });
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(Register.this,Login.class);
        startActivity(intent);
    }

    public void registerUser(View view) {
        DBHelper dbHelper = new DBHelper(this);
        if(!validateUsername() | !validateFullname() | !validateEmail() | !validatePhone() | !validatePassword()) {
            return;
        }
        String fullname, username, email, phone, password;
        fullname = Objects.requireNonNull(regFullName.getEditText().getText()).toString().trim();
        username = Objects.requireNonNull(regUserName.getEditText().getText()).toString().trim();
        email = Objects.requireNonNull(regEmail.getEditText().getText()).toString().trim();
        phone = Objects.requireNonNull(regPhone.getEditText().getText()).toString().trim();
        password = Objects.requireNonNull(regPassword.getEditText().getText()).toString().trim();
        if(dbHelper.checkPhone(phone)){
            Toast.makeText(this, "Phone number registered with an already existing account", Toast.LENGTH_SHORT).show();
        }
        else if (dbHelper.checkEmail(email)) {
            Toast.makeText(this, "E-mail registered with an already existing account", Toast.LENGTH_SHORT).show();
        }
        else if (dbHelper.checkUser(username)) {
            Toast.makeText(this, "Username already exists, choose another one", Toast.LENGTH_SHORT).show();
        }
        else {
            boolean b = dbHelper.addUser(fullname, username, email, phone, password);
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Register.this,Login.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean validateFullname() {
        String fullnameInput = regFullName.getEditText().getText().toString().trim();
        if(fullnameInput.isEmpty()) {
            regFullName.setError("Field can't be empty");
            return false;
        }
        else {
            regFullName.setError(null);
            regFullName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUsername() {
        String usernameInput = regUserName.getEditText().getText().toString().trim();
        if(usernameInput.isEmpty()) {
            regUserName.setError("Field can't be empty");
            return false;
        }
        else if(usernameInput.length() > 15) {
            regUserName.setError("Username too long");
            return false;
        }
        else {
            regUserName.setError(null);
            regUserName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String emailInput = regEmail.getEditText().getText().toString().trim();
        if(emailInput.isEmpty()) {
            regEmail.setError("Field can't be empty");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            regEmail.setError("Enter a valid email address");
            return false;
        }
        else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhone() {
        String phoneInput = regPhone.getEditText().getText().toString().trim();
        if(phoneInput.isEmpty()) {
            regPhone.setError("Field can't be empty");
            return false;
        }
        else if(phoneInput.length() != 10) {
            regPhone.setError("Must contain 10 digits");
            return false;
        }
        else {
            regPhone.setError(null);
            regPhone.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = regPassword.getEditText().getText().toString().trim();
        if(passwordInput.isEmpty()) {
            regPassword.setError("Field can't be empty");
            return false;
        }
        else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            regPassword.setError("Password too weak");
            return false;
        }
        else {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }
}