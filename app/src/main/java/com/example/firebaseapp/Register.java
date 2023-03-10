package com.example.firebaseapp;

import android.os.Bundle;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private EditText registeremail;
    private EditText registerpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        registeremail=findViewById(R.id.registeremail);
        registerpassword=findViewById(R.id.registerpassword);

    }
}
