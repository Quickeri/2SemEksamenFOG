package FunctionLayer;

import java.util.ArrayList;

public class Order {
   
    private int orderid;
    private String name;
    private String email;
    private int customerid;
    private int carportid;
    private int length;
    private int width;
    private int height;
    private int totalPrice;
    private String date;
    private ArrayList<Item> itemlist;

    public Order(int orderid, ArrayList<Item> itemlist) {
        this.orderid = orderid;
        this.itemlist = itemlist;
    }

    public Order(int orderid, int customerid, int length, int width, int height, int totalPrice, String date, ArrayList<Item> itemlist) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.length = length;
        this.width = width;
        this.height = height;
        this.totalPrice = totalPrice;
        this.date = date;
        this.itemlist = itemlist;
    }

    public Order(int orderid, String name, String email, int customerid, int length, int width, int height, String date) {
        this.orderid = orderid;
        this.name = name;
        this.email = email;
        this.customerid = customerid;
        this.length = length;
        this.width = width;
        this.height = height;
        this.date = date;
    }

    
    public Order(int customerid, int length, int width, int height, String date) {
        this.customerid = customerid;
        this.length = length;
        this.width = width;
        this.height = height;
        this.date = date;
    }
    public Order(int orderid, int length, int width, int height) {
        this.orderid = orderid;
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    public Order(int orderid, int customerid, int length, int width, int height, String date) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.length = length;
        this.width = width;
        this.height = height;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Item> getItemlist() {
        return itemlist;
    }

    public void setItemlist(ArrayList<Item> itemlist) {
        this.itemlist = itemlist;
    }

    
    
}
