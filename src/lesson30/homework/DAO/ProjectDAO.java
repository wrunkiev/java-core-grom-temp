package lesson30.homework.DAO;

import lesson30.homework.Customer;
import lesson30.homework.Exception.InternalServerException;
import lesson30.homework.Exception.ProjectBadException;
import lesson30.homework.Project;

import java.util.ArrayList;

public class ProjectDAO {

    private static Project project1 = new Project("Simple", setCustomer("Denis"));
    private static Project project2 = new Project("Multilevel", setCustomer("Arkadiy"));
    private static Project project3 = new Project("Complex", setCustomer("Andrey"));

    private static ArrayList<Project> projects = new ArrayList<>();

    private static void setProjects(){
        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
    }

    private static Customer setCustomer(String name){
        Customer customer = null;
        try{
            customer = CustomerDAO.getCustomerByName(name);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return customer;
    }

    public static Project getProjectByName(String name)throws Exception{
        if(name == null || name.equals(""))
            throw new ProjectBadException("Name of project can't be null or empty!!!");

        setProjects();

        for(Project p : projects){
            if(p != null && p.getName() != null && p.getName().equals(name)){
                return p;
            }
        }
        throw new InternalServerException("Can't get project by name of project");
    }

    public static ArrayList<Project> getProjectsByCustomer(Customer customer)throws Exception{
        if(customer == null)
            throw new ProjectBadException("Customer can't be null for to get list of projects by customer!!!");

        ArrayList<Project> resProjects = new ArrayList<>();

        setProjects();

        for(Project p : projects){
            if(p != null && p.getCustomer() != null && p.getCustomer().equals(customer)){
                resProjects.add(p);
            }
        }
        return resProjects;
    }

    public static ArrayList<Project> getProjects(){
        setProjects();
        return projects;
    }
}
