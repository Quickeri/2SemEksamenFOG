package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO customer (name, email, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getName() );
            ps.setString( 2, user.getEmail() );
            ps.setString( 3, user.getPassword() );
            ps.setString( 4, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT customerid, role FROM fogcarport.customer "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "customerid" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Forkert email eller password" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
  
    public static void updateUser (User user) throws LoginSampleException{
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE customer SET email = ?, password = ? WHERE customerid = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getId());
            
            ps.executeUpdate();
            }
        catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
