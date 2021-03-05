 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.*/
 
package funciones;
import java.sql.*;

/**
 *
 * @author
 */

public class Myconexion {
    private static final String URL = "jdbc:mysql://192.168.2.15:3306/control_inventarios";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String PASS = "tesopor*";

    static {
        try {
            Class.forName(DRIVER);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection obtener() {
        try {
            return DriverManager.getConnection(URL, USUARIO, PASS);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
 public void cerrar() throws SQLException {
        if (obtener() != null) {
            obtener().close();
        }

    }
   
}


