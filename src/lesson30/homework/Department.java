package lesson30.homework;

import java.util.Collection;

public class Department {
    private DepartmentType type;
    private Collection employees;

    public Department(DepartmentType type, Collection employees) {
        this.type = type;
        this.employees = employees;
    }

    public DepartmentType getType() {
        return type;
    }

    public Collection getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (type != that.type) return false;
        return employees.equals(that.employees);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + employees.hashCode();
        return result;
    }
}
