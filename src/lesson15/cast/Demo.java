package lesson15.cast;

public class Demo {
    public static void main(String[] args) {
        InternetProvider provider = (InternetProvider) test();
        FoodProvider foodProvider = (FoodProvider)test();

        System.out.println(provider);
    }

    private static Provider test(){
        return new InternetProvider();
    }

    private static Provider testFood(){
        return new InternetProvider();
    }
}
