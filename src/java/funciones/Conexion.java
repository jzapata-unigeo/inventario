 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.*/
 
package funciones;

import java.io.*;
import java.sql.*;

/**
 *
 * @author
 */

public class Conexion {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=inventario";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USUARIO = "sa";
    private static final String PASS = "sareval1**";

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


