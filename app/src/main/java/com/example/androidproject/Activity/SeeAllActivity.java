package com.example.androidproject.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.Adapter.SeeAllAdapter;
import com.example.androidproject.Domain.ItemDomain;
import com.example.androidproject.R;

import java.util.ArrayList;

public class SeeAllActivity extends AppCompatActivity {

    private ArrayList<ItemDomain> combinedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeall); // Use the layout for SeeAllActivity

        // Retrieve the passed list
        ArrayList<ItemDomain> combinedList = (ArrayList<ItemDomain>) getIntent().getSerializableExtra("combinedList");

        if (combinedList != null) {
            // Set up RecyclerView
            RecyclerView recyclerView = findViewById(R.id.recyclerViewItems);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            SeeAllAdapter adapter = new SeeAllAdapter(combinedList);
            recyclerView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No items to display", Toast.LENGTH_SHORT).show();
        }
    }
}
