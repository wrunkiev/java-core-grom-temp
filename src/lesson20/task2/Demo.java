package lesson20.task2;

import java.util.Arrays;
import java.util.Date;



public class Demo {
    public static void main(String[] args) {
        Transaction transaction1 = new Transaction(1, "Kiev", 15, "Трансфер1", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2, "Odessa", 10, "Трансфер2", TransactionType.OUTCOME, new Date());
        Transaction transaction3 = new Transaction(3, "Kiev", 21, "Трансфер3", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(4, "Odessa", 37, "", TransactionType.OUTCOME, new Date());
        Transaction transaction5 = new Transaction(5, "Lvov", 58, "", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(6, "", 58, "Трансфер6", TransactionType.OUTCOME, new Date());
        Transaction transaction7 = null;
        Transaction transaction8 = new Transaction(8, "Kiev", 45, "Трансфер8", TransactionType.INCOME, new Date());
        Transaction transaction9 = new Transaction(9, "Odessa", 123, "Трансфер9", TransactionType.OUTCOME, new Date());
        Transaction transaction10 = new Transaction(10, "Kiev", 145, "Трансфер10", TransactionType.INCOME, new Date());

        Controller controller = new Controller();
        TransactionDAO transactionDAO = new TransactionDAO();

        try {

            System.out.println(controller.save(transaction1));
            System.out.println(controller.save(transaction2));
            System.out.println(controller.save(transaction3));
            System.out.println(controller.save(transaction4));
            System.out.println(controller.save(transaction5));
            System.out.println(controller.save(transaction6));
            System.out.println(controller.save(transaction7));
            System.out.println(controller.save(transaction8));
            System.out.println(controller.save(transaction9));
            System.out.println(controller.save(transaction10));



            System.out.println(Arrays.toString(controller.transactionList()));
            System.out.println(Arrays.toString(controller.transactionList("Dnepr")));
            System.out.println(Arrays.toString(controller.transactionList("Kiev")));
            System.out.println(Arrays.toString(controller.transactionList(45)));

            System.out.println();








        }catch (Exception e){
            System.out.println(e.getMessage());
        }











    }
}
