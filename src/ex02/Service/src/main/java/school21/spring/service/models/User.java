package school21.spring.service.models;

public class User {

    private Long id;
    private String mail;
    private String password;

    public User() {
    }

    public User(long id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                '}';
    }
}
