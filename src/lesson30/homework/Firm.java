package lesson30.homework;

import java.util.Collection;
import java.util.Date;

public class Firm {
    private Date dateFounded;
    private Collection departments;
    private Collection customers;

    public Firm(Date dateFounded, Collection departments, Collection customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public Collection getDepartments() {
        return departments;
    }

    public Collection getCustomers() {
        return customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Firm firm = (Firm) o;

        if (!dateFounded.equals(firm.dateFounded)) return false;
        if (!departments.equals(firm.departments)) return false;
        return customers.equals(firm.customers);
    }

    @Override
    public int hashCode() {
        int result = dateFounded.hashCode();
        result = 31 * result + departments.hashCode();
        result = 31 * result + customers.hashCode();
        return result;
    }
}
