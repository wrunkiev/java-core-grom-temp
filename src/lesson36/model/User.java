package lesson36.model;

public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User(long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userName.equals(user.userName)) return false;
        if (!password.equals(user.password)) return false;
        if (!country.equals(user.country)) return false;
        return userType == user.userType;
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + userType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return id +
                ", " + userName +
                ", " + password +
                ", " + country +
                ", " + userType;
    }


}
