package FunctionLayer;

import java.util.ArrayList;



public class CalculateItemList {
    
    // Calculates the carport price
    public static int calcTotalPrice(ArrayList<Item> itemList){
        int totalPrice = 0;
        for(Item i: itemList){
            totalPrice += i.getAmount() * i.getPrice();
        }
        return totalPrice;
    }
    
    public static ArrayList<Item> makeItemList(Order o) throws LoginSampleException{
        ArrayList<Item> itemList = new ArrayList();
        
        itemList.add(calcPoles(o));
        itemList.add(calcRafts(o));
        itemList.add(calcBracketsLeft(o));
        itemList.add(calcBracketsRight(o));
        itemList.add(calcBracketsScrews(o));
        
        return itemList;
    }
    
    // Calculates the number of poles(stolper)
    public static Item calcPoles(Order o) throws LoginSampleException{
        Item item = LogicFacade.getItem(1);
        int amount = (1 + ((o.getLength() - 60) / 200)) * 2;
        item.setAmount(amount);
        return item;
    }
    
    // Calculates the number of rafts(spær)
    public static Item calcRafts(Order o) throws LoginSampleException{
        Item item = LogicFacade.getItem(5);
        int amount = 1 + ((o.getLength() - 60) / 50);
        item.setAmount(amount);
        return item;
    }
    
    // Calculates the number of left brackets(beslag)
    public static Item calcBracketsLeft(Order o) throws LoginSampleException{
        Item item = LogicFacade.getItem(10);
        int amount = 1 + ((o.getLength() - 60) / 50);
        item.setAmount(amount);
        return item;
    }
    
    // Calculates the number of right brackets(beslag)
    public static Item calcBracketsRight(Order o) throws LoginSampleException{
        Item item = LogicFacade.getItem(11);
        int amount = 1 + ((o.getLength() - 60) / 50);
        item.setAmount(amount);
        return item;
    }
    
    // Calculates the number of screws for the brackets
    public static Item calcBracketsScrews(Order o) throws LoginSampleException{
        Item item = LogicFacade.getItem(13);
        int amount = (((1 + ((o.getLength() - 60) / 50)) * 20) / 250) + 1;
        item.setAmount(amount);
        return item;
    }
}
