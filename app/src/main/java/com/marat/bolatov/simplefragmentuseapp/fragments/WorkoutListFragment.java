package com.marat.bolatov.simplefragmentuseapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.marat.bolatov.simplefragmentuseapp.Workout;


public class WorkoutListFragment extends ListFragment {

    public Listener listener;

    public interface Listener {
        void itemClicked(long id);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] names = getWorkouts();
        initAdapter(inflater, names);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initAdapter(LayoutInflater inflater, String[] names) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    private String[] getWorkouts() {
        String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getTitle();
        }
        return names;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}