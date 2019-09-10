package com.example.loader;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.loader.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
            implements View.OnClickListener{

    ActivityMainBinding binding;
    View loader;
    ViewGroup root;
    boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        loader = LayoutInflater.from(this).inflate(R.layout.loader, null);
        root = findViewById(android.R.id.content);
        setListener();
    }

    private void setListener(){
        binding.btnLoading.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(binding.btnLoading)){
            if(status)
                dismissLoading();
            else
                showLoading();
            status = !status;
        }
    }

    private void showLoading(){
        root.addView(loader);
        binding.btnLoading.setText("Dismiss Loading");
    }

    private void dismissLoading(){
        root.removeView(loader);
        binding.btnLoading.setText("Show Loading");
    }
}
