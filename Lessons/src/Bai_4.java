public class Bai_4 {
    public static void main(String[] args) {
        float S = SumOfFloat(12,13,25.7f,12,1);
        System.out.println("Sum = " + S);
    }
    public static float SumOfFloat(float ...args){
        float sum = 0;
        System.out.println(args.getClass().getSimpleName()); // check type of variable
        for(float arg : args){
            sum += arg;
        }
        return sum;
    }
}
