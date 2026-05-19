package user;

public class User {

    private String name;
    private String email;
    private String password;
    private String avatarLink;

    public User(String name, String email, String password, String avatarLink) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.avatarLink = avatarLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

}
