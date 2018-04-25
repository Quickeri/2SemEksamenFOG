package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {

//    private static final String url = "jdbc:mysql://46.101.253.149:3306/useradmin";
    private static final String url = "jdbc:mysql://localhost:3306/useradmin?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "admin";

    private static Connection singleton;

    public static Connection connection() throws ClassNotFoundException, SQLException  {
        if ( singleton == null ) {
            Class.forName( "com.mysql.jdbc.Driver" );
            singleton = DriverManager.getConnection( url, username, password );
        }
        return singleton;
    }

}
