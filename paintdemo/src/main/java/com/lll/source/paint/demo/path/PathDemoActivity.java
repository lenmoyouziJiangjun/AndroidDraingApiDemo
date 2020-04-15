package com.lll.source.paint.demo.path;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lll.source.paint.demo.databinding.ActivityPathDemoBinding;

public class PathDemoActivity extends AppCompatActivity {

    private ActivityPathDemoBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPathDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}
