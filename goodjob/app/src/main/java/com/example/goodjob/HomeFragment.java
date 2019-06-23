package com.example.goodjob;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goodjob.adapter.ActivityAdapter;
import com.example.goodjob.classes.Activity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ActivityAdapter.OnActivityListener {

    private RecyclerView activitiesRecycler;
    private List<Activity> activities;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        activitiesRecycler = view.findViewById(R.id.rvActivityList);

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        activitiesRecycler.setLayoutManager(lm);
        activitiesRecycler.setHasFixedSize(true);

        loadData();
        loadAdapter();

        return view;
    }

    private void loadData()
    {
        activities = new ArrayList<>();
        activities.add(new Activity(1, "Playa Ventanilla", "Un grupo de personas para " +
                "limpiar la basura de esta playita, etc", "El_Chingon_3000", "15/06/2019",
                "18/06/2019", 2,5, R.drawable.placeholder, 1));
        activities.add(new Activity(2, "Playa Chosica", "Un grupo de personas para " +
                "limpiar la basura de esta playita, etc", "ElBuenSamaritano","14/06/2019",
                "17/06/2019", 7,5, R.drawable.placeholder, 1));
        activities.add(new Activity(3, "Iniciativa Vengadores", "There was an idea. To " +
                "bring together a group of remarkable developers xd", "Nicolas Furia", "15/06/2019",
                "18/06/2019",4,4, R.drawable.placeholder, 1));
        activities.add(new Activity(4, "Parque Torotrito", "Parque mal cuidado por la " +
                "municipalidad, está en zona segura cerca del TacoBell", "xXSirvienteXx", "16/06/2019",
                "19/06/2019",1,3, R.drawable.placeholder, 1));
    }

    private void loadAdapter()
    {
        ActivityAdapter adapter = new ActivityAdapter(activities, getContext(), this);
        activitiesRecycler.setAdapter(adapter);
    }

    @Override
    public void onActivityClick(int position)
    {
        Activity selectedActivity = activities.get(position);
        Intent details = new Intent(getContext(), DetailsAndApplyActivity.class);
        details.putExtra("selectedActivity", selectedActivity);
        startActivity(details);
    }
}
