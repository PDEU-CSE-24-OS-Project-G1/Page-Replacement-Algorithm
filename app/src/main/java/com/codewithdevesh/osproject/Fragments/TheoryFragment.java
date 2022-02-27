package com.codewithdevesh.osproject.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codewithdevesh.osproject.Activity.Adapter.TheoryAdapter;
import com.codewithdevesh.osproject.Activity.PDFActivity;
import com.codewithdevesh.osproject.Models.TheoryModel;
import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.FragmentTheoryBinding;

import java.util.ArrayList;
import java.util.List;


public class TheoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<TheoryModel> list;
    private TheoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         FragmentTheoryBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_theory, container, false);
//        setData();
//        recyclerView = v.findViewById(R.id.rv);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        adapter = new TheoryAdapter(list, getContext());
//        recyclerView.setAdapter(adapter);
        binding.cvFifo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PDFActivity.class)
                .putExtra("Algorithm","Fifo.pdf")
                .putExtra("Title","Fifo Algorithm"));
            }
        });

        binding.cvLru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PDFActivity.class)
                        .putExtra("Algorithm","LRU.pdf")
                        .putExtra("Title","LRU Algorithm"));
            }
        });

        binding.cvOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PDFActivity.class)
                .putExtra("Algorithm","Optimal.pdf")
                        .putExtra("Title","Optimal Algorithm"));
            }
        });
        return binding.getRoot();
    }

    private void setData() {
        list = new ArrayList<>();
        list.add(new TheoryModel("GeeksForGeeks", "https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/", "Page Replacement Algorithms in Operating Systems", "https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"));
        list.add(new TheoryModel("GeeksForGeeks", "https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/", "Page Replacement Algorithms in Opera" +
                "ting Systems", "https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"));
        list.add(new TheoryModel("GeeksForGeeks", "https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/", "Page Replacement Algorithms in Operating Systems", "https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"));
        list.add(new TheoryModel("GeeksForGeeks", "https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/", "Page Replacement Algorithms in Operating Systems", "https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"));
        list.add(new TheoryModel("GeeksForGeeks", "https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/", "Page Replacement Algorithms in Operating Systems", "https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"));
        list.add(new TheoryModel("GeeksForGeeks", "https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/", "Page Replacement Algorithms in Operating Systems", "https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"));
        list.add(new TheoryModel("GeeksForGeeks", "https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/", "Page Replacement Algorithms in Operating Systems", "https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"));
        list.add(new TheoryModel("GeeksForGeeks", "https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/", "Page Replacement Algorithms in Operating Systems", "https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"));
        list.add(new TheoryModel("GeeksForGeeks", "https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/", "Page Replacement Algorithms in Operating Systems", "https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"));
        list.add(new TheoryModel("GeeksForGeeks", "https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/", "Page Replacement Algorithms in Operating Systems", "https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"));
    }
}