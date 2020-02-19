package by.pavelpavlenko.trainingcenter.entity;

public class User extends Entity{
    private int id;
    private String login;
    private String password;
    private RoleType role;


    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public User(int id, String login, String password, RoleType role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String login, String password, RoleType role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

}