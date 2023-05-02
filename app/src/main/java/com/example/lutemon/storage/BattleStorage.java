package com.example.lutemon.storage;

import android.content.Context;

public class BattleStorage extends Storage{
    private static BattleStorage instance = null;

    private BattleStorage() {
        super();
    }

    public static BattleStorage getInstance() {
        if (instance == null) {
            instance = new BattleStorage();
        }
        return instance;
    }

    public void save(Context context) {
        save("battle_storage.data", context);
    }

    public void load(Context context) {
        load("battle_storage.data", context);
    }

}
