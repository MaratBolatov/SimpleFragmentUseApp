package com.marat.bolatov.simplefragmentuseapp.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.marat.bolatov.simplefragmentuseapp.R;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StopWatchFragment extends Fragment implements View.OnClickListener {

    private static final String SECONDS_KEY = "seconds";
    private static final String WAS_RUNNING_KEY = "wasRunning";
    private static final String RUNNING_KEY = "running";
    private int seconds = 0;
    private boolean isRunning;
    private boolean isWasRunning;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt(SECONDS_KEY);
            isRunning = savedInstanceState.getBoolean(RUNNING_KEY);
            isWasRunning = savedInstanceState.getBoolean(WAS_RUNNING_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(view);
        actionButtons(view);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        isWasRunning = isRunning;
        isRunning = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isWasRunning) {
            isRunning = true;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SECONDS_KEY, seconds);
        outState.putBoolean(WAS_RUNNING_KEY, isWasRunning);
        outState.putBoolean(RUNNING_KEY, isRunning);
    }

    private void onClickStart() {
        isRunning = true;
    }

    private void onClickStop() {
        isRunning = false;
    }

    private void onClickReset() {
        isRunning = false;
        seconds = 0;
    }

    private void runTimer(View view) {
        final TextView timeView = view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minute = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minute, secs);
                timeView.setText(time);
                if (isRunning) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    private void actionButtons(View view){
        Button startButton = view.findViewById(R.id.stopwatch_start_button);
        startButton.setOnClickListener(this);
        Button stopButton = view.findViewById(R.id.stopwatch_stop_button);
        stopButton.setOnClickListener(this);
        Button resetButton = view.findViewById(R.id.stopwatch_reset_button);
        resetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.stopwatch_start_button:
                onClickStart();
                break;
            case R.id.stopwatch_stop_button:
                onClickStop();
                break;
            case R.id.stopwatch_reset_button:
                onClickReset();
                break;
        }
    }
}