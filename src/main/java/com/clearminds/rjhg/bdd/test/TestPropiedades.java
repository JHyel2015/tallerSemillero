package com.clearminds.rjhg.bdd.test;

import com.clearminds.rjhg.bdd.ConexionBDD;

public class TestPropiedades {
	public static void main(String[] args) {
		String valor = ConexionBDD.leerPropiedad("propiedad1");
		System.out.println(valor);
		valor = ConexionBDD.leerPropiedad("xxx");
		System.out.println(valor);
	}
}
