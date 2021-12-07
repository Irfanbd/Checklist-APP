package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.justdoit.Adapter.ToDoAdapter;
import com.example.justdoit.Model.ToDoModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView taskRecyclerView;
private ToDoAdapter taskAdapter;
private List<ToDoModel> taskList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        taskList=new ArrayList<>();

        taskRecyclerView=findViewById(R.id.tasksRecyclerView);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter=new ToDoAdapter(this);
        taskRecyclerView.setAdapter(taskAdapter);


        ToDoModel task=new ToDoModel();
        task.setTask("This is a test Task");
        task.setStatus(0);
task.setId(1);
taskList.add(task);
        taskList.add(task);
        taskList.add(task);
        taskList.add(task);
        taskList.add(task);
taskAdapter.setTasks(taskList);
    }
}