package com.example.goodjob.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goodjob.R;
import com.example.goodjob.classes.Activity;
import com.example.goodjob.viewholder.ActivityViewHolder;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityViewHolder> {

    // TODO: reemplazar eventualmente por data de la base de datos.
    //added the onActivityListener in the constructor for the clicks
    private List<Activity> activities;
    private Context context;
    private OnActivityListener onActivityListener;

    public ActivityAdapter(List<Activity> activities, Context context, OnActivityListener onActivityListener)
    {
        this.activities = activities;
        this.context = context;
        this.onActivityListener = onActivityListener;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_item,
                viewGroup, false);

        return new ActivityViewHolder(view, onActivityListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder avh, int index)
    {
        avh.title.setText(activities.get(index).getTitle());
        avh.authorName.setText(activities.get(index).getAuthor());
        avh.description.setText(activities.get(index).getDescription());
        avh.participantsCounter.setText(activities.get(index).getCurrentParticipants()
                + " / " + activities.get(index).getRequiredParticipants());
        avh.photo.setImageResource(activities.get(index).getPhoto());
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    // creando interface para hacer click en las activities
    public interface OnActivityListener
    {
        void onActivityClick(int position);
    }
}
