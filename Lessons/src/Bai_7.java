import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai_7 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Lessons/src/input.txt");
        Scanner scanner = new Scanner(file);

        String[] words = new String[100];
        int[] arr = new int[100];
        int i = 0;

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            arr[i] = num;
            i++;
            if (i >= 100) break;
        /*while (scanner.hasNext()){
            String word = scanner.next();
            words[i] = word;
            i++;
        }*/
        }
        showNumber(arr);
    }

    /*private static void showInfo(String[] words) {
        for (String word : words) {
            if(word == null) break;
            System.out.println(word);
        }
    }*/

    private static void showNumber(int[] arr) {
        for (int num : arr) {
            if (num == 0) continue;
            System.out.println(num);
        }
    }
}
