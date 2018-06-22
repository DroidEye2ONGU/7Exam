package Moudle;

public class User {
    private String ID;
    private String pass;
    private String name;
    private String sex;
    private String age;
    private String mail;

    public User() {
    }

    public User(String ID, String pass, String name, String sex, String age, String mail) {
        this.ID = ID;
        this.pass = pass;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.mail = mail;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
