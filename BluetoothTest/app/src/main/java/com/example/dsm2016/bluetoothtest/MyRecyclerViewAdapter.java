package com.example.dsm2016.bluetoothtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dsm2016 on 2017-07-22.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<Student> students;
    private int itemLayout;

    public MyRecyclerViewAdapter(List<Student> students, int itemLayout) {
        this.students = students;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.ViewHolder holder, int position) {
        Student student = students.get(position);
        holder.name.setText(student.getName());
        holder.school_number.setText(Integer.toString(student.getSchool_nubmer()));
        holder.age.setText(Integer.toString(student.getAge()));

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name, school_number, age;
        public Button delete_button;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            school_number = (TextView) itemView.findViewById(R.id.school_number);
            age = (TextView) itemView.findViewById(R.id.age);
            delete_button = (Button) itemView.findViewById(R.id.delete_button);

            delete_button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            students.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, students.size());
        }
    }
}

class Student {
    private String name;
    private int school_nubmer;
    private int age;

    public Student() {

    }

    public Student(String name, int school_nubmer, int age) {
        this.name = name;
        this.school_nubmer = school_nubmer;
        this.age = age;
    }

    public int getSchool_nubmer() {
        return school_nubmer;
    }

    public void setSchool_nubmer(int school_nubmer) {
        this.school_nubmer = school_nubmer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
