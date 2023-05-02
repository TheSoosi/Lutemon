package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lutemon.storage.BattleStorage;
import com.example.lutemon.storage.HomeStorage;
import com.example.lutemon.storage.LutemonType;
import com.example.lutemon.storage.Storage;
import com.example.lutemon.storage.TrainingStorage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Comment this line to not include pre-made Lutemons.
        createTestLutemons();
    }

    //These are pre-made Lutemons for testing purposes.
    private void createTestLutemons(){
        HomeStorage storage = HomeStorage.getInstance();
        storage.createLutemon("meow", LutemonType.BLACK);
        storage.createLutemon("woof", LutemonType.WHITE);
        storage.createLutemon("glub", LutemonType.GREEN);
        storage.createLutemon("elf", LutemonType.PINK);
        storage.createLutemon("hubert", LutemonType.ORANGE);
    }

    public void onAddLutemonClick(View v) {
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public void onHomeStorageClick(View v) {
        Intent intent = new Intent(this, HomeStorageActivity.class);
        startActivity(intent);
    }

    public void onTrainingAreaClick(View v) {
        Intent intent = new Intent(this, TrainingAreaActivity.class);
        startActivity(intent);
    }

    public void onBattleAreaClick(View v) {
        Intent intent = new Intent(this, BattleAreaActivity.class);
        startActivity(intent);
    }

    public void onSaveClick(View v) {
        HomeStorage homeStorage = HomeStorage.getInstance();
        BattleStorage battleStorage = BattleStorage.getInstance();
        TrainingStorage trainingStorage = TrainingStorage.getInstance();
        homeStorage.save(this);
        battleStorage.save(this);
        trainingStorage.save(this);
        Toast.makeText(this, "Data was saved successfully :)", Toast.LENGTH_SHORT).show();
    }

    public void onLoadClick(View v) {
        HomeStorage homeStorage = HomeStorage.getInstance();
        BattleStorage battleStorage = BattleStorage.getInstance();
        TrainingStorage trainingStorage = TrainingStorage.getInstance();
        homeStorage.load(this);
        battleStorage.load(this);
        trainingStorage.load(this);
        Toast.makeText(this, "Data restored :)", Toast.LENGTH_SHORT).show();
    }

}