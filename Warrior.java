package hampri;

import javax.swing.JOptionPane;

class Warrior extends GameCharacter {
    public Warrior(String name) {
        super(name);
    }

    @Override
    public int attack() {
        JOptionPane.showMessageDialog(null, name + " swings a mighty sword! (15 damage)");
        return 15;
    }

    @Override
    public int specialMove() {
        JOptionPane.showMessageDialog(null, name + " uses Shield Bash! (25 damage)");
        return 25;
    }
}