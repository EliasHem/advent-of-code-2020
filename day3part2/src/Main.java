import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        int[] rights = new int[] {1,3,5,7,1};
        int[] downs = new int[] {1,1,1,1,2};
        int value;
        int trees;
        long solution = 1;

        List<String> slopes = new ArrayList<>();
        while (sc.hasNextLine()) {
            slopes.add(sc.nextLine());
        }
        int slopeLength = slopes.get(0).length();

        for (int i = 0; i < 5; i++){
            value = 0;
            trees = 0;
            int right = rights[i];
            int down = downs[i];
            int max = slopeLength - 1 - right;
            //System.out.println("NEW SCENARIO: X = " + right + " Y = " + down);
            for (int j = down; j < slopes.size(); j+=down){
                if (value > max){
                    value = value + right - slopeLength;
                }
                else {
                    value+=right;
                }
                //System.out.println("Current position: X = " + value + ", Y = " + j);
                if (slopes.get(j).charAt(value) == '#'){
                    trees++;
                }
            }
            solution *= trees;
        }
        System.out.println(solution);
    }
}
