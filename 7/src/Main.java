import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int vCounter = 0;
        String[] required = new String[] {"byr:", "iyr:", "eyr:", "hcl:", "hgt:", "ecl:", "pid:"};
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        List<String> passports = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        while (sc.hasNextLine()) {
            String next = sc.nextLine();
            if (next.isEmpty()) {
                if (!temp.toString().equals("")) {
                    passports.add(temp.toString());
                    temp.setLength(0);
                }
            } else {
                temp.append(next);
            }
        }
        passports.add(temp.toString());

        for (String line : passports) {
            boolean valid = true;
            for (String type : required){
                if (!line.contains(type)){
                    valid = false;
                }
            }
            if (valid){
                vCounter++;
            }
        }
        System.out.println(vCounter);
    }
}