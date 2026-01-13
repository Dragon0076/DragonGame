
public class Game {
    public static void main(String[] args) {

        System.out.println("Game begins. Here is your starter weapon.");
        Weapon wep1 = new Weapon();
        Player p1 = new Player();
        int tgl = (int)(Math.random() * 151);
        while(true){
            if (wep1.getLevel() == 1){
                System.out.println("Name: " + wep1.getName());
                System.out.println("Level: " + wep1.getLevel());
                System.out.println("Affinity: " + wep1.getAffinity());
                System.out.println("Damage: " + wep1.getDamage());
                System.out.println("p1 damage: " + p1.getAtkPower(wep1.getDamage()));
                System.out.println("can wield?:" + p1.canLevel(wep1.getLevel()));
                break;
            }else {
                tgl = (int)(Math.random()*151);
                wep1.weaponGrab( tgl);
                wep1.choice(true);
            }
        }


    }
}
