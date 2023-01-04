package ssm.pojo;

public class Address {
    Integer id;

    String address;

    Integer status;

    public Address() {
    }

    public Address(Integer id, String address, Integer status) {
        this.id = id;
        this.address = address;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
