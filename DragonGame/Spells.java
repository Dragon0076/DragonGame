import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;
public class Spells {
    private String name;
    private int damage;
    private int affinity;
    private int level;
    private String info;
    //Grabs and writes info of a random weapon
    //SOURCED FROM STACK OVERFLOW
    //============================================================
    public void Weapon() {
        name = "";
        damage = 0;
        affinity = 0;
        level = 0;
        info = "";
    }
    public void weaponGrab(int targetLine) {
        info = "";
        String filePath = "src/SpellsData.txt";
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
    public boolean pullRandomWithLevel(int targetLevel) {
        Random rng = new Random();
        int totalLines = 0;

        // First count lines
        try (BufferedReader br = new BufferedReader(new FileReader("src/SpellsData.txt"))) {
            while (br.readLine() != null) totalLines++;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (totalLines == 0) return false;

        // Try until match found
        while (true) {
            int randomLine = rng.nextInt(totalLines) + 1;

            weaponGrab(randomLine);
            writeInfo();

            if (this.level == targetLevel) {
                return true; // success
            }
            // else try again
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
