package App;

import javafx.util.Pair;

public class Worker {

    private int worker_id;
    private String firstName;
    private String lastName;
    private String rank;
    private String phone_number;
    private String address;
    private String hashPassword;
    private String username;
    private String email;
    private int postal_code;

    public Worker(int worker_id, String firstName, String lastName, String rank, String phone_number, String email, String address, int postal_code, String password, String username)
    {
        this.worker_id = worker_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.rank = rank;
        this.username = username;
        this.hashPassword = password;
        this.postal_code = postal_code;
    }
    public Worker(String firstName, String lastName, String rank, String phone_number, String email, String address, int postal_code, String password, String username)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.rank = rank;
        this.username = username;
        this.hashPassword = password;
        this.postal_code = postal_code;
    }

    public int getId()
    {
        return this.worker_id;
    }
    public Pair<String, String> getCredentials()
    {
        return new Pair<>(this.username, this.hashPassword);
    }
    public String getFirstName()
    {
        return this.firstName;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public String getPassword()
    {
        return this.hashPassword;
    }
    public String getEmail()
    {
        return this.email;
    }
    public int getPostalCode()
    {
        return this.postal_code;
    }
    public String getAddress()
    {
        return this.address;
    }

    public String getPhone_number()
    {
        return this.phone_number;
    }
    public String getLogin()
    {
        return this.username;
    }
    public String getRank()
    {
        return this.rank;
    }
    public void setWorkerId(int id)
    {
        this.worker_id = id;
    }
}
