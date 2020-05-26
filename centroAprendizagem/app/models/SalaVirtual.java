package models;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import controllers.SalasVirtuais;
import play.db.jpa.Model;

@Entity
public class SalaVirtual extends Model{
	
	public String nomeTurma;
	public String dia ;
	public String horario;
	public String sala;
	public String bloco;
	public String disciplina;
	
	public static String geradorDeCodigos() {
	UUID codigo= UUID.randomUUID();
		
	if (codigo.toString().length() > 10) {
		return codigo.toString().substring(0, 8);	
	}
		return null;	
	} 
	public String codigo = geradorDeCodigos();
	
	

	@ManyToMany
	@JoinTable(name="salaVirtual_professor")
	public List<Professor> professores;

	
	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
}
