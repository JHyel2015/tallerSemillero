package com.clearminds.rjhg.servicios;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.clearminds.rjhg.dtos.Estudiante;
import com.clearminds.rjhg.excepciones.BDDException;
import com.clearminds.rjhg.utils.DateUtil;

public class ServicioEstudiante extends ServicioBase {
	public void insertarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("Insertando estudiante: " + estudiante);
		Statement stmt =null;
		try {
			stmt = getConexion().createStatement();
			
			String sql = "insert into estudiantes(nombre,apellido,edad,fecha_modificacion) values('" + 
			estudiante.getNombre() + "','" + estudiante.getApellido();
			
			if (estudiante.getEdad() == 0){
				sql += "', NULL ";
			} else {
				sql += "'," + estudiante.getEdad();
			}
			
			sql += ",'" + DateUtil.obtenerFecha(new Date()) + "')";
			
			
			System.out.println("Script: " + sql);
			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar estudiante");
		}
	}
	
	public void actualizarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("Actualizando estudiante: " + estudiante);
		Statement stmt = null;
		try {
			stmt = getConexion().createStatement();

			String sql = "update estudiantes set nombre = '" + 
			estudiante.getNombre() + "', apellido = '" + estudiante.getApellido() + "'";

			if (estudiante.getEdad() == 0){
				sql += ", edad = NULL";
			} else {
				sql += ", edad = " + estudiante.getEdad();
			}
			
			sql += ", fecha_modificacion = '" + DateUtil.obtenerFecha(new Date()) + "' where id = " + estudiante.getId();
			
			System.out.println("Script: " + sql);
			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al actualizar estudiante");
		}
	}
}
