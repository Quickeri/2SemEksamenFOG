package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

//    private static final String url = "jdbc:mysql://46.101.253.149:3306/useradmin";
    private static final String URL = "jdbc:mysql://localhost:3306/fogcarport?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Admin1234";

    private static Connection singleton;

    public static Connection connection() throws ClassNotFoundException, SQLException  {
        if ( singleton == null ) {
            Class.forName( "com.mysql.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

}
