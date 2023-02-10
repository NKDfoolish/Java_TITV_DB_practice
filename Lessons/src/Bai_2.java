public class Bai_2 {
    public static void main(String[] args) {
        int[][] numbers = new int[4][4];
        numbers[0][0] = 13;
        numbers[3][3] = 13;
        for (int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers[0].length; j++){
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
    }
}
