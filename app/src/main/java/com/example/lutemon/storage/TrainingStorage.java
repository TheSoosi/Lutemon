package com.example.lutemon.storage;

import android.content.Context;

public class TrainingStorage extends Storage{
    private static TrainingStorage instance = null;

    private TrainingStorage() {
        super();
    }

    public static TrainingStorage getInstance() {
        if (instance == null) {
            instance = new TrainingStorage();
        }
        return instance;
    }

    public void addExp() {
        for (Lutemon lutemon : getLutemons()) {
            lutemon.addExp();
        }

    }

    public void save(Context context) {
        save("training_storage.data", context);
    }

    public void load(Context context) {
        load("training_storage.data", context);
    }
}
