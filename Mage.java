package hampri;

import javax.swing.JOptionPane;

class Mage extends GameCharacter {
    public Mage(String name) {
        super(name);
    }

    @Override
    public int attack() {
        JOptionPane.showMessageDialog(null, name + " casts Fireball! (20 damage)");
        return 20;
    }

    @Override
    public int specialMove() {
        JOptionPane.showMessageDialog(null, name + " uses Secret Power! (30 damage)");
        return 30;
    }
}
