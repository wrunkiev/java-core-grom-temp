package lesson30.homework.DAO;

import lesson30.homework.Firm;

public class FirmDAO {
    public static Firm getFirm(){
        return new Firm(null, DepartmentDAO.getDepartments(), CustomerDAO.getCustomers());
    }
}
