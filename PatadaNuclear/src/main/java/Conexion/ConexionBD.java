/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static String url = "";
    private static String user = "campus2023";
    private static String password = "campus2023";

    public static Connection ConexionBD() {
        url = "jdbc:mysql://localhost:3306/CarreraBurros";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                DatabaseMetaData meta = con.getMetaData();
                System.out.println("Proeso realizado con exito -- " + meta.getDriverName());
            }
            return con;
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
            return null;
        }
    }

}
