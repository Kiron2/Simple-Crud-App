package com.example.testingforproject;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText name, course, year, surl, email, age, gender, address ;
    Button btnAdd, btnlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setTitle("AddActivity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (EditText) findViewById(R.id.txtName);
        course = (EditText) findViewById(R.id.txtCourse);
        year = (EditText) findViewById(R.id.txtYear);
        surl = (EditText) findViewById(R.id.txtImageUrl);
        email = (EditText) findViewById(R.id.txtEmail);
        age = (EditText) findViewById(R.id.txtAge);
        gender = (EditText) findViewById(R.id.txtGender);
        address = (EditText) findViewById(R.id.txtAddress);
        btnlist = (Button)findViewById(R.id.btnList);
        btnAdd = (Button)findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //emptyData(); // if the text_field is empty it will return to the -
                //empty text_field
                insertData();
            }
        });
        btnlist.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                clearAll();
            }
        });


    }

    private void insertData()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        String strName = name.getText().toString().trim();

        if(strName.isEmpty()){
            name.setError("This field is empty");
            name.requestFocus();
            return;
        }

        map.put("course", course.getText().toString());

        String strCoure = course.getText().toString().trim();
        if(strCoure.isEmpty()){
            course.setError("This field is empty");
            course.requestFocus();
            return;
        }

        map.put("year", year.getText().toString());

        String strYear = year.getText().toString().trim();
        if(strYear.isEmpty()){
            year.setError("This field is empty");
            year.requestFocus();
            return;
        }

        map.put("surl", surl.getText().toString());

        String strSurl = surl.getText().toString().trim();
        if(strName.isEmpty()){
            surl.setError("This field is empty");
            surl.requestFocus();
            return;
        }

        map.put("email", email.getText().toString());

        String strEmail = email.getText().toString().trim();
        if(strEmail.isEmpty()){
            email.setError("This field is empty");
            email.requestFocus();
            return;
        }

        map.put("age", age.getText().toString());

        String strAge = age.getText().toString().trim();
        if(strName.isEmpty()){
            age.setError("This field is empty");
            age.requestFocus();
            return;
        }

        map.put("gender", gender.getText().toString());

        String strGender = gender.getText().toString().trim();
        if(strGender.isEmpty()){
            gender.setError("This field is empty");
            gender.requestFocus();
            return;
        }

        map.put("address", address.getText().toString());

        String strAddress = address.getText().toString().trim();
        if(strName.isEmpty()){
            address.setError("This field is empty");
            address.requestFocus();
            return;
        }


        FirebaseDatabase.getInstance().getReference().child("students").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(AddActivity.this, "Error while insertion.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void clearAll()
    {
        name.setText("");
        course.setText("");
        year.setText("");
        surl.setText("");
        email.setText("");
        age.setText("");
        gender.setText("");
        address.setText("");
    }
}