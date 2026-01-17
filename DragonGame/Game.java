
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int potions = 50;

        Player p1 = new Player();
        Dragon d1 = new Dragon();

        Weapon wep1 = new Weapon();
        Spells s1 = new Spells();

        System.out.println("Game begins. Here is your starter weapon.");
        wep1.pullRandomWithLevel(1);
        printWeapon(wep1);

        System.out.println("Here is the dragon's spell.");
        s1.pullRandomWithLevel(1);
        printSpell(s1);

        System.out.println("Game loop begins.");

        int playerNextLevelXp = 50;
        int dragonNextLevelXp = 50;

        boolean fled = false;


        while (p1.getHealth() > 0 && d1.getHealth() > 0 && !fled) {

            System.out.println();
            System.out.println("Your turn: Attack, flee, heal, or level up? (1 2 3 4)");
            String usinput = input.nextLine().trim();

            if (usinput.equals("1")) {
                d1.takeDamage(p1.attack(wep1.getDamage()));
                System.out.println("Dragon health: " + d1.getHealth());

            } else if (usinput.equals("2")) {
                System.out.println("You fled the scene.");
                fled = true;
                break;

            } else if (usinput.equals("3")) {
                if (potions <= 0) {
                    System.out.println("No potions left.");
                } else {
                    System.out.println("You healed fully.");
                    p1.heal();
                    potions--;
                    System.out.println("Potions left: " + potions);
                }

            } else if (usinput.equals("4")) {
                if (p1.getXp() >= playerNextLevelXp) {
                    p1.levelUp();
                    System.out.println("You levelled up to level " + p1.getLevel());

                    p1.setXP(p1.getXp() - playerNextLevelXp);
                    playerNextLevelXp += p1.getLevel() * 10;

                    wep1.pullRandomWithLevel(p1.getLevel());
                    System.out.println("New weapon:");
                    printWeapon(wep1);
                    System.out.println("Next level requires: " + playerNextLevelXp + " XP");
                } else {
                    System.out.println("Unable to level. Need " + playerNextLevelXp + " XP. You have " + p1.getXp());
                }

            } else {
                System.out.println("Invalid input.");
                continue;
            }

            if (d1.getHealth() <= 0) break;

            System.out.println();
            System.out.println("Dragon turn: Attack, flee, or level up? (1 2 3)");
            String usinput1 = input.nextLine().trim();

            if (usinput1.equals("1")) {
                p1.takeDamage(d1.attack(s1.getDamage()));
                System.out.println("Player health: " + p1.getHealth());

            } else if (usinput1.equals("2")) {
                System.out.println("Dragon fled the scene.");
                fled = true;
                break;

            } else if (usinput1.equals("3")) {
                if (d1.getXp() >= dragonNextLevelXp) {
                    d1.levelUp();
                    System.out.println("Dragon levelled up to level " + d1.getLevel());

                    d1.setXP(d1.getXp() - dragonNextLevelXp);
                    dragonNextLevelXp += d1.getLevel() * 10;

                    s1.pullRandomWithLevel(d1.getLevel());
                    System.out.println("Dragon's new spell:");
                    printSpell(s1);
                    System.out.println("Dragon next level requires: " + dragonNextLevelXp + " XP");
                } else {
                    System.out.println("Unable to level. Need " + dragonNextLevelXp + " XP. Dragon has " + d1.getXp());
                }

            } else {
                System.out.println("Invalid input. Dragon loses turn.");
            }
        }

        System.out.println();
        if (p1.getHealth() <= 0) {
            System.out.println("You died. Game over.");
        } else if (d1.getHealth() <= 0) {
            System.out.println("Dragon died. You win!");
        } else if (fled) {
            System.out.println("Fight ended due to fleeing.");
        }

        input.close();
    }

    private static void printWeapon(Weapon w) {
        System.out.println("name: " + w.getName());
        System.out.println("level: " + w.getLevel());
        System.out.println("affinity: " + w.getAffinity());
        System.out.println("damage: " + w.getDamage());
    }

    private static void printSpell(Spells s) {
        System.out.println("name: " + s.getName());
        System.out.println("level: " + s.getLevel());
        System.out.println("affinity: " + s.getAffinity());
        System.out.println("damage: " + s.getDamage());
    }
}

