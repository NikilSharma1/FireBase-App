package com.example.firebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText loginemail;
    private EditText loginpassword;
    private Button login;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginemail=findViewById(R.id.loginemail);
        loginpassword=findViewById(R.id.loginpassword);
        login=findViewById(R.id.loginbutton2);
        auth=FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailString=loginemail.getText().toString();
                String passwordString=loginpassword.getText().toString();
                if(TextUtils.isEmpty(emailString) || TextUtils.isEmpty(passwordString)){
                    Toast.makeText(Login.this,"Enter Both Email and Password",Toast.LENGTH_SHORT).show();
                }else{
                    loginUser(emailString,passwordString);
                }
            }
        });
    }
    private void loginUser(String email,String password){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,AfterLogin.class));
                }else{
                    Toast.makeText(Login.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
