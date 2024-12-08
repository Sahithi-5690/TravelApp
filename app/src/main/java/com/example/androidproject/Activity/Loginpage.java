package com.example.androidproject.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidproject.databinding.ActivityLoginpageBinding;

public class Loginpage extends BaseActivity {
    ActivityLoginpageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginpageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.loginBtn.setOnClickListener(v -> startActivity(new Intent(Loginpage.this, IntroActivity.class)));
    }
}