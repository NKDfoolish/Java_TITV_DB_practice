public class Bai_3 {
    public static void main(String[] args) {
        /*
        int[] arrOfInteger = new int[4];
        for (int item: arrOfInteger) {
            System.out.print(item + " ");
        }
         */

        float[][] floatNumber = {
                {1,2,3},
                {4,5,6},
                {0.5f,0.5f,2.9f}
        };
        for(float[] m : floatNumber){
            for(float i : m){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
