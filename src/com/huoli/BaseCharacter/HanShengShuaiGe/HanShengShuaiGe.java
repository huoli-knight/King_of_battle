package com.huoli.BaseCharacter.HanShengShuaiGe;

import com.huoli.BaseCharacter.BaseCharacter;

public class HanShengShuaiGe implements BaseCharacter {
    private int boold;
    private String name;
    private int armor;
    private int attack;
    private String skillName;

    public HanShengShuaiGe(String name, int boold, int armor, int attack) {
        super();
        this.name = name;
        this.boold = boold;
        this.armor = armor;
        this.attack = attack;
    }


    @Override
    public int getBoold() {
        return this.boold;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public void setSkill(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public void setBoold(int newBoold) {
        this.boold -= newBoold;
    }

    @Override
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

}
