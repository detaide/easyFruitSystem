package ssm.pojo;

public class Order {
    String id;

    String username;

    Integer status;

    String detail;

    String time;

    String money;

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", detail='" + detail + '\'' +
                ", time='" + time + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Order(String id, String username, Integer status, String detail, String time, String money) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.detail = detail;
        this.time = time;
        this.money = money;
    }

    public Order() {
    }
}
