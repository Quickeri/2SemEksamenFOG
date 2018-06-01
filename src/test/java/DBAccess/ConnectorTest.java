package DBAccess;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectorTest {
    
    public ConnectorTest() {
    }

    @Test
    public void canConnect() throws Exception {
        Connection con = Connector.connection();
        assertTrue(con != null);
        con.close();
    }
    
    @Test
    public void hasDriver() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        assertTrue(true);
    }
    
}
