package lesson20.task2;

import java.util.Arrays;
import java.util.Date;



public class Demo {
    public static void main(String[] args) {
        Transaction transaction1 = new Transaction(1, "Kiev", 15, "Трансфер1", TransactionType.OUTCOME, new Date());

        Controller controller = new Controller();

        try {
            System.out.println(Arrays.toString(controller.transactionList()));
            System.out.println(controller.save(transaction1));
            System.out.println(Arrays.toString(controller.transactionList()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
