package models;

import javax.persistence.Entity;

import enums.TipoUsuario;
import play.db.jpa.Model;

@Entity
public class Professor extends Model{
	public String nome;
	public Long matricula;
	public String email;
	public String senha;
	
	public TipoUsuario tipoUsuario;
	
	public Professor() {
	tipoUsuario = TipoUsuario.PROFESSOR;
	}
}
