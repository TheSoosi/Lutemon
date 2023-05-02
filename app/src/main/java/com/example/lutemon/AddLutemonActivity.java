package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lutemon.storage.HomeStorage;
import com.example.lutemon.storage.LutemonType;
import com.example.lutemon.storage.Storage;

public class AddLutemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
    }

    public void onCreateLutemonClick(View v) {
        RadioGroup lutemonTypeGroup = findViewById(R.id.lutemonTypeGroup);
        EditText lutemonEditText = findViewById(R.id.lutemonName);
        int selectedType = lutemonTypeGroup.getCheckedRadioButtonId();
        if(selectedType == -1) {
            CustomAlerts.showAlertBox(this, "Add Lutemon", "Choose Lutemon's type");
            return;
        }
        String lutemonName = lutemonEditText.getText().toString();
        if(TextUtils.isEmpty(lutemonName)) {
            CustomAlerts.showAlertBox(this, "Add Lutemon","Give Lutemon a name");
            return;
        }
        RadioButton selectedButton = findViewById(selectedType);
        LutemonType lutemonType = LutemonType.valueOf(selectedButton.getTag().toString());

        HomeStorage storage = HomeStorage.getInstance();
        storage.createLutemon(lutemonName, lutemonType);

        finish();
    }

}