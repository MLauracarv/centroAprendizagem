package models;
import enums.TipoUsuario;


import javax.persistence.Entity;
import enums.TipoUsuario;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Aluno extends Model{
	public String nome;
	public Long matricula;
	public String email;
	public String senha;
	public String enviar;
	
	
	public TipoUsuario tipoUsuario;
	
	public Aluno() {
	tipoUsuario = TipoUsuario.ALUNO;
	}

}
