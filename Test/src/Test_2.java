import java.util.Scanner;
public class Test_2 {
    public static void main(String[] args) {
        int[] k = new int[100];
        int len;
        int start = 0;
        int max_length = 1;
        int sub_max_len = 1;
        int[] pos = new int[100];
        int dup = 1;
        int box = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu cho mang: ");
        len = scanner.nextInt();
        System.out.println("Nhap mang:");
        for (int i = 0; i < len; i++) {
            System.out.print("Phan tu thu " + (i + 1) + ": ");
            k[i] = scanner.nextInt();
            System.out.println();
        }

        for (int i = 0; i < len; i++) {
            if ((k[i] < k[i + 1] && i == 0)) {
                box = i;
            } else if (i != 0) {
                if((k[i] < k[i - 1] && k[i] < k[i + 1]) ){
                    box = i;
                }
            }
            if (k[i] < k[i + 1]) {
                sub_max_len++;
            } else if ((k[i] > k[i + 1] && i != 0) || (i != 0 && k[i] > k[i - 1] && i == len - 1)) {
                if (sub_max_len > max_length) {
                    max_length = sub_max_len;
                    pos[start] = box;
                } else if (sub_max_len == max_length) {
                    dup++;
                    start++;
                    pos[start] = box;
                }
                sub_max_len = 1;
            }
        }

        for (int i = 0; i < dup; i++) {
            System.out.print(pos[i] + " la vi tri cua mang: ");
            for (int j = pos[i]; j < pos[i] + max_length; j++) {
                System.out.print(k[j] + " ");
            }
            System.out.println();
        }
    }
}

