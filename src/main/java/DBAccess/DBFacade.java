package DBAccess;

import FunctionLayer.Item;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;

public class DBFacade {
    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( User user ) throws LoginSampleException {
        UserMapper.createUser( user );
        return user;
    }
    public static User updateUser( User user ) throws LoginSampleException {
        UserMapper.updateUser( user );
        return user;
    }
    public static Order createOrder( Order o) throws LoginSampleException {
        Order order = OrderMapper.createOrder( o );
        return order;
    }
    public static boolean updateOrder( Order o ) throws LoginSampleException {
        return OrderMapper.updateOrder( o );   
    }
    public static boolean deleteOrder( int orderid ){
        return OrderMapper.deleteOrder( orderid );
    }
    public static Order getOrder( int orderid ) throws LoginSampleException{
        Order order = OrderMapper.getOrder( orderid );
        return order;
    }
    public static ArrayList<Order> getOrders( int userid ) throws LoginSampleException{
        ArrayList<Order> orders = OrderMapper.getOrders( userid );
        return orders;
    }
    public static int countOrders() throws LoginSampleException {
        return OrderMapper.countOrders();
    }
    public static int countItems() throws LoginSampleException {
        return ItemMapper.countItems();
    }
    public static void createItemList(Order o, ArrayList<Item> item) throws LoginSampleException{
        ItemListMapper.createItemList(o, item);
    }
    public static ArrayList<Item> getItemList(int orderid) throws LoginSampleException{
        ArrayList<Item> itemList = ItemListMapper.getItemList(orderid);
        return itemList;
    }
    public static void deleteItemList(int orderid) throws LoginSampleException{
        ItemListMapper.deleteItemList(orderid);
    }
    public static ArrayList<Order> getAllOrdersByOrderid(int page) throws LoginSampleException{
        ArrayList<Order> orders = OrderMapper.getAllOrdersByOrderid(page);
        return orders;
    }
    public static ArrayList<Order> getAllOrdersByCustomerid(int page) throws LoginSampleException{
        ArrayList<Order> orders = OrderMapper.getAllOrdersByCustomerid(page);
        return orders;
    }
    public static ArrayList<Order> getAllOrdersByName(int page) throws LoginSampleException{
        ArrayList<Order> orders = OrderMapper.getAllOrdersByName(page);
        return orders;
    }
    public static ArrayList<Order> getAllOrdersByDate(int page) throws LoginSampleException{
        ArrayList<Order> orders = OrderMapper.getAllOrdersByDate(page);
        return orders;
    }
    public static Item getItem( int itemid ) throws LoginSampleException{
        Item item = ItemMapper.getItem( itemid );
        return item;
    }
    public static boolean updateItem( Item i ) throws LoginSampleException {
        return ItemMapper.updateItem( i );   
    }
    public static ArrayList<Item> getAllItemsByID(int page) throws LoginSampleException{
        ArrayList<Item> items = ItemMapper.getAllItemsByID(page);
        return items;
    }
    public static ArrayList<Item> getAllItemsByName(int page) throws LoginSampleException{
        ArrayList<Item> items = ItemMapper.getAllItemsByName(page);
        return items;
    }
    public static ArrayList<Item> getAllItemsByUnit(int page) throws LoginSampleException{
        ArrayList<Item> items = ItemMapper.getAllItemsByUnit(page);
        return items;
    }
    public static ArrayList<Item> getAllItemsByPrice(int page) throws LoginSampleException{
        ArrayList<Item> items = ItemMapper.getAllItemsByPrice(page);
        return items;
    }
}
