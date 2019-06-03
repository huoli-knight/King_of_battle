package com.huoli.BaseCharacter;

public interface BaseCharacter {

    int getBoold();
    String getName();
    //护甲
    int getArmor();
    void setSkill(String skillName);
    void setBoold(int newBoold);
    void setAttack(int newAttack);
    int getAttack();
}
