package edu.incae.mba.carrera_express.utilitarios;

public class Correctores {
	
	public String ConverterParaSQL(String Data){
		
		return Data.substring(6,10)+"-"+Data.substring(3,5)+"-"+Data.substring(0,2);
	}
	
	public String ConverterParaJava(String Data){
		
		return Data.substring(8,10)+"/"+Data.substring(5,7)+"/"+Data.substring(0,4);
	}
}
