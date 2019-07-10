package com.example.goodjob.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goodjob.R;
import com.example.goodjob.adapter.ActivityAdapter;

public class ActivityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView title;
    public TextView authorName;
    public TextView description;
    public TextView participantsCounter;
    public ImageView photo;
    public TextView moreInfo;

    //added for click on items
    public ActivityAdapter.OnActivityListener onActivityListener;

    public ActivityViewHolder(@NonNull View itemView, ActivityAdapter.OnActivityListener onActivityListener)
    {
        super(itemView);

        title = itemView.findViewById(R.id.tvTitle);
        authorName = itemView.findViewById(R.id.tvAuthorName);
        description = itemView.findViewById(R.id.tvDescription);
        participantsCounter = itemView.findViewById(R.id.tvParticipantsCounter);
        photo = itemView.findViewById(R.id.imgPhoto);
        moreInfo = itemView.findViewById(R.id.btnMoreInfo);

        this.onActivityListener = onActivityListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        onActivityListener.onActivityClick(getAdapterPosition());
    }
}
