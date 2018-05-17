/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;

/**
 *
 * @author Mads
 */
public class ItemList {
    
    private int orderid;
    private int itemid;
    private int amount;
    private int price;
    private List<Item> items;

    public ItemList(int orderid, int itemid, int amount, int price) {
        this.orderid = orderid;
        this.itemid = itemid;
        this.amount = amount;
        this.price = price;
    }

    public ItemList(int orderid, int itemid, int amount, int price, List<Item> items) {
        this.orderid = orderid;
        this.itemid = itemid;
        this.amount = amount;
        this.price = price;
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
