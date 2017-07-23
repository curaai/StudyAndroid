package com.example.dsm2016.bluetoothtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        initData();
    }

    private void initLayout() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
    }

    private void initData() {
        List<Student> students = new ArrayList<Student>();

        for(int i=0; i<30; i++) {
            Random rn = new Random();

            String name = Character.toString((char)(i + 65));
            int school_number = 10000 + i;
            int age = rn.nextInt() % 10 + 10;

            Student stu = new Student(name, school_number, age);
            students.add(stu);
        }

        recyclerView.setAdapter(new MyRecyclerViewAdapter(students, R.layout.people_list_low));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
