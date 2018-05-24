/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;



/**
 *
 * @author Mads
 */
public class CalculateItemList {
    
    LogicFacade lf = new LogicFacade();
    
    public ArrayList<Item> makeStykliste(Order o){
//        ItemList itemList = new ItemList();
        ArrayList<Item> itemList = new ArrayList();
//        ArrayList<Item> stykliste = new ArrayList();
        
        int antalStolper = (o.getLength()/200 * 2) + (o.getWidth()/200); 
        int antalPlastmo = o.getLength()/(360-20);
        int spærLængde = 600;
        if (o.getWidth() < 480){
            spærLængde = 480;
        }
        itemList.add(new Item("97x97 mm. trykimp. Stolpe", 300, antalStolper, "stk", "Stolper nedgraves 90cm i jord"));
        itemList.add(new Item("45x195 mm. spærtræ ubh.", 600, 2, "stk", "Remme i sider, sadles ned i stolper"));
        itemList.add(new Item("45x195 mm. spærtræ ubh.", spærLængde, o.getLength()/55, "stk", "Monteres på rem"));
        itemList.add(new Item("Plastmo Ecolite blåtonet", 360, antalPlastmo, "stk", "Monteres på spær"));
        itemList.add(new Item("Universalbeslag 190mm venstre", o.getLength()/55, "stk", "Til montering af spær på rem"));
        itemList.add(new Item("Universalbeslag 190mm højre", o.getLength()/55, "stk", "Til montering af spær på rem"));
        
//        itemList.setItems(stykliste);
        
        return itemList;
    }
    public int calcTotalPrice(ArrayList<Item> itemList){
        int totalPrice = 0;
        for(Item i: itemList){
            totalPrice += i.getAmount() * i.getPrice();
        }
        return totalPrice;
    }
    // 
    public ArrayList<Item> makeItemList(Order o) throws LoginSampleException{
        ArrayList<Item> itemList = new ArrayList();
        
        itemList.add(calcPoles(o));
        itemList.add(calcRafts(o));
        itemList.add(calcBracketsLeft(o));
        itemList.add(calcBracketsRight(o));
        itemList.add(calcBracketsScrews(o));
        
        return itemList;
    }
    
    // Calculates the number of poles(stolper)
    public Item calcPoles(Order o) throws LoginSampleException{
        Item item = lf.getItem(1);
        int amount = (1 + ((o.getLength() - 60) / 200)) * 2;
        item.setAmount(amount);
        return item;
    }
    
    // Calculates the number of rafts(spær)
    public Item calcRafts(Order o) throws LoginSampleException{
        Item item = lf.getItem(5);
        int amount = 1 + ((o.getLength() - 60) / 50);
        item.setAmount(amount);
        return item;
    }
    
    // Calculates the number of left brackets(beslag)
    public Item calcBracketsLeft(Order o) throws LoginSampleException{
        Item item = lf.getItem(10);
        int amount = 1 + ((o.getLength() - 60) / 50);
        item.setAmount(amount);
        return item;
    }
    
    // Calculates the number of right brackets(beslag)
    public Item calcBracketsRight(Order o) throws LoginSampleException{
        Item item = lf.getItem(11);
        int amount = 1 + ((o.getLength() - 60) / 50);
        item.setAmount(amount);
        return item;
    }
    
    // Calculates the number of screws for the brackets
    public Item calcBracketsScrews(Order o) throws LoginSampleException{
        Item item = lf.getItem(13);
        int amount = (((1 + ((o.getLength() - 60) / 50)) * 20) / 250) + 1;
        item.setAmount(amount);
        return item;
    }
}
