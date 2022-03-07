package com.codewithdevesh.osproject.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.ActivityTableBinding;

import java.util.ArrayList;
import java.util.List;

public class TableActivity extends AppCompatActivity {
    private ActivityTableBinding binding;
    private List<Integer>l1;
    private List<Integer>l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_table);
        String []frames = {"F1","F2","F3","F4","F5","F6"};

      l1 = new ArrayList<>();
      l1.add(1);
      l1.add(2);
      l1.add(3);
      l1.add(4);
      l1.add(5);

        l2 = new ArrayList<>();
        l2.add(11);
        l2.add(22);
        l2.add(33);
        l2.add(44);
        l2.add(55);
        
        addHeaders();
        addData();

      

    }

    private void addData() {
        int l = l1.size();
        int j= l2.size();
        for(int i=0;i<l;i++){
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(getLayoutParams());
            tr.addView(getTextView(i+1,l1.get(i).toString()));
            tr.addView(getTextView(i+l,l2.get(i).toString()));
            tr.addView(getTextView(i+101,l2.get(i).toString()));
            binding.tbLayout.addView(tr,getTblLayoutParams());
        }
    }

    private void addHeaders() {
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0,"title1"));
        tr.addView(getTextView(0,"title2"));
        binding.tbLayout.addView(tr,getTblLayoutParams());

    }
    private TextView getTextView(int id,String x){
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(x);
        tv.setTextColor(Color.BLACK);
        tv.setBackgroundResource(R.drawable.gradient);
        tv.setLayoutParams(getLayoutParams());
        tv.setPadding(5,5,5,5);
        return tv;
    }

    private TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(2, 0, 0, 2);
        return params;
    }

    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT);
    }

}