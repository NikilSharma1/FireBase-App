package com.example.firebaseapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private EditText registeremail;
    private EditText registerpassword;
    private Button register;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        registeremail=findViewById(R.id.registeremail);
        registerpassword=findViewById(R.id.registerpassword);
        mAuth=FirebaseAuth.getInstance();
        register=findViewById(R.id.registerbutton2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailString=registeremail.getText().toString();
                String passwordString=registerpassword.getText().toString();
                if(TextUtils.isEmpty(emailString) || TextUtils.isEmpty(passwordString)){
                    Toast.makeText(Register.this,"Enter Both Email and Password",Toast.LENGTH_SHORT).show();
                }else{
                    registerUser(emailString,passwordString);
                }
            }
        });
    }
    private void registerUser(String email,String password){
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Register.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
