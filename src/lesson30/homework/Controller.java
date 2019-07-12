package lesson30.homework;

import lesson30.homework.DAO.DepartmentDAO;
import lesson30.homework.DAO.EmployeeDAO;
import lesson30.homework.DAO.ProjectDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Controller {
    @SuppressWarnings("unchecked")
    public static ArrayList<Employee> employeesByProject(String projectName)throws Exception{
        //список сотрудников, работающих над заданным проектом
        if(projectName == null || projectName.equals(""))
            throw new Exception("Name of Project can't be null!!!");

        ArrayList<Employee> employees = new ArrayList<>();

        for(Employee e : EmployeeDAO.getAll()){
            if(e != null){
                for(Project p : (ArrayList<Project>) e.getProjects()){
                    if(p != null && p.getName() != null && p.getName().equals(projectName) && !employees.contains(e)){
                        employees.add(e);
                    }
                }
            }
        }
        return employees;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Project> projectsByEmployee(Employee employee)throws Exception{
        //список проектов, в которых участвует заданный сотрудник
        if(employee == null)
            throw new Exception("Employee can't be null!!!");

        return (ArrayList<Project>) employee.getProjects();
    }

    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType)throws Exception{
        //список сотрудников из заданного отдела, не участвующих ни в одном проекте
        if(departmentType == null)
            throw new Exception("Type of Department can't be null!!!");

        ArrayList<Employee> employees = new ArrayList<>();

        for(Employee e : EmployeeDAO.getAll()){
            if(e != null
                    && e.getDepartment().getType() != null
                    && e.getDepartment().getType().equals(departmentType)
                    && e.getProjects() == null
                    && !employees.contains(e)){
                employees.add(e);
            }
        }
        return employees;
    }

    public static ArrayList<Employee> employeesWithoutProject(){
        //список сотрудников, не участвующих ни в одном проекте
        ArrayList<Employee> employees = new ArrayList<>();

        for(Employee e : EmployeeDAO.getAll()){
            if(e != null && e.getProjects() == null && !employees.contains(e)){
                employees.add(e);
            }
        }
        return employees;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Employee> employeesByTeamLead(Employee lead)throws Exception{
        //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
        if(lead == null)
            throw new Exception("Lead can't be null!!!");

        ArrayList<Employee> employees = new ArrayList<>();

        for(Project p : (ArrayList<Project>) lead.getProjects()) {
            if (p != null) {
                for (Employee e : Controller.employeesByProject(p.getName())) {
                    if (e != null && !e.equals(lead) && e.getPosition().toString().contains("LEAD") && !employees.contains(e)) {
                        employees.add(e);
                    }
                }
            }
        }
        return employees;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
        if(employee == null)
            throw new Exception("Employee can't be null for teamLeadsByEmployee!!!");

         ArrayList<Employee> employees = new ArrayList<>();

        for (Project p : (ArrayList<Project>)employee.getProjects()){
            if(p != null){
                for(Employee e : Controller.employeesByProject(p.getName())){
                    if(e != null && e.getPosition() != null && e.getPosition().toString().contains("LEAD") && !employees.contains(e)){
                        employees.add(e);
                    }
                }
            }
        }
        return employees;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Employee> employeesByProjectEmployee(Employee employee)throws Exception{
        //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
        if(employee == null)
            throw new Exception("Employee can't be null for employeesByProjectEmployee!!!");

        ArrayList<Employee> employees = new ArrayList<>();

        for(Project p : (ArrayList<Project>)employee.getProjects()){
            if(p != null){
                for(Employee e : Controller.employeesByProject(p.getName())){
                    if(e != null && !e.equals(employee) && !employees.contains(e)){
                        employees.add(e);
                    }
                }
            }
        }
        return employees;
    }

    public static ArrayList<Project> projectsByCustomer(Customer customer)throws Exception{
        //список проектов, выполняемых для заданного заказчика
        if(customer == null)
            throw new Exception("Customer can't be null!!!");

        return ProjectDAO.getProjectsByCustomer(customer);
    }

    public static ArrayList<Employee> employeesByCustomerProjects(Customer customer)throws Exception{
        //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
        if(customer == null)
            throw new Exception("Customer can't be null for employeesByCustomerProjects!!!");

        ArrayList<Employee> employees = new ArrayList<>();

        for(Project p : Controller.projectsByCustomer(customer)){
            if(p != null){
                for(Employee e : employeesByProject(p.getName())){
                    if(e != null && !employees.contains(e)){
                        employees.add(e);
                    }
                }
            }
        }
        return employees;
    }
}
