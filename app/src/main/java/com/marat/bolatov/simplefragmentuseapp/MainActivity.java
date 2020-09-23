package com.marat.bolatov.simplefragmentuseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import com.marat.bolatov.simplefragmentuseapp.fragments.WorkoutDetailFragment;
import com.marat.bolatov.simplefragmentuseapp.fragments.WorkoutListFragment;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null){
            WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            workoutDetailFragment.setWorkoutId(id);
            fragmentTransaction.replace(R.id.fragment_container, workoutDetailFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.addToBackStack("MB");
            fragmentTransaction.commit();
        }
        else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
}