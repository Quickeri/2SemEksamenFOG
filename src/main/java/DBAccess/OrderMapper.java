package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderMapper {
    
    // Creates an order
    public static Order createOrder(Order o) throws LoginSampleException{
        try {
            Connection con = Connector.connection();
            
            String SQL = "INSERT INTO orders VALUES(null, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL , Statement.RETURN_GENERATED_KEYS );
            
            ps.setInt(1, o.getCustomerid());
            ps.setInt(2, o.getHeight());
            ps.setInt(3, o.getLength());
            ps.setInt(4, o.getWidth());
            ps.setString(5, o.getDate());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt( 1 );
            o.setOrderid( id );
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new LoginSampleException( "Could not create order" );
        }
        return o;
    }
    
    // Updates an order
    public static boolean updateOrder(Order o) throws LoginSampleException{
        try
        {
        Connection con = Connector.connection();
        
        String SQL = "UPDATE orders SET height = ?, length = ?, width = ? WHERE orderid = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            
            ps.setInt(1, o.getHeight());
            ps.setInt(2, o.getLength());
            ps.setInt(3, o.getWidth());
            ps.setInt(4, o.getOrderid());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
            throw new LoginSampleException( "Could not update order" );
        }
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
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                String date = rs.getString("date");

                return new Order(orderid, customerid, length, width, height, date);
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
            throw new LoginSampleException( "Could not get order" );
        }
        return null;
    }
    // Returns the amount of orders in database
    public static int countOrders() throws LoginSampleException {
        int count = 0;
        try {
        Connection con = Connector.connection();
            
        String SQL = "SELECT COUNT(orderid) FROM orders";
        PreparedStatement ps = con.prepareStatement( SQL );
        
        ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                count = rs.getInt("count(orderid)");
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            throw new LoginSampleException( "Could not count order" );
        }
        return count;
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
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                String date = rs.getString("date");

                Order o = new Order(orderid, customerid, length, width, height, date);

                orders.add(o);
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            throw new LoginSampleException( "Could not get the orders" );
        }
        return orders;
    }
    
    // Returns an arraylist of all orders
    public static ArrayList<Order> getAllOrdersByOrderid(int page) throws LoginSampleException{
        ArrayList<Order> orders = new ArrayList();
        try{
        Connection con = Connector.connection();
            
        String SQL = "select orders.orderid, customer.name, customer.email, orders.Height, "
                + "orders.Length, orders.Width, orders.date, orders.customerid from customer "
                + "inner join orders on customer.customerid = orders.customerid ORDER BY orderid LIMIT ?, 10";
        PreparedStatement ps = con.prepareStatement( SQL );
        ps.setInt(1, (page - 1) * 10);
        ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int orderid = rs.getInt("orderid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int customerid = rs.getInt("customerid");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                String date = rs.getString("date");

                Order o = new Order(orderid, name, email, customerid, length, width, height, date);

                orders.add(o);
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            throw new LoginSampleException( "Could not get the orders" );
        }
        return orders;
    }
    // Returns an arraylist of all orders
    public static ArrayList<Order> getAllOrdersByCustomerid(int page) throws LoginSampleException{
        ArrayList<Order> orders = new ArrayList();
        try{
        Connection con = Connector.connection();
            
        String SQL = "select orders.orderid, customer.name, customer.email, orders.Height, "
                + "orders.Length, orders.Width, orders.date, orders.customerid from customer "
                + "inner join orders on customer.customerid = orders.customerid ORDER BY customerid LIMIT ?, 10";
        PreparedStatement ps = con.prepareStatement( SQL );
        ps.setInt(1, (page - 1) * 10);
        ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int orderid = rs.getInt("orderid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int customerid = rs.getInt("customerid");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                String date = rs.getString("date");

                Order o = new Order(orderid, name, email, customerid, length, width, height, date);

                orders.add(o);
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            throw new LoginSampleException( "Could not get the orders" );
        }
        return orders;
    }
    // Returns an arraylist of all orders
    public static ArrayList<Order> getAllOrdersByName(int page) throws LoginSampleException{
        ArrayList<Order> orders = new ArrayList();
        try{
        Connection con = Connector.connection();
            
        String SQL = "select orders.orderid, customer.name, customer.email, orders.Height, "
                + "orders.Length, orders.Width, orders.date, orders.customerid from customer "
                + "inner join orders on customer.customerid = orders.customerid ORDER BY name LIMIT ?, 10";
        PreparedStatement ps = con.prepareStatement( SQL );
        ps.setInt(1, (page - 1) * 10);
        ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int orderid = rs.getInt("orderid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int customerid = rs.getInt("customerid");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                String date = rs.getString("date");

                Order o = new Order(orderid, name, email, customerid, length, width, height, date);

                orders.add(o);
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            throw new LoginSampleException( "Could not get the orders" );
        }
        return orders;
    }
    // Returns an arraylist of all orders
    public static ArrayList<Order> getAllOrdersByDate(int page) throws LoginSampleException{
        ArrayList<Order> orders = new ArrayList();
        try{
        Connection con = Connector.connection();
            
        String SQL = "select orders.orderid, customer.name, customer.email, orders.Height, "
                + "orders.Length, orders.Width, orders.date, orders.customerid from customer "
                + "inner join orders on customer.customerid = orders.customerid ORDER BY date DESC, orderid DESC LIMIT ?, 10";
        PreparedStatement ps = con.prepareStatement( SQL );
        ps.setInt(1, (page - 1) * 10);
        ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int orderid = rs.getInt("orderid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int customerid = rs.getInt("customerid");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                String date = rs.getString("date");

                Order o = new Order(orderid, name, email, customerid, length, width, height, date);

                orders.add(o);
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            throw new LoginSampleException( "Could not get the orders" );
        }
        return orders;
    }
}
