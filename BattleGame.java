package hampri;

import javax.swing.*;

public class BattleGame {
    public static void main(String[] args) {
     
        String mageName = getValidName("Enter Mage's name:");
        String warriorName = getValidName("Enter Warrior's name:");

        Mage mage = new Mage(mageName);
        Warrior warrior = new Warrior(warriorName);

        JOptionPane.showMessageDialog(null, "Game starts! Both have 100 HP.");
        
        

        int turn = 1;

        while (mage.getHp() > 0 && warrior.getHp() > 0) {

           
            String status = "Turn ";
            status = status + turn + "\n";

            String mageStatus = mage.getName();
            mageStatus = mageStatus + " (Mage): ";
            mageStatus = mageStatus + mage.getHp();
            mageStatus = mageStatus + " HP\n";

            String warriorStatus = warrior.getName();
            warriorStatus = warriorStatus + " (Warrior): ";
            warriorStatus = warriorStatus + warrior.getHp();
            warriorStatus = warriorStatus + " HP\n";

            status = status + mageStatus;
            status = status + warriorStatus;

            
            String magePrompt = status + "\nChoose " + mage.getName() + "'s move:";
            String[] mageOptions = {"Fireball (20 dmg)", "Secret Power (30 dmg)"};
            int mageChoice = getChoice(magePrompt, mageOptions);

            if (mageChoice == -1) {
                quitGame(); // Quit if X pressed
            }

            int mageDamage;
            if (mageChoice == 0) {
                mageDamage = mage.attack();
            } else {
                mageDamage = mage.specialMove();
            }
            warrior.takeDamage(mageDamage);

            if (warrior.getHp() <= 0) {
                break; 
            }

            
            String warriorPrompt = status + "\nChoose " + warrior.getName() + "'s move:";
            String[] warriorOptions = {"Sword Slash (15 dmg)", "Shield Bash (25 dmg)"};
            int warriorChoice = getChoice(warriorPrompt, warriorOptions);

            if (warriorChoice == -1) {
                quitGame(); // Quit if X pressed
            }

            int warriorDamage;
            if (warriorChoice == 0) {
                warriorDamage = warrior.attack();
            } else {
                warriorDamage = warrior.specialMove();
            }
            mage.takeDamage(warriorDamage);

            turn++;
        }
        
        
        
        String winner;

        if (mage.getHp() <= 0 && warrior.getHp() <= 0) {
            winner = "It's a draw!";
        } else if (mage.getHp() <= 0) {
            winner = warrior.getName();
            winner = winner + " (Warrior) wins!";
        } else {
            winner = mage.getName();
            winner = winner + " (Mage) wins!";
        }

        JOptionPane.showMessageDialog(null, winner);
    }

    
    private static String getValidName(String message) {
        String name;
        do {
            name = JOptionPane.showInputDialog(message);
            if (name == null || name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name cannot be empty! Please enter a name.");
            }
        } while (name == null || name.trim().isEmpty());
        return name.trim();
    }

    private static int getChoice(String message, String[] options) {
        return JOptionPane.showOptionDialog(null, message, "Choose Move",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

    private static void quitGame() {
        JOptionPane.showMessageDialog(null, "Game Quit! No winner.");
        System.exit(0);
    }
}
