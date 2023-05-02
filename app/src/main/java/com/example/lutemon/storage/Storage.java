package com.example.lutemon.storage;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Storage {
    private HashMap<Integer, Lutemon> lutemons;
    protected Storage() {
        lutemons = new HashMap<>();
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.put(lutemon.getId(), lutemon);
    }

    public void removeLutemon(Integer id) {
        lutemons.remove(id);
    }

    public void removeLutemons() {
        lutemons.clear();
    }

    public Lutemon getLutemon(Integer id) {
        return lutemons.get(id);
    }

    public ArrayList<Lutemon> getLutemons() {
        return new ArrayList<>(lutemons.values());
    }

    protected void save(String filename, Context context) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(context.openFileOutput(filename, Context.MODE_PRIVATE));
            writer.writeObject(lutemons);
            writer.close();

        } catch (IOException e) {
            Toast.makeText(context, "Cannot save data :(", Toast.LENGTH_SHORT).show();
        }
    }

    protected void load(String filename, Context context) {
        try {
            ObjectInputStream loader = new ObjectInputStream(context.openFileInput(filename));
            lutemons = (HashMap<Integer, Lutemon>) loader.readObject();
            loader.close();

        } catch (IOException e) {
            Toast.makeText(context, "No data to load", Toast.LENGTH_SHORT).show();
        } catch (ClassNotFoundException e) {
            Toast.makeText(context, "Cannot load data :(", Toast.LENGTH_SHORT).show();
        }
    }

}
