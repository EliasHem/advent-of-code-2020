import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("gwerg.txt");
        Scanner sc = new Scanner(file);
        int valid = 0;

        List<String> strList = new ArrayList<>();
        while (sc.hasNextLine()) {
            strList.add(sc.nextLine());
        }

        for (String line : strList) {
            int dash = line.indexOf('-');
            int semi = line.indexOf(':');
            int min = Integer.parseInt(line.substring(0, dash));
            int max = Integer.parseInt(line.substring(dash + 1, semi - 2));
            char constr = line.charAt(semi - 1);
            String passw = line.substring(semi + 2);

            int count = 0;
            if (passw.charAt(min-1) == constr){
                count++;
            }
            if (passw.charAt(max-1) == constr){
                count++;
            }
            if (count == 1)
                valid++;
        }
        System.out.println(valid);
    }
}
