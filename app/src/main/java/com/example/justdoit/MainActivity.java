package com.example.justdoit;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.justdoit.Adapter.ToDoAdapter;
import com.example.justdoit.Model.ToDoModel;
import com.example.justdoit.Utils.DatabaseHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DialogCloseListener {
private RecyclerView taskRecyclerView;
private ToDoAdapter taskAdapter;
private List<ToDoModel> taskList;
private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        db=new DatabaseHandler(this);
        db.openDatabase();

        taskList=new ArrayList<>();

        taskRecyclerView=findViewById(R.id.tasksRecyclerView);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter=new ToDoAdapter(this);
        taskRecyclerView.setAdapter(taskAdapter);


       taskList=db.getAllTasks();
       Collections.reverse(taskList);
       taskAdapter.setTasks(taskList);
    }
    @Override
    public void handleDialogClose(DialogInterface dialog){
        taskList=db.getAllTasks();
        Collections.reverse(taskList);
        taskAdapter.setTasks(taskList);
        taskAdapter.notifyDataSetChanged();
    }
}