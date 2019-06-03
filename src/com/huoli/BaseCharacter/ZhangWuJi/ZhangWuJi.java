package com.huoli.BaseCharacter.ZhangWuJi;

import com.huoli.BaseCharacter.BaseCharacter;

public class ZhangWuJi implements BaseCharacter {

    private int boold;
    private String name;
    //护甲
    private int armor;
    private int attack;
    private String skillName;

    public ZhangWuJi(String name, int boold, int armor, int attack) {
        super();
        this.name = name;
        this.boold = boold * 10;
        this.armor = armor * 10;
        this.attack = attack * 100;

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
