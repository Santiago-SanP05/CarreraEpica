/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.BurroCompetencia;
import Clases.Burros;
import Clases.Competencias;
import Conexion.CRUD;
import Conexion.ConexionBD;
import java.sql.SQLException;

public class ControlBurro {
    public static boolean registrarBurro(String nombre,String edad,String raza,int duenio) throws SQLException {
        
        Burros b1 = new Burros(nombre, edad, raza, duenio);

        CRUD.setConnection(ConexionBD.ConexionBD());

        String sentencia = "INSERT INTO Burros(Nombre, edad,Raza,Dueño_id) VALUES (?, ?,?, ?)";

        if (CRUD.setAutoCommitBD(false)) {
            try {
                if (CRUD.insertarBD(sentencia, b1.getNombre(),b1.getEdad(),b1.getRaza(),b1.getDuenio())) {
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
    
    public static boolean CambiarDuenioBurro(int Duenio, int Burro) throws SQLException {

        CRUD.setConnection(ConexionBD.ConexionBD());
        
        String sentencia = "UPDATE Burros SET Dueño_id = ? WHERE Id_Burro = ?;";

        if (CRUD.setAutoCommitBD(false)) {
            try {
                if (CRUD.insertarBD(sentencia,Duenio,Burro)) {
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
    
    public static boolean registrarBurroCompetencia(int burro,int competencia) throws SQLException {
        
        BurroCompetencia bc1 = new BurroCompetencia(burro, competencia);

        CRUD.setConnection(ConexionBD.ConexionBD());

        String sentencia = "INSERT INTO CompetenciaBurros(Burro_id , Competencia_id ) VALUES (?, ?)";

        if (CRUD.setAutoCommitBD(false)) {
            try {
                if (CRUD.insertarBD(sentencia,bc1.getBurro(),bc1.getCompetencia())) {
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
    
    
}
