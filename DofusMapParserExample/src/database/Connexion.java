package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class Connexion{
    final static private String HOST = "127.0.0.1";
    final static private String DB = "jelly-1-29";
    final static private String USER = "jelly-1-29";
    final static private String PASS = "";
    
    private Connection connection;
    
    public Connexion() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + DB, USER, PASS);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public ResultSet query(String sql){
        try {
            return connection.createStatement().executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
