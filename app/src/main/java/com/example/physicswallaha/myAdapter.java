package com.example.physicswallaha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class myAdapter extends RecyclerView.Adapter<myAdapter.holder> {
    Datum[] data;
    Context context;

    public myAdapter(Datum[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.singlerow,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        Datum datum=data[position];
        holder.name.setText(datum.getName());
        holder.subject.setText(datum.getSubjects().get(0));
        holder.iitName.setText(datum.getQualification().get(0));
        Glide.with(holder.img.getContext()).load(datum.getProfileImage()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class holder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name,subject,iitName;
        public holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
            subject=itemView.findViewById(R.id.subject);
            iitName=itemView.findViewById(R.id.iitname);
        }
    }
}
