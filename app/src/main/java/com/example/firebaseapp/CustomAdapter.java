package com.example.firebaseapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private ArrayList<Person> list;
    public CustomAdapter(ArrayList<Person>list){
        this.list=list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView Name;
        private TextView Age;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.nameview);
            Age=itemView.findViewById(R.id.ageview);
        }
    }
    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Person p=list.get(position);
        holder.Name.setText(p.getName().toString());
        holder.Age.setText(p.getAge().toString());
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }
}
