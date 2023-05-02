package com.example.lutemon.storage;

import android.content.Context;

import java.util.Collection;

public class HomeStorage extends Storage{
    private static HomeStorage instance = null;

    private HomeStorage() {
        super();
    }

    public static HomeStorage getInstance() {
        if (instance == null) {
            instance = new HomeStorage();
        }
        return instance;
    }
    @Override
    public void addLutemon(Lutemon lutemon) {
        lutemon.restoreHp();
        super.addLutemon(lutemon);
    }

    public void createLutemon(String name, LutemonType type) {
        Lutemon lutemon;
        switch (type) {
            case WHITE:
                lutemon = new WhiteLutemon(name);
                break;

            case BLACK:
                lutemon = new BlackLutemon(name);
                break;

            case GREEN:
                lutemon = new GreenLutemon(name);
                break;

            case PINK:
                lutemon = new PinkLutemon(name);
                break;

            case ORANGE:
                lutemon = new OrangeLutemon(name);
                break;

            default:
                throw new UnsupportedOperationException();

        }
        addLutemon(lutemon);

    }

    public void save(Context context) {
        save("home_storage.data", context);
    }

    public void load(Context context) {
        load("home_storage.data", context);
    }
}
