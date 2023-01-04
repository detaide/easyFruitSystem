package ssm.pojo;

public class Login {

    private String username;

    private String password;

    private String registerTime;

    private String loginTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", loginTime='" + loginTime + '\'' +
                '}';
    }

    public Login(String username, String password, String registerTime, String loginTime) {
        this.username = username;
        this.password = password;
        this.registerTime = registerTime;
        this.loginTime = loginTime;
    }

    public Login() {
    }
}
