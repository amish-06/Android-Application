package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;

public class Login extends AppCompatActivity {
    private TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameL);
        password = findViewById(R.id.passwordL);

        Button newUserBtn = findViewById(R.id.newUserButton);
        newUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { goToRegister(v);}
        });

        Button loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { loginUser(v);}
        });

        Button forgotPassBtn = findViewById(R.id.forgotPassButton);
        forgotPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword(v);
            }
        });
    }

    public void goToRegister(View view) {
        Intent intent = new Intent(Login.this,Register.class);
        startActivity(intent);
    }

    public void loginUser(View view) {
        DBHelper dbHelper = new DBHelper(this);
        String user, pass;
        user = Objects.requireNonNull(username.getEditText().getText()).toString().trim();
        pass = Objects.requireNonNull(password.getEditText().getText()).toString().trim();
        boolean validUser = dbHelper.checkUser(user);
        if(validUser) {
            boolean validAccount = dbHelper.checkUserPassword(user,pass);
            if(validAccount) {
                Intent intent = new Intent(Login.this,Welcome.class);
                intent.putExtra("username",user);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(this, "Username and Password mismatch", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "User does not exists", Toast.LENGTH_SHORT).show();
        }
    }

    public void forgotPassword(View view) {
        Intent intent = new Intent(Login.this,ForgotPassVerification.class);
        startActivity(intent);
    }
}