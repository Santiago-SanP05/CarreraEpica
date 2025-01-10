/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.Competencias;
import Conexion.CRUD;
import Conexion.ConexionBD;
import java.sql.SQLException;

public class ControlCompetencias {
    
    public static boolean registrarCompetencia(String fechaInicio,String lugar) throws SQLException {
        
        Competencias c1 = new Competencias(fechaInicio,lugar,false,0);

        CRUD.setConnection(ConexionBD.ConexionBD());

        String sentencia = "INSERT INTO Competencias(Fecha_Inicio, Lugar,Estado,Ganador) VALUES (?, ?,?, ?)";

        if (CRUD.setAutoCommitBD(false)) {
            try {
                if (CRUD.insertarBD(sentencia, c1.getFechaInicio(),c1.getLugar(),c1.isEstado(),null)) {
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
    
    public static boolean eliminarCompetencia(int id) throws SQLException {
        CRUD.setConnection(ConexionBD.ConexionBD());

        String sentencia = "DELETE FROM Competencias WHERE Id_Competencia = ?;";

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
