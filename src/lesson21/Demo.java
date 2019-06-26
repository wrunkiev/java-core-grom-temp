package lesson21;


import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception{
        Company company = new Company(100, "Nokia");
        //call of method by class
        Company.setLicense("GTP999");

        System.out.println(company.getLicense());

        Company company1 = new Company(9, "Test");

        System.out.println(company1.getLicense());

        Company.setLicense("TTT11");

        System.out.println(company.getLicense());
        System.out.println(company1.getLicense());

        //Company.validate();

        //demo utils
        int min = ArrayUtils.minElement(new int[]{1, 10,40});

    }
}
