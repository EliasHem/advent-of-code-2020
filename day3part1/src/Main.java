import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        int value = 0;
        int trees = 0;

        List<String> slopes = new ArrayList<>();
        while (sc.hasNextLine()) {
            slopes.add(sc.nextLine());
        }
        slopes.remove(0);
        for (String line : slopes) {
            if (value < 28) {
                value += 3;
            }
            else {
                value = value - 28;
            }

            if (line.charAt(value) == '#') {
                trees++;
            }
        }
        System.out.println(trees);
    }
}
