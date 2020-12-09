package com.clearminds.rjhg.servicios;

import com.clearminds.rjhg.dtos.Estudiante;
import com.clearminds.rjhg.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase {
	public void insertarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("Insertando estudiante: " + estudiante);
		cerrarConexion();
	}
}
