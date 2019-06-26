package lesson22.homework;

import java.util.Arrays;
import java.util.Date;


public class Demo {
    public static void main(String[] args) {
        Transaction transaction1 = new Transaction(1, "Kiev", 15, "Трансфер1", TransactionType.OUTCOME, new Date());

        try {
            System.out.println(Arrays.toString(Controller.transactionList()));
            System.out.println(Controller.save(transaction1));
            System.out.println(Arrays.toString(Controller.transactionList()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
