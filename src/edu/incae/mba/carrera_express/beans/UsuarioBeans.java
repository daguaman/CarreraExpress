package edu.incae.mba.carrera_express.beans;

public class UsuarioBeans {
	
	private Integer UsuarioId;
	private String user;
	private String clave;
	private Integer personaFk;
	
	
	public UsuarioBeans(){
		
	}
	
	public UsuarioBeans(String user, String clave, Integer personaFk) {
		this.user = user;
		this.clave = clave;
		this.personaFk = personaFk;
	}
	
	
	public Integer getUsuarioId() {
		return UsuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		UsuarioId = usuarioId;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Integer getPersonaFk() {
		return personaFk;
	}
	public void setPersonaFk(Integer personaFk) {
		this.personaFk = personaFk;
	}

}
