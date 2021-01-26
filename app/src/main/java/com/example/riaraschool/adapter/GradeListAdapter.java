package com.example.riaraschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.riaraschool.R;
import com.example.riaraschool.model.GradeModel;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GradeListAdapter extends RecyclerView.Adapter<GradeListAdapter.GradeViewHolder> {
    private Context context;
    private List<GradeModel> gradeModelList;

    public GradeListAdapter(Context context, List<GradeModel> gradeModelList) {
        this.context = context;
        this.gradeModelList = gradeModelList;
    }

    public void setGradeModelList(List<GradeModel> gradeModelList){
        //explicitly set the data
        this.gradeModelList = gradeModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GradeListAdapter.GradeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_grades_main, parent, false);

        return new GradeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GradeListAdapter.GradeViewHolder holder, int position) {
        holder.gradeName.setText(gradeModelList.get(position).getGrade_name());
        holder.gradeSubject.setText(gradeModelList.get(position).getSubject());
        holder.gradeDesc.setText(gradeModelList.get(position).getLesson_desc());
        holder.gradeLesson.setText(String.valueOf(gradeModelList.get(position).getNo_of_lessons()));

        Glide.with(context)
                .load(gradeModelList.get(position).getAvatar())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(12)).override(70,70))
                .into(holder.gradeAvatar);
    }

    @Override
    public int getItemCount() {
        if(this.gradeModelList !=null){
            return gradeModelList.size();
        }
        return 0;
    }

    public class GradeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.avatar)
        ImageView gradeAvatar;
        @BindView(R.id.txtgrade)
        TextView gradeName;
        @BindView(R.id.txtsubject)
        TextView gradeSubject;
        @BindView(R.id.txtdesc)
        TextView gradeDesc;
        @BindView(R.id.textLess)
        TextView gradeLesson;
        public GradeViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
