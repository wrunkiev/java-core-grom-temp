package lesson31.homework;

public class Demo {
    public static void main(String[] args) {
        try{
            System.out.println(Solution.countSymbols("    aaa    sdf    ass        "));
            System.out.println(Solution.words(" hello   df4sf    hello    hel    as   as "));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
