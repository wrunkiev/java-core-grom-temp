package lesson4;

public class Concatenation {
    public static void main(String[] args) {
        System.out.println(concat("Hello", ",", "world !"));
    }

    public static String concat(String a, String b, String c){
        return a + b + c;
    }
}
