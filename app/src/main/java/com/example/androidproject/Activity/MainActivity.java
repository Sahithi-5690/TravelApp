package com.example.androidproject.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.Adapter.CategoryAdapter;
import com.example.androidproject.Adapter.PopularAdapter;
import com.example.androidproject.Adapter.RecommendedAdapter;
import com.example.androidproject.Domain.Category;
import com.example.androidproject.Domain.ItemDomain;
import com.example.androidproject.R;
import com.example.androidproject.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initBanner();
        initCategory();
        initRecommended();
        initPopular();
    }

    private void initPopular() {
        ArrayList<ItemDomain> list = new ArrayList<>();
        list.add(new ItemDomain("Kennedy Space Center", 149.99, "Orlando, FL", 4.5f, R.drawable.kennedy));
        list.add(new ItemDomain("The French Quarter", 249.99, "New Orleans, LA", 4.0f, R.drawable.frenchquarter));
        list.add(new ItemDomain("Old Faithful", 219.99, "Yellowstone Park, Wyoming", 4.7f, R.drawable.oldfaithful));
        list.add(new ItemDomain("Mammoth Cave Park", 339.99, "Kentucky", 4.2f, R.drawable.mammothcave));
        if (!list.isEmpty()) {
                binding.recyclerViewPopular.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
                RecyclerView.Adapter adapter = new PopularAdapter(list);
                binding.recyclerViewPopular.setAdapter(adapter);
            }
        binding.progressBarPopular.setVisibility(View.GONE);
    }

    private void initRecommended() {
        ArrayList<ItemDomain> list = new ArrayList<>();
        list.add(new ItemDomain("The Gateway Arch", 149.99, "Missouri", 4.5f, R.drawable.gatewayarch));
        list.add(new ItemDomain("Park City", 249.99, "Utah", 4.0f, R.drawable.parkcity));
        list.add(new ItemDomain("Jackson Hole", 219.99, "Wyoming", 4.7f, R.drawable.jackson));
        list.add(new ItemDomain("Honolulu", 339.99, "Hawaii", 4.2f, R.drawable.honolulu));
        if (!list.isEmpty()) {
            binding.recyclerViewRecommended.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
            RecyclerView.Adapter adapter = new RecommendedAdapter(list);
            binding.recyclerViewRecommended.setAdapter(adapter);
        }
        binding.progressBarRecommended.setVisibility(View.GONE);
    }


    private void initBanner() {
//        DatabaseReference myRef = database.getReference("Banner");
//        binding.progressBarBanner.setVisibility(View.VISIBLE);
//        ArrayList<SliderItems> items = new ArrayList<>();
//        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    for (DataSnapshot issue : snapshot.getChildren()) {
//                        items.add(issue.getValue(SliderItems.class));
//                    }
//                    banners(items);
//                    binding.progressBarBanner.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }

    private void initCategory() {
        ArrayList<Category> list = new ArrayList<>();
        list.add(new Category(R.drawable.beach, "Beach"));
        list.add(new Category(R.drawable.mountain, "Mountain"));
        list.add(new Category(R.drawable.desert, "Desert"));
        list.add(new Category(R.drawable.camp, "Camp"));
        list.add(new Category(R.drawable.jungle, "Jungle"));
        binding.recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        RecyclerView.Adapter adapter = new CategoryAdapter(list);
        binding.recyclerViewCategory.setAdapter(adapter);

        binding.progressBarCategory.setVisibility(View.GONE);
    }


}