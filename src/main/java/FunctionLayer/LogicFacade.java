package FunctionLayer;

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

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User( email, password, "customer" );
        UserMapper.createUser( user );
        return user;
    }
    public static Order createOrder( int customerid, int carportid, int length, int width, int height ) throws LoginSampleException {
        Order order = new Order( customerid, carportid, length, width, height );
        OrderMapper.createOrder( order );
        return order;
    }
    public static boolean updateOrder( Order o ) throws ClassNotFoundException{
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
    public static ArrayList<Order> getAllOrders() throws LoginSampleException{
        ArrayList<Order> orders = OrderMapper.getAllOrders();
        return orders;
    }
}
