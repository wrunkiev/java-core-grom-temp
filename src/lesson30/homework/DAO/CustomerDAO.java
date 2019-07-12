package lesson30.homework.DAO;

import lesson30.homework.Customer;
import lesson30.homework.Exception.CustomerBadException;
import lesson30.homework.Exception.InternalServerException;

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
            throw new CustomerBadException("Name of customer can't be null or empty!!!");
        setCustomers();

        for (Customer c : customers){
            if(c != null && c.getName() != null &&  c.getName().equals(name)){
                return c;
            }
        }
        throw new InternalServerException("Can't get customer by name!!!");
    }

    public static Customer getCustomerByCountry(String countryName)throws Exception{
        if(countryName == null || countryName.equals(""))
            throw new CustomerBadException("Name of country of customer can't be null or empty!!!");
        setCustomers();

        for (Customer c : customers){
            if(c != null && c.getCountry() != null &&  c.getCountry().equals(countryName)){
                return c;
            }
        }
        throw new InternalServerException("Can't get customer by countryName!!!");
    }

    public static Customer getCustomerByMonthlyPay(int monthlyPay)throws Exception{
        setCustomers();

        for (Customer c : customers){
            if(c != null && c.getMonthlyPay() == monthlyPay){
                return c;
            }
        }
        throw new InternalServerException("Can't get customer by monthlyPay!!!");
    }

    public static ArrayList<Customer> getCustomers(){
        setCustomers();
        return customers;
    }
}
