package com.codewithdevesh.osproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.ActivityEnterDetailsBinding;
import com.google.android.material.snackbar.Snackbar;

public class EnterDetailsActivity extends AppCompatActivity {
    private ActivityEnterDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_enter_details);

        binding.btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String frame = binding.inputFrames.getEditText().getText().toString();
                String pageInputs = binding.etPageInput.getEditText().getText().toString();


                if(frame.isEmpty() || pageInputs.isEmpty()){
                    Snackbar snackbar = Snackbar.make(binding.layout,"Please Enter the Details",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }else {
                    binding.ll.setVisibility(View.VISIBLE);

                }
            }
        });
        binding.tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
               finish();
            }
        });
    }
}