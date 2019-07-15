package lesson31.homework;

public class Demo {
    public static void main(String[] args) {
        try{
            System.out.println(Solution.countSymbols("    Приыфисо    оирыфиври   ылфврфыивф    ылфтвофив        "));
            System.out.println(Solution.words("   hello   hi gresd  hi    hello   ghgs "));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
