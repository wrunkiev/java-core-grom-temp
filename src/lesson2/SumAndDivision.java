package lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 1000; i++) {
            sum += i;
        }

        int intPart = sum / 1234;
        int remPart = sum % 1234;

        boolean res = remPart > intPart;
        System.out.println(res);
    }
}
