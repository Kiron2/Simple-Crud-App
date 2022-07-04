package com.example.testingforproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class descfragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String name, course, email, surl, age, gender, year, address;
    Button btnBack;

    public descfragment() {

    }

    public descfragment(String name, String course, String email, String surl, String age, String gender,String year,String address) {
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.year=year;
        this.course=course;
        this.email=email;
        this.surl=surl;
        this.address=address;
    }

    public static descfragment newInstance(String param1, String param2) {
        descfragment fragment = new descfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_descfragment, container, false);

        ImageView imageh=view.findViewById(R.id.imagegholder);
        TextView nameh=view.findViewById(R.id.nameholder);
        TextView courserh=view.findViewById(R.id.courseholder);
        TextView emailh=view.findViewById(R.id.emailholder);
        TextView ageh=view.findViewById(R.id.ageholder);
        TextView genderh=view.findViewById(R.id.genderholder);
        TextView yearh=view.findViewById(R.id.yearholder);
        TextView addressh=view.findViewById(R.id.addressholder);

        nameh.setText(name);
        courserh.setText(course);
        ageh.setText(age);
        genderh.setText(gender);
        yearh.setText(year);
        addressh.setText(address);
        emailh.setText(email);

        Glide.with(getContext()).load(surl).into(imageh);

        btnBack = (Button) view.findViewById(R.id.btnBackback);
        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });

        return  view;


    }

    public void onBackPressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new recfragment()).addToBackStack(null).commit();

    }


}

