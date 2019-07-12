package lesson30.homework;

public class Demo {
    public static void main(String[] args) {
        try{
             Customer customer1 = new Customer("Denis", "USA", 100000);
             Customer customer2 = new Customer("Arkadiy", "Ukraine", 75000);
             Customer customer3 = new Customer("Andrey", "Sweden", 235000);

            System.out.println(Controller.employeesByCustomerProjects(customer1));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
