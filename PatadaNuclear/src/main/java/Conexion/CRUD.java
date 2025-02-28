/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD {

    public static Connection con;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;

    public static Connection setConnection(Connection connection) {
        CRUD.con = connection;
        return connection;
    }

    public static Connection getConnection() {
        return con;
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean insertarBD(String sentencia, Object... parametros) {
        try {
            pstmt = con.prepareStatement(sentencia);

            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            pstmt.executeUpdate();
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
            return false;
        }
        return true;
    }

    public static void ListarDueños(String sentencia) {
        try {
            pstmt = con.prepareStatement(sentencia);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id_Dueño");
                String name = rs.getString("Nombre");
                String edad = rs.getString("edad");

                System.out.println(id);
                System.out.println(name);
                System.out.println(edad);

            }

        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
        }
    }
    
    public static void ListarCompetencias(String sentencia) {
        try {
            pstmt = con.prepareStatement(sentencia);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String fecha = rs.getString("Fecha_Inicio");
                String lugar = rs.getString("Lugar");
                String estado = rs.getString("Estado");
                String ganador = rs.getString("Nombre");

                System.out.println(fecha);
                System.out.println(lugar);
                System.out.println(estado);
                System.out.println(ganador);

            }

        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
        }
    }
    
    public static String BurrosCompetencia(String sentencia, Object... parametros) {
        String range = "";
        try {
            pstmt = con.prepareStatement(sentencia);

            // Establecer los parámetros para la consulta preparada
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                String nombre = rs.getString("nombre");

                System.out.println(nombre);
                
            
            }
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
            return "error";
        }
        return range;
    }

    public static boolean actualizarBD(String sentencia, Object... parametros) {
        try {
            pstmt = con.prepareStatement(sentencia);

            // Establecer los parámetros para la consulta preparada
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            pstmt.executeUpdate();
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
            return false;
        }
        return true;
    }

// Métodos de commit y rollback
    public static boolean setAutoCommitBD(boolean parametro) {
        try {
            con.setAutoCommit(parametro);
        } catch (SQLException sqlex) {
            System.out.println("Error al configurar el autoCommit " + sqlex.getMessage());
            return false;
        }
        return true;
    }

    public static boolean commitBD() {
        try {
            con.commit();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error al hacer commit " + sqlex.getMessage());
            return false;
        }
    }

    public static boolean rollbackBD() {
        try {
            con.rollback();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error al hacer rollback " + sqlex.getMessage());
            return false;
        }
    }

    public static void cerrarConexion() {
        closeConnection(con);
    }

}
