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
import com.example.androidproject.databinding.ActivityTicketBinding;

/**
 * TicketActivity is responsible for displaying ticket details.
 * This activity shows the ticket's image, title, and provides options
 * to contact the tour guide via call or SMS.
 */
public class TicketActivity extends BaseActivity {
    ActivityTicketBinding binding; // Binding object to access views in the layout
    private ItemDomain object; // Holds the ticket data passed from another activity

    /**
     * Called when the activity is created. This method sets up the UI layout
     * and initializes ticket data to populate the views.
     *
     * @param savedInstanceState Bundle containing the activity's previously saved state, if any.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using ViewBinding and set it as the content view
        binding = ActivityTicketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve data passed from the previous activity
        getIntentExtra();

        // Populate views and set up interactions
        setVariable();
    }

    /**
     * Initializes UI components with data from the ticket object.
     * Sets up button listeners and uses Glide to load images.
     */
    private void setVariable() {
        // Load the main ticket image into the ImageView using Glide
        Glide.with(TicketActivity.this)
                .load(object.getPic()) // Source of the image (URL or resource ID)
                .into(binding.pic); // Target ImageView

        /*
         * If additional images such as a tour guide profile picture are required,
         * the following block can be uncommented and modified accordingly.
         */
        // Glide.with(TicketActivity.this)
        //         .load(object.getTourGuidePic())
        //         .into(binding.profile);

        // Set a listener for the back button to close the activity
        binding.backBtn.setOnClickListener(v -> finish());

        // Display the ticket title in the TextView
        binding.titleTxt.setText(object.getTitle());

        /*
         * Uncomment the following code to display more ticket details
         * such as duration, date, time, and tour guide name.
         */
        // binding.durationTxt.setText(object.getDuration());
        // binding.tourGuideTxt.setText(object.getDateTour());
        // binding.timeTxt.setText(object.getTimeTour());
        // binding.tourGuideNameTxt.setText(object.getTourGuideName());

        // Set up the call button to open the SMS app with a pre-filled message
        binding.callBtn.setOnClickListener(v -> {
            Intent sendIntent = new Intent(Intent.ACTION_VIEW); // Create an intent for SMS
            // Uncomment to include the tour guide's phone number
            // sendIntent.setData(Uri.parse("sms:" + object.getTourGuidePhone()));
            sendIntent.putExtra("sms_body", "type your message"); // Pre-fill message content
            startActivity(sendIntent); // Start the SMS app
        });

        // Set up the message button to initiate a call (currently commented out)
        binding.messageBtn.setOnClickListener(v -> {
            // Uncomment to allow the user to make a call to the tour guide
            // String phone = object.getTourGuidePhone();
            // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
            // startActivity(intent);
        });
    }

    /**
     * Retrieves the ticket object passed as a serialized extra from the intent.
     * This object contains all the details needed to populate the activity views.
     */
    private void getIntentExtra() {
        object = (ItemDomain) getIntent().getSerializableExtra("object"); // Extract serialized object
    }
}
