package com.example.lutemon;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class LutemonListViewHolder extends RecyclerView.ViewHolder{

    public final TextView name, attack, defense, experience, hp;
    public final CheckBox checked;
    public final ImageView lutemonImg;
    public LutemonListViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.lutemonName);
        attack = itemView.findViewById(R.id.attackStat);
        defense = itemView.findViewById(R.id.defenceStat);
        experience = itemView.findViewById(R.id.experienceStat);
        hp = itemView.findViewById(R.id.healthPointStat);
        checked = itemView.findViewById(R.id.checkedLutemon);
        lutemonImg = itemView.findViewById(R.id.lutemonImg);

    }
}
