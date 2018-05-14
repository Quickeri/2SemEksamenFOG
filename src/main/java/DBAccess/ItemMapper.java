/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Item;
import FunctionLayer.LoginSampleException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mads
 */
public class ItemMapper {
    // Creates an item
    public static void createItem(Item i) throws LoginSampleException{
        try {
            Connection con = Connector.connection();
            
            String SQL = "INSERT INTO items VALUES(null, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL );
            
            ps.setString(1, i.getName());
            ps.setString(2, i.getUnit());
            ps.setInt(3, i.getPrice());
            ps.setString(4, i.getDescription());
            ps.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new LoginSampleException( "Could not create item" );
        }
    }
    
    // Updates an item
    public static boolean updateItem(Item i) throws LoginSampleException{
        try
        {
        Connection con = Connector.connection();
        
        String SQL = "UPDATE items SET name = ?, unit = ?, price = ?, description = ? WHERE orderid = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            
            ps.setString(1, i.getName());
            ps.setString(2, i.getUnit());
            ps.setInt(3, i.getPrice());
            ps.setString(4, i.getDescription());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
            throw new LoginSampleException( "Could not update item" );
        }
    }
    
    // Deletes an item
    public static boolean deleteItem(int itemid){
        try
        {
        Connection con = Connector.connection();
        
        String SQL = "DELETE FROM orders WHERE itemid = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            
            ps.setInt(1, itemid);  
            ps.executeUpdate();

            return true;
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
    // Returns a single item
    public static Item getItem(int itemid) throws LoginSampleException{
        try
        {
            Connection con = Connector.connection();
            
            String SQL = "SELECT * FROM items WHERE itemid = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            
            ps.setInt(1, itemid);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                String name = rs.getString("name");
                String unit = rs.getString("unit");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                return new Item(itemid, name, unit, price, description);
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
       // Returns the amount of orders in database
    public static int countItems() throws LoginSampleException {
        int count = 0;
        try {
        Connection con = Connector.connection();
            
        String SQL = "SELECT COUNT(itemid) FROM items";
        PreparedStatement ps = con.prepareStatement( SQL );
        
        ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                count = rs.getInt("count(itemid)");
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return count;
    }
    // Returns an arraylist of all items ordered by itemid
    public static ArrayList<Item> getAllItemsByID(int page) throws LoginSampleException{
        ArrayList<Item> items = new ArrayList();
        try
        {
            Connection con = Connector.connection();
            
            String SQL = "SELECT * FROM items ORDER BY itemid LIMIT ?, 10";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, (page - 1) * 10);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next())
            {
                int itemid = rs.getInt("itemid");
                String name = rs.getString("name");
                String unit = rs.getString("unit");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                Item i = new Item(itemid, name, unit, price, description);
                items.add(i);
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return items;
    }
    // Returns an arraylist of all items ordered by name
    public static ArrayList<Item> getAllItemsByName(int page) throws LoginSampleException{
        ArrayList<Item> items = new ArrayList();
        try
        {
            Connection con = Connector.connection();
            
            String SQL = "SELECT * FROM items ORDER BY name LIMIT ?, 10";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, (page - 1) * 10);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int itemid = rs.getInt("itemid");
                String name = rs.getString("name");
                String unit = rs.getString("unit");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                Item i = new Item(itemid, name, unit, price, description);
                items.add(i);
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return items;
    }
    // Returns an arraylist of all items ordered by unit
    public static ArrayList<Item> getAllItemsByUnit(int page) throws LoginSampleException{
        ArrayList<Item> items = new ArrayList();
        try
        {
            Connection con = Connector.connection();
            
            String SQL = "SELECT * FROM items ORDER BY unit LIMIT ?, 10";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, (page - 1) * 10);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int itemid = rs.getInt("itemid");
                String name = rs.getString("name");
                String unit = rs.getString("unit");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                Item i = new Item(itemid, name, unit, price, description);
                items.add(i);
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return items;
    }
    // Returns an arraylist of all items ordered by price
    public static ArrayList<Item> getAllItemsByPrice(int page) throws LoginSampleException{
        ArrayList<Item> items = new ArrayList();
        try
        {
            Connection con = Connector.connection();
            
            String SQL = "SELECT * FROM items ORDER BY price LIMIT ?, 10";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, (page - 1) * 10);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int itemid = rs.getInt("itemid");
                String name = rs.getString("name");
                String unit = rs.getString("unit");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                Item i = new Item(itemid, name, unit, price, description);
                items.add(i);
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return items;
    }
}
