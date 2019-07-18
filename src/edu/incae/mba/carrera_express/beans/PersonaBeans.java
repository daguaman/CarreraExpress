package edu.incae.mba.carrera_express.beans;

public class PersonaBeans {
	
	private Integer personaId;
	private String nombres;
	private String apellidos;
	private String cedula;
	private Character estado;	
	
	
	public PersonaBeans(){
		
	}
	
	
	public PersonaBeans(String nombres, String apellidos, String cedula) {
	
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cedula = cedula;
	}
	
	public Integer getPersonaId() {
		return personaId;
	}
	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Character getEstado() {
		return estado;
	}
	public void setEstado(Character estado) {
		this.estado = estado;
	}
	
	
	
	
}
