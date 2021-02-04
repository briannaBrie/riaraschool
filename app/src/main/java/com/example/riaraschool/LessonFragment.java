package com.example.riaraschool;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.riaraschool.adapter.GradeListAdapter;
import com.example.riaraschool.adapter.LessonAdapter;
import com.example.riaraschool.model.GradeModel;
import com.example.riaraschool.viewmodel.GradeListViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LessonFragment extends Fragment {

    private GradeListViewModel mViewModel;
    @BindView(R.id.cruid_recyclerview)
    RecyclerView adminRecyclerView;
    private LinearLayoutManager layoutManager;
    private List<GradeModel> gradeList;
    private LessonAdapter la;

    public static LessonFragment newInstance() {
        return new LessonFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_lesson, container, false);
        ButterKnife.bind(this, view);
        initAll();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(GradeListViewModel.class);

        // TODO: Use the ViewModel
        mViewModel = new ViewModelProvider(this).get(GradeListViewModel.class);
        mViewModel.getGradeListObserver().observe(getViewLifecycleOwner(), new Observer<List<GradeModel>>() {
            @Override
            public void onChanged(List<GradeModel> gradeModels) {
                if(gradeModels!=null){
                    gradeList = gradeModels;
                    la.setLessonList(gradeModels);
                }
                else{
                    Toast toast= Toast.makeText(requireContext(), R.string.no_result,Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        mViewModel.makeApiCall();

    }

    private void initAll() {
        layoutManager = new LinearLayoutManager(requireContext());
        la = new LessonAdapter(requireContext(), gradeList);
        adminRecyclerView.setAdapter(la);
        adminRecyclerView.setLayoutManager(layoutManager);
    }


}