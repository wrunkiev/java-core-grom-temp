package lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int result = 0;
        for(int i = 0; i <= 1000; i++){
            if (i%2 > 0) {
                System.out.println("Found");
                result += i;
            }
        }
        if(result * 5 > 5000)
            System.out.println("Bigger");
        else
            System.out.println("Smaller or equal");
    }
}
