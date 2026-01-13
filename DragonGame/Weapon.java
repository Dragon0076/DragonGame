import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Weapon {
    private String name;
    private int damage;
    private int affinity;
    private int level;
    private String info;
    //Grabs and writes info of a random weapon
    //SOURCED FROM STACK OVERFLOW
    //============================================================
    public Weapon() {
        name = "";
        damage = 0;
        affinity = 0;
        level = 0;
        info = "";
    }
    public void weaponGrab(int targetLine) {
        info = "";
        String filePath = "src/WeaponData.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentLine = 1;

            while ((line = br.readLine()) != null) {
                if (currentLine == targetLine) {
                    info = line;
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void writeInfo() {
        if  (info == null) {
            System.out.println("Info is null");
        } else if (info.equals("")) {
            System.out.println("Info is empty");
        } else {
            //Write info
            //============================================================
            //REGEX SOURCED FROM CHAT GPT (why is it so hard in java will we learn it?)
            Pattern pattern = Pattern.compile("^\"([^\"]+)\", (10|[0-9]), (100|[1-9]?[0-9]), (100|[1-9]?[0-9])$");
            Matcher matcher = pattern.matcher(info);
            if (matcher.find()) {
                name = matcher.group(1);
                level = Integer.parseInt(matcher.group(2));
                affinity = Integer.parseInt(matcher.group(3));
                damage = Integer.parseInt(matcher.group(4));

            } else {
                name = "Unknown";
            }
        }
    }
    public void choice(boolean check) {
        if (check == true) {
            writeInfo();
        } else {
            System.out.println("Swap denied.");
        }

    }
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getAffinity() {
        return affinity;
    }
    public int getDamage() {
        return damage;
    }


}
