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
            
            ps.setInt(1, o.getCustomerid());
            ps.setInt(2, o.getCarportid());
            ps.setInt(3, o.getHeight());
            ps.setInt(4, o.getLength());
            ps.setInt(5, o.getWidth());
            
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new LoginSampleException( "Could not validate order" );
        }
    }
    
    // Updates an order
    public static boolean updateOrder(Order o) throws LoginSampleException{
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
            throw new LoginSampleException( "Could not validate order" );
        }
//        return false;
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
                int customerid = rs.getInt("customerid");
                int carportid = rs.getInt("carportid");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");

                return new Order(orderid, customerid, carportid, length, width, height);
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    // Returns an arraylist of orders from a customer
    public static ArrayList<Order> getOrders(int customerid) throws LoginSampleException{
        ArrayList<Order> orders = new ArrayList();
        try {
        Connection con = Connector.connection();
            
        String SQL = "SELECT * FROM orders WHERE customerid = ?";
        PreparedStatement ps = con.prepareStatement( SQL );
        ps.setInt(1, customerid);
        ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int orderid = rs.getInt("orderid");
                int carportid = rs.getInt("carportid");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");

                Order o = new Order(orderid, customerid, carportid, length, width, height);

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
            
        String SQL = "select orders.orderid, customer.name, customer.email, orders.carportid, orders.Height, orders.Length, orders.Width, orders.customerid from customer inner join orders on customer.customerid = orders.customerid";
        PreparedStatement ps = con.prepareStatement( SQL );
        ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int orderid = rs.getInt("orderid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int carportid = rs.getInt("carportid");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int customerid = rs.getInt("customerid");

                Order o = new Order(orderid, name, email, carportid, length, width, height, customerid);

                orders.add(o);
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return orders;
    }
}
