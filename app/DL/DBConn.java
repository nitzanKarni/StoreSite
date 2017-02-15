package DL;
import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.util.*;
/**
 * @desc A singleton database access class for MySQL
 * @author Ramindu
 */
public final class DBConn {
    public Connection conn;
    private Statement statement;
    private PreparedStatement prpStmt = null;
    public static DBConn db;
    private DBConn() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "shop";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "Aa123456";
        
        Properties properties = new Properties();
        properties.setProperty("user", userName);
        properties.setProperty("password", password);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url + dbName,properties);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized DBConn getDbCon() {
        if ( db == null ) {
            db = new DBConn();
        }
        return db;
 
    }
    /**
     * Query statement without condition
     * 
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not available
     * @throws SQLException
     */
    public ResultSet query(String query) throws SQLException{
    	if( statement == null )
    		statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    
    /**
     * @desc Method to insert data to a table
     * @param insertQuery String The Insert query
     * @return boolean
     * @throws SQLException
     */
    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;
 
    }
    
    // Close connection with db
    public static synchronized void closeConn() { 
    	if( db != null ) {
    		try {
    			db.conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    	}
    }
}