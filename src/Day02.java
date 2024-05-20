import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02 {
    public static void main(String[] args) {
        File f = null;
        int IDs = 0;
        int sum = 0;
        try {
            f = new File("inputFile");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
//                IDs += checkPlayability(s.nextLine());
                sum += returnPower(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        System.out.println(IDs);
        System.out.println(sum);
    }

    public static int checkPlayability(String str) { //pt1
        int red = 0;
        int green = 0;
        int blue = 0;
        boolean checkedGame = false;
        String updatedStr = str.substring(str.indexOf(":") + 2) + ", ";
        while (!updatedStr.isEmpty()) {
            while (!checkedGame){
                if (red > 12 || green > 13 || blue > 14){
                    return 0;
                }
                if (updatedStr.isEmpty()){
                    return Integer.parseInt(str.substring(str.indexOf(" ") + 1, str.indexOf(":")));
                }
                if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(",")).equals("red")) {
                    red += Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(",") + 2);
                }
                else if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(",")).equals("green")) {
                    green += Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(",") + 2);
                }
                else if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(",")).equals("blue")) {
                    blue += Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(",") + 2);
                }
                else if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(";")).equals("red")) {
                    red += Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(";") + 2);
                    checkedGame = true;
                }
                else if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(";")).equals("green")) {
                    green += Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(";") + 2);
                    checkedGame = true;
                }
                else if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(";")).equals("blue")) {
                    blue += Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(";") + 2);
                    checkedGame = true;
                }
            }
            if (red > 12 || green > 13 || blue > 14){
                return 0;}
            red = 0;
            green = 0;
            blue = 0;
            checkedGame = false;
        }
        return Integer.parseInt(str.substring(str.indexOf(" ") + 1, str.indexOf(":")));
    }

    public static int returnPower(String str){ // pt2
        int red = 0;
        int green = 0;
        int blue = 0;
        int currentRed = 0;
        int currentGreen = 0;
        int currentBlue = 0;
        boolean checkedGame = false;
        String updatedStr = str.substring(str.indexOf(":") + 2) + ", ";
        while (true) {
            while (!checkedGame){
                if (currentRed >= red){
                    red = currentRed;
                }
                if (currentGreen >= green){
                    green = currentGreen;
                }
                if (currentBlue >= blue){
                    blue = currentBlue;
                }
                if (updatedStr.isEmpty()){
                    return red*green*blue;
                }
                if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(",")).equals("red")) {
                    currentRed = Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(",") + 2);
                }
                else if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(",")).equals("green")) {
                    currentGreen = Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(",") + 2);
                }
                else if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(",")).equals("blue")) {
                    currentBlue = Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(",") + 2);
                }
                else if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(";")).equals("red")) {
                    currentRed = Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(";") + 2);
                    checkedGame = true;
                }
                else if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(";")).equals("green")) {
                    currentGreen = Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(";") + 2);
                    checkedGame = true;
                }
                else if (updatedStr.substring(updatedStr.indexOf(" ") + 1, updatedStr.indexOf(";")).equals("blue")) {
                    currentBlue = Integer.parseInt(updatedStr.substring(0, updatedStr.indexOf(" ")));
                    updatedStr = updatedStr.substring(updatedStr.indexOf(";") + 2);
                    checkedGame = true;
                }
            }
            if (currentRed >= red){
                red = currentRed;
            }
            if (currentGreen >= green){
                green = currentGreen;
            }
            if (currentBlue >= blue){
                blue = currentBlue;
            }
            currentRed = 0;
            currentGreen = 0;
            currentBlue = 0;
            checkedGame = false;
        }
    }
}