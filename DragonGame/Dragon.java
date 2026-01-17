public class Dragon {
    private int health;
    private int level;
    private int affinity;
    private int xp;
    private int damage;
    public boolean rage;

    public Dragon() {
        health = 10000;
        level = 1;
        affinity = 50;
        xp = 0;
    }
    public void levelUp() {
        level++;
    }
    public double getAtkPower(int damage) {
        if (rage) {
            return (2)*(double)damage*(double)(level);
        }
        return (double)damage*(double)(level);
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
    public void setXP( int xp) {
        this.xp = xp;
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
    public double attack(int damage) {
        xp += damage;
        return (double)damage*(double)(level)/2;

    }
    public void takeDamage(double damage) {
        health -= damage;
    }
}
