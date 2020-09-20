package com.marat.bolatov.simplefragmentuseapp;

import android.os.Bundle;

import com.marat.bolatov.simplefragmentuseapp.fragments.WorkoutDetailFragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getWorkoutDetailFragment();
    }

    private void getWorkoutDetailFragment() {
        WorkoutDetailFragment workoutDetailFragment = (WorkoutDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        workoutDetailFragment.setWorkoutId(0);
    }
}
