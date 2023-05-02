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

public class HomeStorageActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<Lutemon> lutemons;
    private LutemonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_storage);

        HomeStorage storage = HomeStorage.getInstance();
        lutemons = storage.getLutemons();
        rv = findViewById(R.id.lutemonHomeList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonListAdapter(lutemons, this);
        rv.setAdapter(adapter);
    }

    public void onClickMoveToBattleArea(View v) {
        HomeStorage homeStorage = HomeStorage.getInstance();
        BattleStorage battleStorage = BattleStorage.getInstance();

        for (Integer lutemonId : adapter.checkedItems) {
            Lutemon lutemon = homeStorage.getLutemon(lutemonId);
            homeStorage.removeLutemon(lutemonId);
            battleStorage.addLutemon(lutemon);
        }
        updateLutemonList(homeStorage.getLutemons());
    }

    public void onClickMoveToTrainingArea(View v) {
        HomeStorage homeStorage = HomeStorage.getInstance();
        TrainingStorage trainingStorage = TrainingStorage.getInstance();

        for (Integer lutemonId : adapter.checkedItems) {
            Lutemon lutemon = homeStorage.getLutemon(lutemonId);
            homeStorage.removeLutemon(lutemonId);
            trainingStorage.addLutemon(lutemon);
        }
        updateLutemonList(homeStorage.getLutemons());
    }

    private void updateLutemonList(ArrayList<Lutemon> items) {
        lutemons.clear();
        lutemons.addAll(items);
        adapter.checkedItems.clear();
        adapter.notifyDataSetChanged();
    }

}