package com.clearminds.rjhg.bdd.test;

import com.clearminds.rjhg.dtos.Estudiante;
import com.clearminds.rjhg.excepciones.BDDException;
import com.clearminds.rjhg.servicios.ServicioEstudiante;

public class TestActualizar {

	public static void main(String[] args) {
		ServicioEstudiante srvEstudiante = new ServicioEstudiante();
		try {
			srvEstudiante.actualizarEstudiante(new Estudiante(2, "Juan", "Chimborazon"));
		} catch (BDDException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
