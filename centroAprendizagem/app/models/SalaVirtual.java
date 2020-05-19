package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class SalaVirtual extends Model{
	
	public String nomeTurma;
	public String dia;
	public String horario;
	public String local;
	public String disciplina;
	public String codigo;
	
	@ManyToMany
	@JoinTable(name="salaVirtual_professor")
	public List<Professor> professores;
	
	
	
}
