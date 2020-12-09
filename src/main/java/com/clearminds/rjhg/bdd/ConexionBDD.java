package com.clearminds.rjhg.bdd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.clearminds.rjhg.excepciones.BDDException;

public class ConexionBDD {
	public static String leerPropiedad(String nombre) {
		Properties p = new Properties();
		try {
			p.load(new FileReader("conexion.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		String property = p.getProperty(nombre);
		return property;
	}
	
	public static Connection obtenerConexion() throws BDDException {
		Connection conn = null;
		String username = leerPropiedad("usuario");
		String password = leerPropiedad("password");
		String URL = leerPropiedad("urlConexion");
		
		try {
			conn = DriverManager.getConnection(URL + ";user=" + username + ";password=" + password + ";");
			if (conn != null) {
				return conn;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BDDException("No se pudo conectar a la base de datos.");
		}
		return conn;
	}
}
