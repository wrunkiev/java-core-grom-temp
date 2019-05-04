package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank usBank1 = new USBank(1222,
                "Sweden",
                Currency.EUR,
                100,
                1400,
                4,
                444343434);
        Bank usBank2 = new USBank(234,
                "Sweden",
                Currency.USD,
                120,
                1300,
                5,
                10000000);

        Bank euBank1 = new EUBank(2356,
                "Ukraine",
                Currency.EUR,
                100,
                1534,
                4,
                1000000);

        Bank euBank2 = new EUBank(2376,
                "Ukraine",
                Currency.USD,
                150,
                1600,
                6,
                10000000);

        Bank chBank1 = new ChinaBank(23,
                "China",
                Currency.EUR,
                70,
                1100,
                2,
                1000000);
        Bank chBank2 = new ChinaBank(231,
                "China",
                Currency.USD,
                80,
                1150,
                9,
                10000000);

        User user1 = new User(1001,
                "Denis",
                12200,
                40,
                "GMD",
                1500,
                euBank1);

        User user2 = new User(1002,
                "Sergey",
                14200,
                53,
                "Google",
                1654,
                usBank1);

        BankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.withdraw(user1, 150);
        System.out.println(user1.toString());
        System.out.println();
        bankSystem.fund(user1, 2345);
        System.out.println(user1.toString());
        System.out.println();
        bankSystem.paySalary(user1);
        System.out.println(user1.toString());
        System.out.println();
        bankSystem.transferMoney(user1, user2,1250);
        System.out.println(user1.toString());
        System.out.println();

        bankSystem.withdraw(user2, 2300);
        System.out.println(user2.toString());
        System.out.println();
        bankSystem.fund(user2, 1200);
        System.out.println(user2.toString());
        System.out.println();
        bankSystem.paySalary(user2);
        System.out.println(user2.toString());
        System.out.println();
        bankSystem.transferMoney(user2, user1, 3450);
        System.out.println(user2.toString());
        System.out.println();
    }
}
