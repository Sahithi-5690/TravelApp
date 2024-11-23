package com.example.androidproject.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.androidproject.Domain.ItemDomain;
import com.example.androidproject.R;
import com.example.androidproject.databinding.ActivityDetailBinding;

// DetailActivity class that displays detailed information about a selected item
public class DetailActivity extends BaseActivity { // Extends BaseActivity, which might add custom behavior
    ActivityDetailBinding binding; // Binding object to access views defined in activity_detail.xml
    private ItemDomain object; // Represents the data for the selected item, passed via Intent

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Called when the activity is created
        super.onCreate(savedInstanceState); 
        binding = ActivityDetailBinding.inflate(getLayoutInflater()); // Inflate the layout using ViewBinding
        setContentView(binding.getRoot()); // Set the root view of the binding as the activity's content view

        getIntentExtra(); // Retrieve data passed from the previous activity
        setVariable(); // Populate UI components with the retrieved data
    }

    // Sets up the UI components with the details of the selected item
    private void setVariable() {
        // Set the title of the item in the TextView
        binding.titleTxt.setText(object.getTitle());

        // Set the price of the item with a '$' prefix
        binding.priceTxt.setText("$" + object.getPrice());

        // Set up a click listener for the back button to finish the activity
        binding.backBtn.setOnClickListener(v -> finish());

        // Set the address of the item
        binding.addressTxt.setText(object.getAddress());

        // Set the rating and display it in both TextView and RatingBar
        binding.ratingTxt.setText(object.getScore() + " Rating");
        binding.ratingBar.setRating((float) object.getScore());

        // Load the item's image using Glide and set it into the ImageView
        Glide.with(DetailActivity.this)
                .load(object.getPic()) // URL or resource for the image
                .into(binding.pic); // Target ImageView to display the image

        // Set up a click listener for the 'Add to Cart' button
        binding.addToCartBtn.setOnClickListener(v -> {
            // Create an Intent to navigate to the TicketActivity
            Intent intent = new Intent(DetailActivity.this, TicketActivity.class);
            intent.putExtra("object", object); // Pass the selected item as an extra
            startActivity(intent); // Start the TicketActivity
        });
    }

    // Retrieves the item object passed from the previous activity via Intent
    private void getIntentExtra() {
        object = (ItemDomain) getIntent().getSerializableExtra("object"); // Deserialize the object
    }
}
