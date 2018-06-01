package FunctionLayer;

import DBAccess.DBFacade;
import java.util.ArrayList;

public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return DBFacade.login( email, password );
    } 

    public static User createUser( String name, String email, String password ) throws LoginSampleException {
        User user = new User( name, email, password, "customer" );
        DBFacade.createUser( user );
        return user;
    }
    public static User updateUser( User user ) throws LoginSampleException {
        DBFacade.updateUser( user );
        return user;
    }
    public static Order createOrder( int customerid, int length, int width, int height, String date ) throws LoginSampleException {
        Order o = new Order( customerid, length, width, height, date );
        Order order = DBFacade.createOrder( o );
        return order;
    }
    public static boolean updateOrder( Order o ) throws LoginSampleException {
        return DBFacade.updateOrder( o );   
    }
    public static boolean deleteOrder( int orderid ){
        return DBFacade.deleteOrder( orderid );
    }
    public static Order getOrder( int orderid ) throws LoginSampleException{
        Order order = DBFacade.getOrder( orderid );
        return order;
    }
    public static ArrayList<Order> getOrders( int userid ) throws LoginSampleException{
        ArrayList<Order> orders = DBFacade.getOrders( userid );
        return orders;
    }
    public static int countOrders() throws LoginSampleException {
        return DBFacade.countOrders();
    }
    public static int countItems() throws LoginSampleException {
        return DBFacade.countItems();
    }
    public static void createItemList(Order o, ArrayList<Item> item) throws LoginSampleException{
        DBFacade.createItemList(o, item);
    }
    public static ArrayList<Item> makeItemList(Order o) throws LoginSampleException{
        ArrayList<Item> itemList = CalculateItemList.makeItemList(o);
        return itemList;
    }
    public static int calcTotalPrice(ArrayList<Item> itemList) throws LoginSampleException{
        int totalPrice = CalculateItemList.calcTotalPrice(itemList);
        return totalPrice;
    }
    public static ArrayList<Item> getItemList(int orderid) throws LoginSampleException{
        ArrayList<Item> itemList = DBFacade.getItemList(orderid);
        return itemList;
    }
    public static void deleteItemList(int orderid) throws LoginSampleException{
        DBFacade.deleteItemList(orderid);
    }
    public static ArrayList<Order> getAllOrdersByOrderid(int page) throws LoginSampleException{
        ArrayList<Order> orders = DBFacade.getAllOrdersByOrderid(page);
        return orders;
    }
    public static ArrayList<Order> getAllOrdersByCustomerid(int page) throws LoginSampleException{
        ArrayList<Order> orders = DBFacade.getAllOrdersByCustomerid(page);
        return orders;
    }
    public static ArrayList<Order> getAllOrdersByName(int page) throws LoginSampleException{
        ArrayList<Order> orders = DBFacade.getAllOrdersByName(page);
        return orders;
    }
    public static ArrayList<Order> getAllOrdersByDate(int page) throws LoginSampleException{
        ArrayList<Order> orders = DBFacade.getAllOrdersByDate(page);
        return orders;
    }
    public static Item getItem( int itemid ) throws LoginSampleException{
        Item item = DBFacade.getItem( itemid );
        return item;
    }
    public static boolean updateItem( Item i ) throws LoginSampleException {
        return DBFacade.updateItem( i );   
    }
    public static ArrayList<Item> getAllItemsByID(int page) throws LoginSampleException{
        ArrayList<Item> items = DBFacade.getAllItemsByID(page);
        return items;
    }
    public static ArrayList<Item> getAllItemsByName(int page) throws LoginSampleException{
        ArrayList<Item> items = DBFacade.getAllItemsByName(page);
        return items;
    }
    public static ArrayList<Item> getAllItemsByUnit(int page) throws LoginSampleException{
        ArrayList<Item> items = DBFacade.getAllItemsByUnit(page);
        return items;
    }
    public static ArrayList<Item> getAllItemsByPrice(int page) throws LoginSampleException{
        ArrayList<Item> items = DBFacade.getAllItemsByPrice(page);
        return items;
    }
}
