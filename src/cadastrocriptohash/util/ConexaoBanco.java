/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrocriptohash.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author victor
 */
public class ConexaoBanco {
  
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection conectarBanco() {
        System.out.println("iniciando conexão ...");
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(URL_MYSQL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Não foi possível conectar..." + ex.getMessage());
            return null;
        }        
    }
}

