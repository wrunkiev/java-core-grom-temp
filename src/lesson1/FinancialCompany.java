package lesson1;

import lesson9.Company;

public class FinancialCompany extends Company {

    public FinancialCompany(String name, String countryFounded) {
        super(name, countryFounded);
    }

    void demonstrateProtected(){
        System.out.println(this.code);

    }


}
