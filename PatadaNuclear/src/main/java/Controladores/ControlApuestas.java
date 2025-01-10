/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.Apuesta;
import Clases.Burros;
import Conexion.CRUD;
import Conexion.ConexionBD;
import java.sql.SQLException;

public class ControlApuestas {
    public static boolean registrarApuesta(int participante,int competencia,int burroApostado,int saldoAposado) throws SQLException {
        
        Apuesta A1 = new Apuesta(participante,competencia,burroApostado,saldoAposado);

        CRUD.setConnection(ConexionBD.ConexionBD());

        String sentencia = "INSERT INTO Apuestas(Particpante_id, Competencia_id,Burro_id,SaldoApuesta) VALUES (?, ?,?, ?)";

        if (CRUD.setAutoCommitBD(false)) {
            try {
                if (CRUD.insertarBD(sentencia,A1.getParticipante(),A1.getCompetencia(),A1.getBurroApostado(),A1.getSaldoApostado())) {
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
