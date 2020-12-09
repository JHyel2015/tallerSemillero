package com.clearminds.rjhg.servicios;

import java.sql.Connection;
import java.sql.SQLException;

import com.clearminds.rjhg.bdd.ConexionBDD;
import com.clearminds.rjhg.excepciones.BDDException;

public class ServicioBase {
	private Connection conexion;
	
	public void abrirConexion() throws BDDException {
		conexion = ConexionBDD.obtenerConexion();
	}
	
	public void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error al cerrar la conexión");
			}
		}
	}
}
