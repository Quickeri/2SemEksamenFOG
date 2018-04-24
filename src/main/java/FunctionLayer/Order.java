package FunctionLayer;

public class Order {
    
    private int orderid;
    private int userid;
    private int length;
    private int width;
    private int height;

    public Order(int orderid, int userid, int length, int width, int height) {
        this.orderid = orderid;
        this.userid = userid;
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

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
