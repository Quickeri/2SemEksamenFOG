package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderMapper {
    
    // Creates an order
    public static void createOrder(Order o) throws LoginSampleException{
        try {
            Connection con = Connector.connection();
            
            String SQL = "INSERT INTO orders VALUES(null, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL );
            
            ps.setInt(1, o.getUserid());
            ps.setInt(2, o.getLength());
            ps.setInt(3, o.getWidth());
            ps.setInt(4, o.getHeight());
            ps.setBoolean(5, false);
            
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
//            ex.printStackTrace();
            throw new LoginSampleException( "Could not validate order" );
        }
    }
    
    // Updates an order
    public static boolean updateOrder(Order o) throws ClassNotFoundException{
        try
        {
        Connection con = Connector.connection();
        
        String SQL = "UPDATE orders SET length = ?, width = ?, height = ?, WHERE orderid = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            
            ps.setInt(1, o.getLength());
            ps.setInt(2, o.getWidth());
            ps.setInt(3, o.getHeight());
            ps.setInt(4, o.getOrderid());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    // Deletes an order
    public static boolean deleteOrder(int orderid){
        try
        {
        Connection con = Connector.connection();
        
        String SQL = "DELETE FROM orders WHERE orderid = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, orderid);  
            ps.executeUpdate();

            return true;
            } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    // Returns a single order
     public static Order getOrder(int orderid) throws LoginSampleException{
        try
        {
            Connection con = Connector.connection();
            
            String SQL = "SELECT * FROM orders WHERE orderid = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, orderid);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int userid = rs.getInt("userid");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");

                return new Order(orderid, userid, length, width, height);
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    // Returns an arraylist of orders from a customer
    public static ArrayList<Order> getOrders(int userid) throws LoginSampleException{
        ArrayList<Order> orders = new ArrayList();
        try {
        Connection con = Connector.connection();
            
        String SQL = "SELECT * FROM orders WHERE userid = ?";
        PreparedStatement ps = con.prepareStatement( SQL );
        ps.setInt(1, userid);
        ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int orderid = rs.getInt("orderid");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");

                Order o = new Order(orderid, userid, length, width, height);

                orders.add(o);
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return orders;
    }
    
    // Returns an arraylist of all orders
    public static ArrayList<Order> getAllOrders() throws LoginSampleException{
        ArrayList<Order> orders = new ArrayList();
        try{
        Connection con = Connector.connection();
            
        String SQL = "SELECT * FROM orders";
        PreparedStatement ps = con.prepareStatement( SQL );
        ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int orderid = rs.getInt("orderid");
                int userid = rs.getInt("userid");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");

                Order o = new Order(orderid, userid, length, width, height);

                orders.add(o);
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return orders;
    }
}
