package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Professor extends Model{
	public String nome;
	public Long matricula;
	public String email;
	public String senha;
	
}
