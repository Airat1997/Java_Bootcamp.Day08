package school21.spring.service.models;

public class User {

    private Long id;
    private String mail;

    public User() {
    }

    public User(long id, String mail) {
        this.id = id;
        this.mail = mail;
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
