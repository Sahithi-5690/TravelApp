package com.example.androidproject.Activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

// BaseActivity class that serves as a parent class for other activities
// Configures a fullscreen layout by extending AppCompatActivity
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Lifecycle method called when the activity is created
        super.onCreate(savedInstanceState); // Call the superclass's onCreate method to set up the activity

        // Get the Window object associated with this activity
        Window w = getWindow();

        // Set the window to fullscreen mode by disabling layout limits
        // FLAG_LAYOUT_NO_LIMITS allows the activity layout to extend into system UI areas (like status bar and navigation bar)
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}

