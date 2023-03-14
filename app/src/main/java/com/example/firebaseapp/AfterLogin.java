package com.example.firebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AfterLogin extends AppCompatActivity {
    private EditText nameEdit;
    private EditText ageEdit;
    private Button addDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_login);
        nameEdit=findViewById(R.id.nameeditText);
        ageEdit=findViewById(R.id.ageeditText);
        addDetails=findViewById(R.id.detailsbutton);
        addDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String ,Object>hashMap=new HashMap<>();
                hashMap.put("name",nameEdit.getText().toString());
                hashMap.put("age",ageEdit.getText().toString());
                //Manually specifying the url because as google-services-json was downloaded before setting up realtime databases
                //so it will assume original location for database which is USA best i have set it up in europe
                //so has to provide url manually
                String uid=FirebaseAuth.getInstance().getUid();
                //Toast.makeText(AfterLogin.this,uid,Toast.LENGTH_SHORT).show();
                FirebaseDatabase.getInstance("https://fir-app-63625-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("Person").child(uid).setValue(hashMap);
                startActivity(new Intent(AfterLogin.this,ShowItem.class));
            }
        });
    }

}
