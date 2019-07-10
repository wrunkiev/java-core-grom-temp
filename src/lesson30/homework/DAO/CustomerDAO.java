package lesson30.homework.DAO;

import lesson30.homework.Customer;

import java.util.ArrayList;

public class CustomerDAO {
    private static Customer customerUSA = new Customer("Denis", "USA", 100000);
    private static Customer customerUA = new Customer("Arkadiy", "Ukraine", 75000);
    private static Customer customerSweden = new Customer("Andrey", "Sweden", 235000);

    private static ArrayList<Customer> customers = new ArrayList<>();

    private static void setCustomers(){
        customers.add(customerUSA);
        customers.add(customerUA);
        customers.add(customerSweden);
    }

    public static Customer getCustomerByName(String name)throws Exception{
        if(name == null || name.equals(""))
            throw new Exception("Имя клиента не указано!!!");
        setCustomers();

        for (Customer c : customers){
            if(c != null && c.getName() != null &&  c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public static Customer getCustomerByCountry(String countryName)throws Exception{
        if(countryName == null || countryName.equals(""))
            throw new Exception("Имя страны не указано!!!");
        setCustomers();

        for (Customer c : customers){
            if(c != null && c.getCountry() != null &&  c.getCountry().equals(countryName)){
                return c;
            }
        }
        return null;
    }

    public static Customer getCustomerByMonthlyPay(int monthlyPay){
        setCustomers();

        for (Customer c : customers){
            if(c != null && c.getMonthlyPay() == monthlyPay){
                return c;
            }
        }
        return null;
    }

    public static ArrayList<Customer> getCustomers(){
        setCustomers();
        return customers;
    }
}
