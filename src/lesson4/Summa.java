package lesson4;

public class Summa {
    public static void main(String[] args) {
        System.out.println(compareSums(1, 34, 1, 5));
    }

    public static boolean compareSums(int a, int b, int c, int d){
        return sum(a, b) > sum(c, d) ? true : false ;
    }

    public static long sum(int from, int to){
        long sum = 0;
        for(long i = from; i <= to; i++){
            sum += i;
        }
        return sum;
    }
}
