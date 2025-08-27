package hampri;

import javax.swing.*;

abstract class GameCharacter {
    protected String name;
    protected int hp;

    public GameCharacter(String name) {
        this.name = name;
        this.hp = 100;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public abstract int attack();
    public abstract int specialMove();
}
