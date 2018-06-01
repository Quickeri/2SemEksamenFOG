package DBAccess;

import FunctionLayer.Item;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemListMapper {
    // Creates an itemlist
    public static void createItemList(Order o, ArrayList<Item> item) throws LoginSampleException{
        try {
            Connection con = Connector.connection();
            
            String SQL = "INSERT INTO itemlist VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL );
            
            for(Item i : item){
                
            ps.setInt(1, o.getOrderid());
            ps.setInt(2, i.getItemid());
            ps.setInt(3, i.getAmount());
            ps.setInt(4, i.getPrice());
          
            ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new LoginSampleException( "Could not create item" );
        }
    }
     // Deletes an itemlist
    public static void deleteItemList(int orderid) throws LoginSampleException{
        try
        {
        Connection con = Connector.connection();
        
        String SQL = "DELETE FROM itemlist WHERE orderid = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            
            ps.setInt(1, orderid);  
            ps.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }
    
     // Returns an itemlist from an order
    public static ArrayList<Item> getItemList(int orderid) throws LoginSampleException{
        ArrayList<Item> itemList = new ArrayList();
        try
        {
            Connection con = Connector.connection();
            
            String SQL = "SELECT itemlist.itemid, itemlist.amount, itemlist.price, items.unit, "
                + "items.name, items.description FROM itemlist "
                + "INNER JOIN items ON itemlist.itemid = items.itemid WHERE orderid = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, orderid);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next())
            {
                int itemid = rs.getInt("itemid");
                int amount = rs.getInt("amount");
                int price = rs.getInt("price");
                String unit = rs.getString("unit");
                String name = rs.getString("name");
                String description = rs.getString("description");

                Item i = new Item(itemid, name, amount, unit, description, price);
                itemList.add(i);
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return itemList;
    }
}
