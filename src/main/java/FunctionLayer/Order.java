package FunctionLayer;

public class Order {

    //                Order o = new Order(orderid, name, email, carportid, length, width, height, customerid);

    
    private int orderid;
    private String name;
    private String email;
    private int customerid;
    private int carportid;
    private int length;
    private int width;
    private int height;

    public Order(int orderid, String name, String email, int customerid, int carportid, int length, int width, int height) {
        this.orderid = orderid;
        this.name = name;
        this.email = email;
        this.customerid = customerid;
        this.carportid = carportid;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Order(int orderid, int customerid, int carportid, int length, int width, int height) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.carportid = carportid;
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    public Order(int orderid, int customerid, int length, int width, int height) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Order(int orderid, int length, int width, int height) {
        this.orderid = orderid;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getOrderid() {
        return orderid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getCustomerid() {
        return customerid;
    }

    public int getCarportid() {
        return carportid;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public void setCarportid(int carportid) {
        this.carportid = carportid;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    
    
}
