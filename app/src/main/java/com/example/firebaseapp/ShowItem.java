package com.example.firebaseapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowItem extends AppCompatActivity {
    private Button show;
    private RecyclerView recyclerView;
    private ArrayList<Person> list;
    private CustomAdapter adapter;
    public void show(View v){
        FirebaseUser firebaseUser =FirebaseAuth.getInstance().getCurrentUser();
        String uid=firebaseUser.getUid();
        //Toast.makeText(ShowItem.this,uid,Toast.LENGTH_SHORT).show();
        //URL has to be provided manually as server is not in the USA which is default server location
        FirebaseDatabase.getInstance("https://fir-app-63625-default-rtdb.europe-west1.firebasedatabase.app").getReference()
                .child("Person").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            list.clear();
                            for(DataSnapshot i:snapshot.getChildren()){
                                //Log.i("info ->>>",i.getValue().toString());
                                Person person=i.getValue(Person.class);
                                Log.i("info ->>>",person.getAge()+" "+person.getName());
                                list.add(new Person(person.getAge(), person.getName()));

                            }
                            Log.i("info ->>>",list.size()+"");
                            adapter.notifyDataSetChanged();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        if (list != null) {
            Log.i("size of the array2", "" + list.size());
        } else {
            Log.i("size of the array2", "" + 0);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_items);
        show=findViewById(R.id.showitembutton);
        recyclerView=findViewById(R.id.itemslistview);
        recyclerView.setHasFixedSize(true);
        list=new ArrayList<>();
        adapter=new CustomAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
//                if (list != null) {
//                    Log.i("size of the array2", "" + list.size());
//                } else {
//                    Log.i("size of the array2", "" + 0);
//                }
                //int n=list.size();
                //Log.i("size of the array",""+n);




            }
}

