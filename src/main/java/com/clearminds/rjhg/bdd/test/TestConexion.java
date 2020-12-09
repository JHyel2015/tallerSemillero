package com.clearminds.rjhg.bdd.test;

import java.sql.Connection;

import com.clearminds.rjhg.bdd.ConexionBDD;
import com.clearminds.rjhg.excepciones.BDDException;

public class TestConexion {

	public static void main(String[] args) {
		
		try {
			Connection conn = ConexionBDD.obtenerConexion();
			if (conn != null) {
				System.out.println("Conexion exitosa");
			}
		} catch (BDDException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
