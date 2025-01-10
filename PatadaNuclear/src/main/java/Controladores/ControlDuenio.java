/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.CRUD;
import Conexion.ConexionBD;
import java.sql.SQLException;

public class ControlDuenio {
    public static boolean registrarDuenio(String nombre, String edad) throws SQLException {
        Clases.Duenio d1 = new Clases.Duenio(nombre, edad);

        CRUD.setConnection(ConexionBD.ConexionBD());

        String sentencia = "INSERT INTO Dueño(Nombre, edad) VALUES (?, ?)";

        if (CRUD.setAutoCommitBD(false)) {
            try {
                if (CRUD.insertarBD(sentencia, d1.getNombre(), d1.getEdad())) {
                    CRUD.commitBD();
                    return true;
                } else {
                    CRUD.rollbackBD();
                    return false;
                }
            } catch (Exception e) {
                CRUD.rollbackBD();
                throw e;
            } finally {
                CRUD.cerrarConexion();
            }
        } else {
            CRUD.cerrarConexion();
            return false;
        }

    }
    
    public static boolean eliminarDuenio(int id) throws SQLException {
        CRUD.setConnection(ConexionBD.ConexionBD());

        String sentencia = "DELETE FROM Dueño WHERE Id_Dueño = ?;";

        if (CRUD.setAutoCommitBD(false)) {
            try {
                if (CRUD.insertarBD(sentencia,id)) {
                    CRUD.commitBD();
                    return true;
                } else {
                    CRUD.rollbackBD();
                    return false;
                }
            } catch (Exception e) {
                CRUD.rollbackBD();
                System.out.println("Parece que el id no existe");
                throw e;
            } finally {
                CRUD.cerrarConexion();
            }
        } else {
            CRUD.cerrarConexion();
            return false;
        }

    }
    
}
