package com.example.goodjob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goodjob.classes.Activity;


public class DetailsAndApplyActivity extends AppCompatActivity {

    private TextView title;
    private TextView description;
    private TextView author;
    private TextView creationDate;
    private TextView endDate;
    private TextView currentParticipants;
    private TextView requiredParticipants;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_and_apply);

        title = findViewById(R.id.tvTitle);
        description = findViewById(R.id.tvDescription);
        author = findViewById(R.id.tvAuthorName);
        creationDate = findViewById(R.id.tvCreationDateValue);
        endDate = findViewById(R.id.tvendDateValue);
        currentParticipants = findViewById(R.id.tvCurrent);
        requiredParticipants = findViewById(R.id.tvRequired);
        photo = findViewById(R.id.imgPhoto);

        Activity selected = getIntent().getExtras().getParcelable("selectedActivity");
        loadData(selected);
    }

    private void loadData(Activity activity)
    {
        title.setText(activity.getTitle());
        description.setText(activity.getDescription());
        author.setText(activity.getAuthor());
        creationDate.setText(activity.getCreationDate());
        endDate.setText(activity.getEndDate());
        currentParticipants.setText("De momento hay " + activity.getCurrentParticipants() + " postulantes");
        requiredParticipants.setText("Se necesitan " + activity.getRequiredParticipants() + " personas");
        photo.setImageResource(activity.getPhoto());
    }
}
