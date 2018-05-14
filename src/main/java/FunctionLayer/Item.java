/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.Comparator;

/**
 *
 * @author Mads
 */
public class Item {
    
    private int itemid;
    private String name;
    private int length;
    private int amount;
    private String unit;
    private String description;
    private int price;

    public Item(int itemid, String name, String unit, int price, String description) {
        this.itemid = itemid;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.description = description;
    }

    public Item(String name, int length, int amount, String unit, String description) {
        this.name = name;
        this.length = length;
        this.amount = amount;
        this.unit = unit;
        this.description = description;
    }
    public Item(String name, int amount, String unit, String description) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    
    
    
}
