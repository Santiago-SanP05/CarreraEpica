/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.Participantes;
import Conexion.CRUD;
import Conexion.ConexionBD;
import java.sql.SQLException;

public class ControlParticipantes {
    public static boolean registrarParticipantes(String nombre,String cedula,String saldoDisponible) throws SQLException {
        Participantes p1 = new Participantes(nombre,cedula,saldoDisponible);

        CRUD.setConnection(ConexionBD.ConexionBD());

        String sentencia = "INSERT INTO Competencias(Nombre, Cedula,SaldoDisponible) VALUES (?, ?,?)";

        if (CRUD.setAutoCommitBD(false)) {
            try {
                if (CRUD.insertarBD(sentencia, p1.getNombre(),p1.getCedula(),p1.getSaldoDisponible())) {
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
//    UPDATE Participante SET Nombre = 'Nuevo Nombre', SaldoDisponible = 5000 WHERE Id_Participante = ?;
    public static boolean eliminarParticipantes(String documneto) throws SQLException {
        CRUD.setConnection(ConexionBD.ConexionBD());

        String sentencia = "DELETE FROM Participante WHERE Cedula = ?;";

        if (CRUD.setAutoCommitBD(false)) {
            try {
                if (CRUD.insertarBD(sentencia,documneto)) {
                    CRUD.commitBD();
                    return true;
                } else {
                    CRUD.rollbackBD();
                    return false;
                }
            } catch (Exception e) {
                CRUD.rollbackBD();
                System.out.println("Parece que esta cedula no existe");
                throw e;
            } finally {
                CRUD.cerrarConexion();
            }
        } else {
            CRUD.cerrarConexion();
            return false;
        }

    }
    
    public static boolean actualizarParticipantes(String Cedula,int SaldoNuevo) throws SQLException {

        CRUD.setConnection(ConexionBD.ConexionBD());

        String sentencia = "UPDATE Participante SET SaldoDisponible = ? WHERE Cedula = ?;";

        if (CRUD.setAutoCommitBD(false)) {
            try {
                if (CRUD.insertarBD(sentencia,SaldoNuevo,Cedula)) {
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
