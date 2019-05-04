package lesson2;

public class LoopExample {
    public static void main(String[] args) {
        int a = 10;

        // 1. while loop
        while(a <= 9)
        {
            System.out.println(a);
            a++;
        }

        //2. do-while loop
        do {
            System.out.println(a);
            a++;
        }while(a <= 11);
    }
}
