public class Player {
    private int health;
    private int level;
    private int affinity;
    private int xp;

    public Player() {
        health = 100;
        level = 1;
        affinity = 50;
        xp = 0;
    }

    public double getAtkPower(int damage) {
        return (double)damage*(double)(level);
    }

    public boolean canLevel(int level) {
        return this.level >= level;
    }

}
