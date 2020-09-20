package com.marat.bolatov.simplefragmentuseapp;

public class Workout {

    private static final String WORKOUT_TITLE_1 = "The Limb Loosener";
    private static final String WORKOUT_TITLE_2 = "The Wimp Special";
    private static final String WORKOUT_DESCRIPTION_1 = "5 Handstand push-ups\n10 1-Legged squats\n15 Pull-ups";
    private static final String WORKOUT_DESCRIPTION_2 = "5 Pull-ups\n10 Push-ups\n20 Squats";
    private String title;
    private String description;

    public static final Workout[] workouts = {
            new Workout(WORKOUT_TITLE_1, WORKOUT_DESCRIPTION_1),
            new Workout(WORKOUT_TITLE_2, WORKOUT_DESCRIPTION_2)
    };

    public Workout(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
