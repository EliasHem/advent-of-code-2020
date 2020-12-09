import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        List<Integer> strList = new ArrayList<>();
        while (sc.hasNextLine()) {
            strList.add(Integer.parseInt(sc.nextLine()));
        }
        int size = strList.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (strList.get(i) + strList.get(j) == 2020) {
                    System.out.println(strList.get(i) * strList.get(j));
                    return;
                }
            }
        }
    }
}