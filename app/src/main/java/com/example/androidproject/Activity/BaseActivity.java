package com.example.androidproject.Activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

// BaseActivity provides common functionality for all activities in the app.
// It sets up a fullscreen layout by overriding AppCompatActivity.
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); // Initialize the activity with the provided state.

        // Configure the window to use fullscreen mode.
        Window window = getWindow();

        // Enable layout to extend into system UI areas (status bar and navigation bar).
        // This creates an immersive, edge-to-edge screen experience.
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}
