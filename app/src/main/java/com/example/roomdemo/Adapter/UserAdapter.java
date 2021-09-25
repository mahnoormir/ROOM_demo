package com.example.roomdemo.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdemo.EntityClass.UserModel;
import com.example.roomdemo.GetData;
import com.example.roomdemo.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context context;
    List<UserModel> list;
    DeleteItemClicklistner deleteItemClicklistner;

    public UserAdapter(Context context, List<UserModel> list, DeleteItemClicklistner deleteItemClicklistner) {
        this.context = context;
        this.list = list;
        this.deleteItemClicklistner = deleteItemClicklistner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {


        holder.name.setText(list.get(position).getName());
        holder.age.setText(list.get(position).getAge());
        holder.gender.setText(list.get(position).getGender());

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GetData.class);
                intent.putExtra("id", String.valueOf(list.get(position).getKey()));
                intent.putExtra("name", String.valueOf(list.get(position).getName()));
                intent.putExtra("age", String.valueOf(list.get(position).getAge()));
                intent.putExtra("gender", String.valueOf(list.get(position).getGender()));
                context.startActivity(intent);

            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItemClicklistner.onItemDelete(position, list.get(position).getKey());

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, age, gender;
        Button update, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            gender = itemView.findViewById(R.id.gender);

            update = itemView.findViewById(R.id.updateId);
            delete = itemView.findViewById(R.id.deleteId);
        }
    }

    public interface DeleteItemClicklistner {
        void onItemDelete(int position, int id);
    }
}
