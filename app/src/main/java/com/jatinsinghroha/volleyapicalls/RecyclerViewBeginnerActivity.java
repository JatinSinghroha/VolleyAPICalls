package com.jatinsinghroha.volleyapicalls;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewBeginnerActivity extends AppCompatActivity {

    String [] names = {"Jatin", "Vinay", "Mukul", "Bhavya", "Nikshitha", "Harshini"};
    RecyclerView listOfNamesRV;

    RVListOfNamesAdapter mRVListOfNamesAdapter;

    List<String> listOfNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_beginner_actiity);

        listOfNames = new ArrayList<>();

        listOfNamesRV = findViewById(R.id.listOfNamesRV);

        mRVListOfNamesAdapter = new RVListOfNamesAdapter(listOfNames);

        listOfNamesRV.setAdapter(mRVListOfNamesAdapter);

        listOfNamesRV.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        listOfNamesRV.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        populateNames();

    }

    private void populateNames() {
        listOfNames.clear();

        for (int i = 0; i < 50000; i++) {
            String name = names[new Random().nextInt(6)];
            listOfNames.add(name);
        }

        mRVListOfNamesAdapter.notifyDataSetChanged();
    }
}