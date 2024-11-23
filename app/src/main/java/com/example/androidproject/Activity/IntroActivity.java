package com.example.androidproject.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidproject.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize view binding for the activity
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        // Set the content view using the root of the binding
        setContentView(binding.getRoot());
        // imagebutton to open the main activity
        binding.introBtn.setOnClickListener(v -> startActivity(new Intent(IntroActivity.this, MainActivity.class)));
    }
}
