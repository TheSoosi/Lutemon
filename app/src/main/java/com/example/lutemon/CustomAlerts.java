package com.example.lutemon;

import android.app.AlertDialog;
import android.content.Context;

public class CustomAlerts {
    public static void showAlertBox(Context context, String title, String message){
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
