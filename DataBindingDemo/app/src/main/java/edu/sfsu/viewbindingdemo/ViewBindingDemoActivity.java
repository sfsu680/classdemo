package edu.sfsu.viewbindingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import edu.sfsu.viewbindingdemo.databinding.AnotherLayoutBinding;
import edu.sfsu.viewbindingdemo.databinding.ExampleLayoutBinding;

public class ViewBindingDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnotherLayoutBinding binding = AnotherLayoutBinding.inflate(getLayoutInflater());
        ExampleLayoutBinding exBinding = ExampleLayoutBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.notice.setText("Set from activity");
        binding.anotherNotice.setText("also set from activity");

        exBinding.exampleNotice

        //binding.anotherNotice.setText("also set in Activity");

    }
}