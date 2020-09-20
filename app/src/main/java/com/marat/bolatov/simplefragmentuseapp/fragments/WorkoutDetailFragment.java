package com.marat.bolatov.simplefragmentuseapp.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marat.bolatov.simplefragmentuseapp.R;
import com.marat.bolatov.simplefragmentuseapp.Workout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WorkoutDetailFragment extends Fragment {

    private long workoutId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        init();
    }

    private void init(){
        View view = getView();
        if (view != null) {
            TextView workoutTitle = view.findViewById(R.id.fragment_text_title);
            Workout  workout = Workout.workouts[(int) workoutId];
            workoutTitle.setText(workout.getTitle());
            TextView workoutDescription = view.findViewById(R.id.fragment_text_description);
            workoutDescription.setText(workout.getDescription());
        }
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
}