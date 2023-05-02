package com.example.lutemon.storage;

import java.io.Serializable;

public abstract class Lutemon implements Serializable {
    private static int idCounter = 0;
    protected int id;
    protected String name;
    protected int attack;
    protected int defence;
    protected int exp;
    protected int hp;
    protected int maxHp;
    protected LutemonType type;
    protected int imageSrc;

    protected Lutemon(String name, LutemonType type, int imageSrc, int attack, int defence, int maxHp){
        this.name = name;
        this.type = type;
        this.imageSrc = imageSrc;
        this.attack = attack;
        this.defence = defence;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.exp = 0;
        idCounter += 1;
        id = idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LutemonType getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getExp() {
        return exp;
    }

    public void addExp() {
        exp += 1;
    }
    public int getHp() {
        return hp;
    }

    public void restoreHp() {
        hp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public int attack() {
        return attack + exp;
    }

    public void defence(Lutemon attackLutemon) {
        int tempHp = hp - (attackLutemon.attack() - defence);
        hp = tempHp > 0 ? tempHp : 0;
    }

    public String getStats() {
        return String.format("%d: %s(%s) att: %d; def: %d; exp: %d; health: %d/%d\n", id, type.toString(), name, attack, defence, exp, hp, maxHp);

    }

}
