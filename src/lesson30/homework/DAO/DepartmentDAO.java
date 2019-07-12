package lesson30.homework.DAO;

import lesson30.homework.Department;
import lesson30.homework.DepartmentType;
import lesson30.homework.Employee;
import lesson30.homework.Exception.DepartmentBadException;
import lesson30.homework.Exception.InternalServerException;
import lesson30.homework.Position;
import java.util.ArrayList;

public class DepartmentDAO {

    private static Department departmentDev = new Department(DepartmentType.DEVELOPERS, setEmployeesDev());
    private static Department departmentDes = new Department(DepartmentType.DESIGNERS, setEmployeesDes());
    private static Department departmentAnalyst = new Department(DepartmentType.ANALYSTS, setEmployees(Position.ANALYST));
    private static Department departmentMan = new Department(DepartmentType.MANAGERS, setEmployees(Position.MANAGER));
    private static Department departmentFin = new Department(DepartmentType.FINANCIERS, setEmployees(Position.FINANCE));

    private static ArrayList<Department> departments = new ArrayList<>();

    private static void setDepartments(){
        departments.add(departmentDev);
        departments.add(departmentDes);
        departments.add(departmentAnalyst);
        departments.add(departmentMan);
        departments.add(departmentFin);
    }

    private static ArrayList<Employee> setEmployeesDev(){
        ArrayList<Employee> employeesDev = new ArrayList<>();
        try{
            employeesDev.addAll(EmployeeDAO.getEmployeesByPosition(Position.TEAM_LEAD));
            employeesDev.addAll(EmployeeDAO.getEmployeesByPosition(Position.DEVELOPER));
        }catch (Exception e){
            System.out.println(e.getMessage());
       }
        return employeesDev;
    }

    private static ArrayList<Employee> setEmployeesDes(){
        ArrayList<Employee> employeesDes = new ArrayList<>();
        try{
            employeesDes.addAll(EmployeeDAO.getEmployeesByPosition(Position.LEAD_DESIGNER));
            employeesDes.addAll(EmployeeDAO.getEmployeesByPosition(Position.DESIGNER));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return employeesDes;
    }

    private static ArrayList<Employee> setEmployees(Position position){
        ArrayList<Employee> employees = new ArrayList<>();
        try{
            employees.addAll(EmployeeDAO.getEmployeesByPosition(position));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return employees;
    }

    public static Department getDepartmentByType(DepartmentType type)throws Exception{
        if(type == null)
            throw new DepartmentBadException("Type of department can't be null!!!");

        setDepartments();

        for(Department d : departments){
            if(d != null && d.getType() != null && d.getType().equals(type)){
                return d;
            }
        }
        throw new InternalServerException("Can't get department by type");
    }

    public static ArrayList<Department> getDepartments(){
        setDepartments();
        return departments;
    }
}
