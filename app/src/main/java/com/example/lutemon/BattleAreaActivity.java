package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lutemon.storage.BattleField;
import com.example.lutemon.storage.BattleStorage;
import com.example.lutemon.storage.HomeStorage;
import com.example.lutemon.storage.Lutemon;

import java.util.ArrayList;

public class BattleAreaActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Lutemon> lutemons;
    private LutemonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_area);

        BattleStorage storage = BattleStorage.getInstance();
        lutemons = storage.getLutemons();
        rv = findViewById(R.id.lutemonBattleList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonListAdapter(lutemons, this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        BattleStorage battleStorage = BattleStorage.getInstance();
        updateLutemonList(battleStorage.getLutemons());
    }

    public void onClickMoveHome(View v) {
        HomeStorage homeStorage = HomeStorage.getInstance();
        BattleStorage battleStorage = BattleStorage.getInstance();

        for (Integer lutemonId : adapter.checkedItems) {
            Lutemon lutemon = battleStorage.getLutemon(lutemonId);
            battleStorage.removeLutemon(lutemonId);
            homeStorage.addLutemon(lutemon);
        }
        updateLutemonList(battleStorage.getLutemons());
    }

    private void updateLutemonList(ArrayList<Lutemon> items) {
        lutemons.clear();
        lutemons.addAll(items);
        adapter.checkedItems.clear();
        adapter.notifyDataSetChanged();
    }

    public void onClickMoveToBattle(View v) {
        if(adapter.checkedItems.size() != 2) {
            CustomAlerts.showAlertBox(this, "Battle Area","Choose only 2 Lutemons to start a battle");
            return;
        }

        BattleStorage battleStorage = BattleStorage.getInstance();
        BattleField battleField = BattleField.getInstance();

        for (Integer lutemonId : adapter.checkedItems) {
            Lutemon lutemon = battleStorage.getLutemon(lutemonId);
            battleStorage.removeLutemon(lutemonId);
            battleField.addLutemon(lutemon);
        }

        updateLutemonList(battleStorage.getLutemons());

        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }
}