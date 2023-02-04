package com.devedroy.mydoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDemo extends AppCompatActivity {

    RecyclerView recyclerDemo;
    RecyclerDemoAdapter mRecyclerDemoAdapter;

    List<DemoData> myListData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);

        recyclerDemo = findViewById(R.id.recyclerDemo);

        myListData = getData();

        mRecyclerDemoAdapter = new RecyclerDemoAdapter(this, myListData);
        recyclerDemo.setAdapter(mRecyclerDemoAdapter);
        recyclerDemo.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<DemoData> getData() {
        return null;
    }

}