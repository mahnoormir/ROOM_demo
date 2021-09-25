package com.example.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.RecoverySystem;

import com.example.roomdemo.Adapter.UserAdapter;
import com.example.roomdemo.EntityClass.UserModel;

import java.util.ArrayList;
import java.util.List;

public class GetData extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<UserModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
        recyclerView= findViewById(R.id.recyclerview);
        getData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();

    }

    private void getData() {
        list = new ArrayList<>();
        list = DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData();
        recyclerView.setAdapter(new UserAdapter(getApplicationContext(), list, new UserAdapter.DeleteItemClicklistner() {
            @Override
            public void onItemDelete(int position, int id) {
                DatabaseClass.getDatabase(getApplicationContext()).getDao().deleteData(id);
                getData();
            }
        }));
    }


}