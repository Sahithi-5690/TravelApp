package com.example.androidproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;

import com.example.androidproject.Adapter.CategoryAdapter;
import com.example.androidproject.Adapter.PopularAdapter;
import com.example.androidproject.Adapter.RecommendedAdapter;
import com.example.androidproject.Adapter.SeeAllAdapter;
import com.example.androidproject.Adapter.SliderAdapter;
import com.example.androidproject.Domain.Category;
import com.example.androidproject.Domain.ItemDomain;
import com.example.androidproject.Domain.SliderItems;
import com.example.androidproject.R;
import com.example.androidproject.databinding.ActivityMainBinding;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Handler sliderHandler = new Handler(Looper.getMainLooper());
    ActivityMainBinding binding;
    private DrawerLayout drawerLayout;

    private ArrayList<ItemDomain> combinedList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        drawerLayout = findViewById(R.id.drawerLayout);
        Button accountButton = findViewById(R.id.buttonAccount);
        accountButton.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        // Initialize the UI components
        initLocalBanner();
        initCategory();
        initRecommended();
        initPopular();
        startAutoSlide();

        // Add "See All" button click listener
        TextView seeAllButton = findViewById(R.id.textView6);
        seeAllButton.setOnClickListener(v -> openSeeAllActivity());
    }

    private void openSeeAllActivity() {
        // Navigate to SeeAllActivity
        Intent intent = new Intent(MainActivity.this, SeeAllActivity.class);

        // Optionally, pass data to SeeAllActivity (e.g., combined list of items)
        intent.putExtra("combinedList", combinedList);

        // Start the activity
        startActivity(intent);
    }

    private void initPopular() {
        ArrayList<ItemDomain> list = new ArrayList<>();
        list.add(new ItemDomain("Kennedy Space Center", 149.99, "Orlando, FL", 4.5f, R.drawable.kennedy, R.string.description_kennedy));
        list.add(new ItemDomain("The French Quarter", 249.99, "New Orleans, LA", 4.0f, R.drawable.frenchquarter, R.string.description_french_quarter));
        list.add(new ItemDomain("Old Faithful", 219.99, "Yellowstone Park, Wyoming", 4.7f, R.drawable.oldfaithful, R.string.description_old_faithful));
        list.add(new ItemDomain("Mammoth Cave Park", 339.99, "Kentucky", 4.2f, R.drawable.mammothcave, R.string.description_mammoth_cave));
        combinedList.addAll(list);
        if (!list.isEmpty()) {
            binding.recyclerViewPopular.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
            RecyclerView.Adapter adapter = new PopularAdapter(list);
            binding.recyclerViewPopular.setAdapter(adapter);
        }
        binding.progressBarPopular.setVisibility(View.GONE);
    }

    private void initRecommended() {
        ArrayList<ItemDomain> list = new ArrayList<>();
        list.add(new ItemDomain("The Gateway Arch", 149.99, "Missouri", 4.5f, R.drawable.gatewayarch, R.string.Gateway_Arch));
        list.add(new ItemDomain("Park City", 249.99, "Utah", 4.0f, R.drawable.parkcity, R.string.Park_City));
        list.add(new ItemDomain("Jackson Hole", 219.99, "Wyoming", 4.7f, R.drawable.jackson, R.string.jackson_Hole));
        list.add(new ItemDomain("Honolulu", 339.99, "Hawaii", 4.2f, R.drawable.honolulu, R.string.Honolulu));
        combinedList.addAll(list);
        if (!list.isEmpty()) {
            binding.recyclerViewRecommended.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
            RecyclerView.Adapter adapter = new RecommendedAdapter(list);
            binding.recyclerViewRecommended.setAdapter(adapter);
        }
        binding.progressBarRecommended.setVisibility(View.GONE);
    }

    private void initLocalBanner() {
        ArrayList<SliderItems> items = new ArrayList<>();
        items.add(new SliderItems(R.drawable.slider1));
        items.add(new SliderItems(R.drawable.slider2));
        items.add(new SliderItems(R.drawable.slider));

        SliderAdapter adapter = new SliderAdapter(items);
        binding.viewPagerSlider.setAdapter(adapter);
        binding.viewPagerSlider.setClipToPadding(false);
        binding.viewPagerSlider.setClipChildren(false);
        binding.viewPagerSlider.setOffscreenPageLimit(3);
        binding.viewPagerSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        binding.viewPagerSlider.setPageTransformer(compositePageTransformer);
    }

    private void startAutoSlide() {
        sliderHandler.postDelayed(sliderRunnable, 4000);
    }

    private void stopAutoSlide() {
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            int currentItem = binding.viewPagerSlider.getCurrentItem();
            int itemCount = binding.viewPagerSlider.getAdapter().getItemCount();

            binding.viewPagerSlider.setCurrentItem((currentItem + 1) % itemCount, true);

            sliderHandler.postDelayed(this, 4000);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        stopAutoSlide();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startAutoSlide();
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
