package com.example.lutemon.storage;

import java.util.ArrayList;

public class BattleField extends Storage {

    private static BattleField instance = null;

    private BattleField() {

    }
    public static BattleField getInstance() {
        if (instance == null) {
            instance = new BattleField();
        }
        return instance;
    }


    public String fight() {
        BattleStorage battleStorage = BattleStorage.getInstance();
        ArrayList<Lutemon> lutemons = getLutemons();
        Lutemon lutemon1 = lutemons.get(0);
        Lutemon lutemon2 = lutemons.get(1);

        if (Math.round(Math.random()) == 1){
            Lutemon tempLutemon = lutemon1;
            lutemon1 = lutemon2;
            lutemon2 = tempLutemon;
        }

        String stats = "";
        while (true) {
            stats += lutemon1.getStats();
            stats += lutemon2.getStats();
            stats += String.format("%s(%s) attacks %s(%s)\n", lutemon1.getType().toString(), lutemon1.getName(), lutemon2.getType().toString(), lutemon2.getName());
            lutemon2.defence(lutemon1);
            if (lutemon2.getHp() > 0) {
                stats += String.format("%s(%s) managed to escape death.\n", lutemon2.getType().toString(), lutemon2.getName());
                Lutemon tempLutemon = lutemon1;
                lutemon1 = lutemon2;
                lutemon2 = tempLutemon;

            } else {
                stats += String.format("%s(%s) gets killed.\n", lutemon2.getType().toString(), lutemon2.getName());
                stats += String.format("The battle is over.\n");
                lutemon1.addExp();
                battleStorage.addLutemon(lutemon1);
                instance.removeLutemons();
                break;
            }

        }

        return stats;
    }
}
