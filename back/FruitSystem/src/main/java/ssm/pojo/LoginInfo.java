package ssm.pojo;

public class LoginInfo {

    @Override
    public String toString() {
        return "LoginInfo{" +
                "username='" + username + '\'' +
                ", userId='" + userId + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", context='" + context + '\'' +
                ", email='" + email + '\'' +
                ", money='" + money + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public LoginInfo(String username, String userId, String gender, Integer age, String phone, String context, String email, String money, String birthday) {
        this.username = username;
        this.userId = userId;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.context = context;
        this.email = email;
        this.money = money;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
    private String userId;

    private String gender;

    private Integer age;

    private String phone;

    private String context;

    private String email;

    private String money;

    private String birthday;

    public LoginInfo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public LoginInfo(String userId, String gender, Integer age, String phone, String context, String email, String money, String birthday) {
        this.userId = userId;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.context = context;
        this.email = email;
        this.money = money;
        this.birthday = birthday;
    }

}
