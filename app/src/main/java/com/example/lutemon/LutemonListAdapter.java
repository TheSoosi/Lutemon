package com.example.lutemon;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.storage.Lutemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonListViewHolder>{

    private final ArrayList<Lutemon> lutemons;
    private final Activity context;
    public HashSet<Integer> checkedItems;

    public LutemonListAdapter(ArrayList<Lutemon> lutemons, Activity context) {
        this.lutemons =lutemons;
        this.context = context;
        checkedItems = new HashSet<>();
    }

    @NonNull
    @Override
    public LutemonListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonListViewHolder(LayoutInflater.from(context).inflate(R.layout.luttemon_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonListViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        holder.name.setText(lutemon.getName() + " (" + lutemon.getType().toString() + ")");
        holder.attack.setText("Attack: " + String.valueOf(lutemon.getAttack()));
        holder.defense.setText("Defense: " + String.valueOf(lutemon.getDefence()));
        holder.experience.setText("Experience: " + String.valueOf(lutemon.getExp()));
        holder.hp.setText(String.valueOf(lutemon.getHp()) + "/" + String.valueOf(lutemon.getMaxHp()));
        holder.lutemonImg.setImageResource(lutemon.getImageSrc());
        holder.checked.setChecked(false);
        holder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    checkedItems.add(lutemon.getId());
                } else {
                    checkedItems.remove(lutemon.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
