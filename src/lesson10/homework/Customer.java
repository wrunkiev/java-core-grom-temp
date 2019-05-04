package lesson10.homework;

public class Customer {
    private String name;
    private String city;
    private String gender;

    //constructor
    public Customer(String name, String city, String gender) {
        this.name = name;
        this.city = city;
        this.gender = gender;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getGender() {
        return gender;
    }
}
