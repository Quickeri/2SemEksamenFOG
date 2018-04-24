package FunctionLayer;

public class Order {
    
    private int orderid;
    private int customerid;
    private int carportid;
    private int length;
    private int width;
    private int height;

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

    public int getCarportid() {
        return carportid;
    }

    public void setCarportid(int carportid) {
        this.carportid = carportid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
}
