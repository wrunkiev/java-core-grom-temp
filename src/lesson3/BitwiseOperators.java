package lesson3;

public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 60;
        int b = 13;
        int c;

        c = a & b;
        System.out.println("a & b = " + c);

        c = a | b;
        System.out.println("a | b = " + c);

        c = a ^ b;
        System.out.println("a ^ b = " + c);

        c = a << 2;
        System.out.println("a << 2 = " + c );

        c = a >> 2;
        System.out.println("a >> 2 = " + c);
    }
}
