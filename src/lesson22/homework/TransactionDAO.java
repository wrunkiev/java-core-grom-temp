package lesson22.homework;

import lesson22.homework.exception.BadRequestException;
import lesson22.homework.exception.InternalServerException;
import lesson22.homework.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private static Transaction[] transactions = new Transaction[10];

    public static Transaction save(Transaction transaction) throws Exception{
        // сумма транзакции больше указанного лимита
        // сумма транзакций за день больше дневного лимита
        // количество транзакций за день больше указанного лимита
        // если город оплаты (совершения транзакции) не разрешен
        // не хватило места

        validate(transaction);

        int index = 0;
        for(Transaction tr : transactions){
            if(tr == null){
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }

        throw new InternalServerException("Not enough space to save transaction with id: " + transaction.getId());
    }

    private static void validate(Transaction transaction) throws Exception{
        if(transaction == null)
            throw new BadRequestException("Can't save null transaction");

        if(transaction.getCity() == null || transaction.getType() == null || transaction.getDescription() == null)
            throw new BadRequestException("Attributes of transaction can't be null");

        if(transaction.getAmount() > Utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for(Transaction tr : getTransactionsPerDay(transaction.getDateCreated())){
            if(tr != null) {
                sum += tr.getAmount();
                count++;
            }

            if(tr != null && tr.equals(transaction)){
                throw new BadRequestException("Such transaction with id: " + transaction.getId() + " already exist");
            }
        }

        if(sum + transaction.getAmount() > Utils.getLimitTransactionsPerDayAmount()){
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");
        }

        if(count + 1 > Utils.getLimitTransactionsPerDayCount()){
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");
        }

        boolean isCity = false;
        for(String city : Utils.getCities()){
            if(transaction.getCity().equals(city)){
                isCity = true;
            }
        }

        if(!isCity) {
            throw new BadRequestException("City of transaction " + transaction.getId() + " not allowed. Can't be saved");
        }
    }

    public static Transaction[] transactionList() throws Exception{
        int count = 0;
        for(Transaction tr : transactions){
            if(tr != null){
                count++;
            }
        }

        Transaction[] result = new Transaction[count];

        int index = 0;
        for(Transaction tr : transactions){
            if(tr != null){
                result[index] = tr;
                index++;
            }
        }
        return result;
    }

    public static Transaction[] transactionList(String city) throws Exception{
        if(city == null)
            throw new BadRequestException("City of null is not allowed");

        int count = 0;
        for(Transaction tr : transactions){
            if(tr != null && tr.getCity().equals(city)) {
                count++;
            }
        }

        /*if(count == 0)
            throw new BadRequestException("Transactions with such city " + city + " is not exist");*/

        Transaction[] result = new Transaction[count];

        int index = 0;
        for(Transaction tr : transactions){
            if(tr != null && tr.getCity().equals(city)) {
                result[index] = tr;
                index++;
            }
        }
        return result;
    }

    public static Transaction[] transactionList(int amount) throws Exception{
        int count = 0;
        for(Transaction tr : transactions){
            if(tr != null && tr.getAmount() == amount) {
                count++;
            }
        }

        /*if(count == 0)
            throw new BadRequestException("Transactions with such amount " + amount + " is not exist");*/

        Transaction[] result = new Transaction[count];

        int index = 0;
        for(Transaction tr : transactions){
            if(tr != null && tr.getAmount() == amount) {
                result[index] = tr;
                index++;
            }
        }
        return result;
    }

    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) throws Exception{
        if(dateOfCurTransaction == null)
            throw new BadRequestException("dateOfCurTransaction can't null");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for(Transaction transaction : transactions){
            if(transaction != null){
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);
                if(trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for(Transaction transaction : transactions){
            if(transaction != null){
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);
                if(trMonth == month && trDay == day){
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }
}
