import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) {
        File f = null;
        int total = 0;
        try {
            f = new File("inputFile");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                while (currentLine.contains("one") || currentLine.contains("two") || currentLine.contains("three") || currentLine.contains("four") || currentLine.contains("five") ||
                        currentLine.contains("six") || currentLine.contains("seven") || currentLine.contains("eight") || currentLine.contains("nine")) {
                    if (currentLine.contains("one")) {
                        currentLine = currentLine.substring(0, currentLine.indexOf("one") + 1) + "1" + currentLine.substring(currentLine.indexOf("one") + 2);
                    }
                    if (currentLine.contains("two")) {
                        currentLine = currentLine.substring(0, currentLine.indexOf("two") + 1) + "2" + currentLine.substring(currentLine.indexOf("two") + 2);
                    }
                    if (currentLine.contains("three")) {
                        currentLine = currentLine.substring(0, currentLine.indexOf("three") + 1) + "3" + currentLine.substring(currentLine.indexOf("three") + 4);
                    }
                    if (currentLine.contains("four")) {
                        currentLine = currentLine.substring(0, currentLine.indexOf("four") + 1) + "4" + currentLine.substring(currentLine.indexOf("four") + 3);
                    }
                    if (currentLine.contains("five")) {
                        currentLine = currentLine.substring(0, currentLine.indexOf("five") + 1) + "5" + currentLine.substring(currentLine.indexOf("five") + 3);
                    }
                    if (currentLine.contains("six")) {
                        currentLine = currentLine.substring(0, currentLine.indexOf("six") + 1) + "6" + currentLine.substring(currentLine.indexOf("six") + 2);
                    }
                    if (currentLine.contains("seven")) {
                        currentLine = currentLine.substring(0, currentLine.indexOf("seven") + 1) + "7" + currentLine.substring(currentLine.indexOf("seven") + 4);
                    }
                    if (currentLine.contains("eight")) {
                        currentLine = currentLine.substring(0, currentLine.indexOf("eight") + 1) + "8" + currentLine.substring(currentLine.indexOf("eight") + 4);
                    }
                    if (currentLine.contains("nine")) {
                        currentLine = currentLine.substring(0, currentLine.indexOf("nine") + 1) + "9" + currentLine.substring(currentLine.indexOf("nine") + 3);
                    }
                }
                String clean = currentLine.replaceAll("\\D+", ""); //remove non-digits
                int first = Integer.parseInt(clean.charAt(0) + "0");
                int last = Integer.parseInt(clean.substring(clean.length() - 1));
                int combined = first + last;
                total += combined;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        System.out.println(total);
    }
}