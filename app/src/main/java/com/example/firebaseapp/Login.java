package com.example.firebaseapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText loginemail;
    private EditText loginpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginemail=findViewById(R.id.loginemail);
        loginpassword=findViewById(R.id.loginpassword);

    }
}
