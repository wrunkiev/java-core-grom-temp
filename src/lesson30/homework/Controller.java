package lesson30.homework;

import lesson30.homework.DAO.EmployeeDAO;

import java.util.ArrayList;

public class Controller {
    public ArrayList<Employee> employeesByProject(String projectName)throws Exception{
        if(projectName == null || projectName.equals(""))
            throw  new Exception("Имя проекта не заполнено");

        ArrayList<Employee> employees = new ArrayList<>();
        for(Employee empl : EmployeeDAO.getAll()){
            if(empl != null && empl.getProjects()){

            }
        }




        return employees;
    }



}
