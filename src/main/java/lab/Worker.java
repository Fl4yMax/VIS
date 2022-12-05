package lab;

public class Worker {

    private String firstName;
    private String lastName;
    private String rank;
    private String phone_number;
    private String address;
    private String hashPassword;
    private String username;

    Worker(String firstName, String lastName, String rank)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rank = rank;
    }

    public String getRank()
    {
        return this.rank;
    }
}
