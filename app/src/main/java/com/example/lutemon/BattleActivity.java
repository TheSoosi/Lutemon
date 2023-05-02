package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.lutemon.storage.BattleField;
import com.example.lutemon.storage.TrainingStorage;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        BattleField battleField = BattleField.getInstance();
        String fightResults = battleField.fight();
        TextView stats = findViewById(R.id.battleResults);
        stats.setText(fightResults);

        stats.setMovementMethod(new ScrollingMovementMethod());

        TrainingStorage trainingStorage = TrainingStorage.getInstance();
        trainingStorage.addExp();
    }
}