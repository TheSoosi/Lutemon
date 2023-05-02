package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.lutemon.storage.BattleStorage;
import com.example.lutemon.storage.HomeStorage;
import com.example.lutemon.storage.Lutemon;
import com.example.lutemon.storage.TrainingStorage;

import java.util.ArrayList;

public class TrainingAreaActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Lutemon> lutemons;
    private LutemonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_area);


        TrainingStorage storage = TrainingStorage.getInstance();
        lutemons = storage.getLutemons();
        rv = findViewById(R.id.lutemonTrainingList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonListAdapter(lutemons, this);
        rv.setAdapter(adapter);
    }

    public void onClickMoveToBattle(View v) {
        TrainingStorage trainingStorage = TrainingStorage.getInstance();
        BattleStorage battleStorage = BattleStorage.getInstance();

        for (Integer lutemonId : adapter.checkedItems) {
            Lutemon lutemon = trainingStorage.getLutemon(lutemonId);
            trainingStorage.removeLutemon(lutemonId);
            battleStorage.addLutemon(lutemon);
        }
        updateLutemonList(trainingStorage.getLutemons());
    }

    public void onClickMoveHome(View v) {
        HomeStorage homeStorage = HomeStorage.getInstance();
        TrainingStorage trainingStorage = TrainingStorage.getInstance();

        for (Integer lutemonId : adapter.checkedItems) {
            Lutemon lutemon = trainingStorage.getLutemon(lutemonId);
            trainingStorage.removeLutemon(lutemonId);
            homeStorage.addLutemon(lutemon);
        }
        updateLutemonList(trainingStorage.getLutemons());
    }

    private void updateLutemonList(ArrayList<Lutemon> items) {
        lutemons.clear();
        lutemons.addAll(items);
        adapter.checkedItems.clear();
        adapter.notifyDataSetChanged();
    }
}