public class Player {
    private int health;
    private int level;
    private int affinity;
    private int xp;
    private int damage;
    public boolean rage;

    public Player() {
        health = 200;
        level = 1;
        affinity = 50;
        xp = 0;
    }
    public void heal() {
        health = 100;
    }
    public double getAtkPower(int damage) {
        if (rage) {
            return (2)*(double)damage*(double)(level);
        }
        return (double)damage*(double)(level);
    }
    public void levelUp() {
        level++;
    }
    public boolean canLevel(int level) {
        return this.level >= level;
    }
    public void enterRage() {
        rage = true;
    }
    public int getHealth() {
        return health;
    }
    public int getLevel() {
        return level;
    }
    public int getAffinity() {
        return affinity;
    }
    public int getXp() {
        return xp;
    }
    public int setXP(int xp) {
        this.xp = xp;
        return xp;
    }
    public double attack(int damage) {
        xp += damage;
        return (double)damage*(double)(level);
    }
    public void takeDamage(double damage) {
        health -= damage;
    }
    public void returnInfo() {
        System.out.println("Health: " + health);
        System.out.println("Level: " + level);
        System.out.println("Affinity: " + affinity);
        System.out.println("XP: " + xp);
        System.out.println("Damage: " + damage);
    }
}
