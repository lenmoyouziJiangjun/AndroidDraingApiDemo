package com.lll.source.paint.demo.matrix;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lll.source.paint.demo.databinding.ActivityCustom3dBinding;

public class Custom3DViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCustom3dBinding binding = ActivityCustom3dBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
