package com.codewithdevesh.osproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.codewithdevesh.osproject.Algorithms.Fifo;
import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.ActivityEnterDetailsBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class EnterDetailsActivity extends AppCompatActivity {
    private ActivityEnterDetailsBinding binding;
    private List<String>list;
    private String type;
    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_enter_details);
        Intent i = getIntent();
        type = i.getStringExtra("type");
        title = i.getStringExtra("title");
        binding.title.setText(title);
        list = new ArrayList<>();
        binding.btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String frame = binding.inputFrames.getEditText().getText().toString();
                String pageInputs = binding.etPageInput.getEditText().getText().toString();
                String x;
                int faults;

                if(checkFrame(frame) || checkPage(pageInputs)){
                    Snackbar snackbar = Snackbar.make(binding.layout,"Please Enter the Details",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                    binding.ll.setVisibility(View.GONE);
                    return;
                }else {
                    x = pageInputs.replaceAll("[^a-zA-Z0-9]","");
                    binding.ll.setVisibility(View.VISIBLE);
                    binding.temp.setText(pageInputs);
                    closeKeyBoard();

                    if(type.equals("optimal")){
                        int frames, pointer = 0, hit = 0, fault = 0,ref_len;
                        boolean isFull = false;   // checking if memory is full or not;
                        int[] temp;   // storing temporary values of displaying
                        int[] reference;    // input numbers from user
                        int[][] page_layout; // showing layout of page

                        // input values
                        frames = Integer.parseInt((frame));
                        ref_len = x.length();

                        reference = new int[ref_len];
                        page_layout = new int[ref_len][frames];
                        temp = new int[frames];
                        for(int j = 0; j < frames; j++) {
                            temp[j] = -1;
                        }

                        // storing input of user in array
                        for(int i = 0; i < ref_len; i++) {
                            reference[i] = Integer.parseInt(String.valueOf(x.charAt(i)));
                        }

                        for(int i = 0; i < ref_len; i++)
                        {
                            int search = -1;
                            for(int j = 0; j < frames; j++)
                            {
                                if(temp[j] == reference[i])
                                {
                                    search = j;
                                    hit++;
                                    break;
                                }
                            }
                            if(search == -1)
                            {
                                if(isFull)
                                {
                                    int[] index = new int[frames];
                                    boolean[] index_flag = new boolean[frames];
                                    for(int j = i + 1; j < ref_len; j++)
                                    {
                                        for(int k = 0; k < frames; k++)
                                        {
                                            if((reference[j] == temp[k]) && (!index_flag[k]))
                                            {
                                                index[k] = j;
                                                index_flag[k] = true;
                                                break;
                                            }
                                        }
                                    }
                                    int max = index[0];
                                    pointer = 0;
                                    if(max == 0)
                                        max = 200;
                                    for(int j = 0; j < frames; j++)
                                    {
                                        if(index[j] == 0)
                                            index[j] = 200;
                                        if(index[j] > max)
                                        {
                                            max = index[j];
                                            pointer = j;
                                        }
                                    }
                                }
                                temp[pointer] = reference[i];
                                fault++;
                                if(!isFull)
                                {
                                    pointer++;
                                    if(pointer == frames)
                                    {
                                        pointer = 0;
                                        isFull = true;
                                    }
                                }
                            }
                            for(int j = 0; j < frames; j++)
                                page_layout[i][j] = temp[j];
                        }

//                for(int i = 0; i < frames; i++)
//                {
//                    for(int j = 0; j < ref_len; j++)
//                        System.out.printf("%3d ",mem_layout[j][i]);
//                    System.out.println();
//                }
                        binding.tvHits.setText(String.valueOf(hit));
                        binding.tvFaults.setText(String.valueOf(fault));
                        binding.tvHitRatio.setText(String.valueOf((float)hit/ref_len));
                        binding.tvFaultRatio.setText(String.valueOf(1-(float)hit/ref_len));
                    }

                    else if(type.equals("fifo")){
                        int[]pages = new int[x.length()];
                        for(int i=0;i<x.length();i++){
                            pages[i] = Integer.parseInt(String.valueOf(x.charAt(i)));
                        }
                        Fifo fifo = new Fifo();
                        faults = fifo.performFifo(pages,Integer.parseInt(frame));
                        binding.tvFaults.setText(String.valueOf(faults));
                        binding.tvHits.setText(String.valueOf(x.length()-faults));
                        binding.tvHitRatio.setText(String.valueOf((float) faults/x.length()));
                        binding.tvFaultRatio.setText(String.valueOf(1-(float) faults/x.length()));
                    }

                }
            }
        });
        binding.btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etPageInput.getEditText().setText("");
                binding.inputFrames.getEditText().setText("");
                binding.ll.setVisibility(View.GONE);
            }
        });
        binding.btRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                Random random = new Random();
                String value = String.valueOf(3+random.nextInt(8-3+1));
                binding.inputFrames.getEditText().setText(value);
                binding.ll.setVisibility(View.GONE);

                for(int i=0;i<10;i++){
                    Random random1 = new Random();
                    String val = String.valueOf(random.nextInt(1+9)+1);
                    list.add(val);
                }
                int l = Arrays.toString(list.toArray()).length();

                binding.etPageInput.getEditText().setText(Arrays.toString(list.toArray()).substring(1,l-1));
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

    private void closeKeyBoard() {
        View v = this.getCurrentFocus();
        if(v!=null){
            InputMethodManager manager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(v.getWindowToken(),0);
        }
    }

    private boolean checkFrame(String s){
        if(s.isEmpty()){
            binding.inputFrames.setError("Enter Details");
            binding.inputFrames.setErrorEnabled(true);
            return true;

        }else if(Integer.parseInt(s)<=0){
            binding.inputFrames.setError("Enter Valid Details");
            binding.inputFrames.setErrorEnabled(true);
            return true;
            }
        else{
            binding.inputFrames.setError(null);
            binding.inputFrames.setErrorEnabled(false);
            return false;
        }
    }

    private boolean checkPage(String s){
        if(s.isEmpty()){
            binding.etPageInput.setError("Enter Details");
            binding.etPageInput.setErrorEnabled(true);
            return true;

        }else{
            binding.etPageInput.setError(null);
            binding.etPageInput.setErrorEnabled(false);
            return false;
        }
    }
}