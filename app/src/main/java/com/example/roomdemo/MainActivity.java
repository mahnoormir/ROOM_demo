package com.example.roomdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdemo.EntityClass.UserModel;

public class MainActivity extends AppCompatActivity {

    EditText name, age, gender;
    Button submit, getdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        submit = findViewById(R.id.submit);
        getdata = findViewById(R.id.getdata);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData();
            }
        });

        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GetData.class));
            }
        });

    }

    private void saveData()
    {
        String name_txt= name.getText().toString().trim();
        String age_txt= age.getText().toString().trim();
        String gender_txt= gender.getText().toString().trim();

            UserModel model = new UserModel();
            model.setName(name_txt);
            model.setAge(age_txt);
            model.setGender(gender_txt);
            DatabaseClass.getDatabase(getApplicationContext()).getDao().insertAllData(model);

            name.setText("");
            age.setText("");
            gender.setText("");
            Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();


    }
}