package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class SalaVirtual extends Model{
	
	public String nomeTurma;
	public String dia;
	public String horario;
	public String local;
	public String disciplina;
	
	
	
}
