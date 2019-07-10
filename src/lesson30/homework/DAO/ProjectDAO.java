package lesson30.homework.DAO;

import lesson30.homework.Customer;
import lesson30.homework.Project;

import java.util.ArrayList;

public class ProjectDAO {

    private static Customer setCustomer(String name){
        Customer customer = null;
        try{
            customer = CustomerDAO.getCustomerByName(name);
        }catch (Exception e){
            e.getMessage();
        }
        return customer;
    }

    private static Project project1 = new Project("Simple", setCustomer("Denis"));
    private static Project project2 = new Project("Multilevel", setCustomer("Arkadiy"));
    private static Project project3 = new Project("Complex", setCustomer("Andrey"));

    private static ArrayList<Project> projects = new ArrayList<>();

    private static void setProjects(){
        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
    }

    public static Project getProjectByName(String name)throws Exception{
        if(name == null || name.equals(""))
            throw new Exception("Не указано имя проекта!!!");

        setProjects();

        for(Project p : projects){
            if(p != null && p.getName() != null && p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public static Project getProjectByCustomer(Customer customer)throws Exception{
        if(customer == null)
            throw new Exception("Не указан заказчик!!!");
        setProjects();
        for(Project p : projects){
            if(p != null && p.getCustomer() != null && p.getCustomer().equals(customer)){
                return p;
            }
        }
        return null;
    }

    public static ArrayList<Project> getProjects(){
        setProjects();
        return projects;
    }






}
