import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] arg) {
        //Hate this exercise
        int valid = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            String deli = ":|\\s";
            String[] req = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
            while (line != null) {
                int reqs = 0;
                while (!line.equals("")) {
                    String[] fields = line.split(deli);
                    for (int i = 0; i < fields.length; i++) {
                        switch (fields[i]) {
                            case "byr":
                                int byr = Integer.parseInt(fields[i + 1]);
                                if (byr <= 2002 && byr >= 1920) reqs++;
                                break;
                            case "iyr":
                                int iyr = Integer.parseInt(fields[i + 1]);
                                if (iyr <= 2020 && iyr >= 2010) reqs++;
                                break;
                            case "eyr":
                                int eyr = Integer.parseInt(fields[i + 1]);
                                if (eyr <= 2030 && eyr >= 2020) reqs++;
                                break;
                            case "hgt":
                                String scale = fields[i + 1].substring(fields[i + 1].length() - 2);
                                if (scale.equals("cm")) {
                                    int hgt = Integer.parseInt(fields[i + 1].substring(0, fields[i + 1].length() - 2));
                                    if (hgt <= 193 && hgt >= 150) reqs++;
                                }
                                if (scale.equals("in")) {
                                    int hgt = Integer.parseInt(fields[i + 1].substring(0, fields[i + 1].length() - 2));
                                    if (hgt <= 76 && hgt >= 59) reqs++;
                                }
                                break;
                            case "hcl":
                                if (fields[i + 1].charAt(0) == '#') {
                                    String val = fields[i + 1].substring(1);
                                    int count = 0;
                                    for (var chr : val.toCharArray()) {
                                        if ("0123456789abcdef".indexOf(chr) != -1) count++;
                                    }
                                    if (count == 6) reqs++;
                                }
                                break;
                            case "ecl":
                                String val = fields[i + 1];
                                if (Arrays.asList(req).contains(val)) reqs++;
                                break;
                            case "pid":
                                String vl = fields[i + 1];
                                int count = 0;
                                for (var chr : vl.toCharArray()) {
                                    if ("0123456789".indexOf(chr) != -1) count++;
                                }
                                if (count == 9) reqs++;
                        }
                    }
                    line = reader.readLine();
                    if (line == null) break;
                }
                if (reqs == 7) {
                    valid++;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(valid);
    }
}
