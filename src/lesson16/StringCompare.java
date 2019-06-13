package lesson16;
import java.util.Arrays;

public class StringCompare {
    public static void main(String[] args) {
        System.out.println(new String("abc") == new String("abc"));
        System.out.println(new String("abc").equals(new String("abc")));
        System.out.println("abc" == "abc");
        System.out.println("Abc".equals("abc"));

        String s1 = "test";
        String s2 = "test";
        System.out.println(s1 == s2);

        // метод добавляет наш стринг в пул стрингов


        String s3 = new String("pppp");
        String s4 = "pppp";

        System.out.println(s3 == s4);// будет фолс
        s3 = s3.intern();
        System.out.println(s3 == s4);// будет тру, потому что мы засунули s3 в стринг пулов. Потом работает сборщик
        // муссора и убирает обьект new String("pppp")

        // метод getBytes()
        String str = "testStringVar";
        System.out.println(Arrays.toString(str.getBytes()));// получаем массив байтов
        System.out.println(new String(str.getBytes()));
    }
}
