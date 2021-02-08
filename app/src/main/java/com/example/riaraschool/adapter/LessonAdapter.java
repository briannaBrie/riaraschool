package com.example.riaraschool.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.riaraschool.EngQuizActivity;
import com.example.riaraschool.R;
import com.example.riaraschool.model.GradeModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {
    private Context context;
    private List<GradeModel> lessonModelList;

    public LessonAdapter(Context context, List<GradeModel> gradeModelList) {
        this.context = context;
        this.lessonModelList = gradeModelList;
    }
    public void setLessonList(List<GradeModel> gradeModelList){
        //explicitly set the data
        this.lessonModelList = gradeModelList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public LessonAdapter.LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_subject_grades, parent, false);

        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonAdapter.LessonViewHolder holder, int position) {
        holder.gradeName.setText(lessonModelList.get(position).getGrade_name());
        holder.gradeSubject.setText(lessonModelList.get(position).getSubject());
        holder.gradeDesc.setText(lessonModelList.get(position).getLesson_desc());
        holder.gradeLesson.setText(String.valueOf(lessonModelList.get(position).getNo_of_lessons()));
       /* holder.subjectLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, EngQuizActivity.class);
            context.startActivity(intent);
        });*/
        holder.itemView.setOnClickListener(v ->{
            Log.d("aaa","Grade subject: " + holder.gradeSubject.getText());
                Intent intent = new Intent(context, EngQuizActivity.class);
                context.startActivity(intent);
        });


        Picasso.get()
                .load(lessonModelList.get(position).getAvatar())
                .fit()
                .into(holder.gradeAvatar);
    }

    @Override
    public int getItemCount() {
        if(this.lessonModelList !=null){
            return lessonModelList.size();
        }
        return 0;
    }

    public class LessonViewHolder extends RecyclerView.ViewHolder {
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
        @BindView(R.id.layout_subject)
        ConstraintLayout subjectLayout;
        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);



        }
    }
}
