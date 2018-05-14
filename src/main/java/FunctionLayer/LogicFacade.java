package FunctionLayer;

import DBAccess.ItemMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String name, String email, String password ) throws LoginSampleException {
        User user = new User( name, email, password, "customer" );
        UserMapper.createUser( user );
        return user;
    }
    public static User updateUser( User user ) throws LoginSampleException {
        UserMapper.updateUser( user );
        return user;
    }
    public static Order createOrder( int customerid, int length, int width, int height, String date ) throws LoginSampleException {
        Order order = new Order( customerid, length, width, height, date );
        OrderMapper.createOrder( order );
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
