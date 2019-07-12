package lesson30.homework.DAO;

import lesson30.homework.*;
import lesson30.homework.Exception.EmployeeBadException;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeDAO {

    private static Employee employeeTeamLead = new Employee("Sergey", "Potap", null, Position.TEAM_LEAD, setDepartment(DepartmentType.DEVELOPERS), setProjects());
    private static Employee employeeDev1 = new Employee("Denis", "Green", null, Position.DEVELOPER, setDepartment(DepartmentType.DEVELOPERS), setProjects1());
    private static Employee employeeDev2 = new Employee("Kiril", "Hlopko", null, Position.DEVELOPER, setDepartment(DepartmentType.DEVELOPERS), setProjects2());
    private static Employee employeeDev3 = new Employee("Arkadiy", "Murka", null, Position.DEVELOPER, setDepartment(DepartmentType.DEVELOPERS), setProjects3());
    private static Employee employeeFin = new Employee("Harold", "Pink", null, Position.FINANCE, setDepartment(DepartmentType.FINANCIERS), setProjects());
    private static Employee employeeAnalyst = new Employee("Evgen", "Ribak", null, Position.ANALYST, setDepartment(DepartmentType.ANALYSTS), setProjects());
    private static Employee employeeMan = new Employee("Artem", "Grey", null, Position.MANAGER, setDepartment(DepartmentType.MANAGERS), setProjects());
    private static Employee employeeDes1 = new Employee("Alex", "Black", null, Position.DESIGNER, setDepartment(DepartmentType.DESIGNERS), setProjects1());
    private static Employee employeeDes2 = new Employee("Andrey", "Kirka", null, Position.DESIGNER, setDepartment(DepartmentType.DESIGNERS), setProjects2());
    private static Employee employeeLeadDes = new Employee("Pavel", "Volya", null, Position.LEAD_DESIGNER, setDepartment(DepartmentType.DESIGNERS), setProjects());

    private static ArrayList<Employee> employees = new ArrayList<>();

    private static void setEmployees(){
        employees.add(employeeTeamLead);
        employees.add(employeeDev1);
        employees.add(employeeDev2);
        employees.add(employeeDev3);
        employees.add(employeeFin);
        employees.add(employeeAnalyst);
        employees.add(employeeMan);
        employees.add(employeeDes1);
        employees.add(employeeDes2);
        employees.add(employeeLeadDes);
    }

    private static Department setDepartment(DepartmentType departmentType){
        Department department = null;
        try{
            department = DepartmentDAO.getDepartmentByType(departmentType);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return department;
    }

    private static ArrayList<Project> setProjects(){
        ArrayList<Project> projects = new ArrayList<>();
        try{
            projects.add(ProjectDAO.getProjectByName("Simple"));
            projects.add(ProjectDAO.getProjectByName("Multilevel"));
            projects.add(ProjectDAO.getProjectByName("Complex"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return projects;
    }

    private static ArrayList<Project> setProjects1(){
        ArrayList<Project> projects = new ArrayList<>();
        try{
            projects.add(ProjectDAO.getProjectByName("Simple"));
            projects.add(ProjectDAO.getProjectByName("Multilevel"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return projects;
    }

    private static ArrayList<Project> setProjects2(){
        ArrayList<Project> projects = new ArrayList<>();
        try{
            projects.add(ProjectDAO.getProjectByName("Multilevel"));
            projects.add(ProjectDAO.getProjectByName("Complex"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return projects;
    }

    private static ArrayList<Project> setProjects3(){
        ArrayList<Project> projects = new ArrayList<>();
        try{
            projects.add(ProjectDAO.getProjectByName("Simple"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return projects;
    }

    public static ArrayList<Employee> getEmployeesByFirstName(String firstName)throws Exception{
        if(firstName == null || firstName.equals(""))
            throw new EmployeeBadException("Name of employee can't be null or empty!!!");
        ArrayList<Employee> result = new ArrayList<>();

        setEmployees();

        for(Employee e : employees){
            if(e != null && e.getFirstName() != null && e.getFirstName().equals(firstName)){
                result.add(e);
            }
        }
        return result;
    }

    public static ArrayList<Employee> getEmployeesByLastName(String lastName)throws Exception{
        if(lastName == null || lastName.equals(""))
            throw new EmployeeBadException("Last Name of employee can't be null or empty!!!");

        ArrayList<Employee> result = new ArrayList<>();

        setEmployees();

        for(Employee e : employees){
            if(e != null && e.getLastName() != null && e.getLastName().equals(lastName)){
               result.add(e);
            }
        }
        return result;
    }

    public static ArrayList<Employee> getEmployeesByDateHired(Date dateHired)throws Exception{
        if(dateHired == null)
            throw new EmployeeBadException("Date of hired of employee can't be null!!!");

        ArrayList<Employee> result = new ArrayList<>();

        setEmployees();

        for(Employee e : employees){
            if(e != null && e.getDateHired() != null && e.getDateHired().equals(dateHired)){
                result.add(e);
            }
        }
        return result;
    }

    public static ArrayList<Employee> getEmployeesByPosition(Position position)throws Exception{
        if(position == null)
            throw new EmployeeBadException("Position of employee can't be null!!!");

        ArrayList<Employee> result = new ArrayList<>();

        setEmployees();

        for(Employee e : employees){
            if(e != null && e.getPosition() != null && e.getPosition().equals(position)){
                result.add(e);
            }
        }
        return result;
    }

    public static ArrayList<Employee> getAll(){
        setEmployees();
        return employees;
    }
}
