import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 8, 4, 6, 8, 3};
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            if (arr[i] > arr[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        int maxLength = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                count++;
            }
        }
        int[][] result = new int[count][maxLength];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                int[] subArray = new int[maxLength];
                for (int j = 0; j < maxLength; j++) {
                    subArray[j] = arr[i+j-maxLength+1];
                }
                result[index] = subArray;
                index++;
            }
        }
        for (int[] subarray : result) {
            System.out.println(Arrays.toString(subarray));
        }
    }

}
