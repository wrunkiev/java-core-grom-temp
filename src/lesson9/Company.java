package lesson9;

public class Company {
    protected String name;
    protected String countryFounded;

    protected String code;
    public int someField;

    public Company(String name, String countryFounded) {
        this.name = name;
        this.countryFounded = countryFounded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryFounded() {
        return countryFounded;
    }

    public void setCountryFounded(String countryFounded) {
        this.countryFounded = countryFounded;
    }
}