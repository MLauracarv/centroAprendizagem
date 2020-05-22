package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class SalaVirtual extends Model{
	
	public String nomeTurma;
	public String dia ;
	public String horario;
	public String local;
	public String disciplina;
	public String codigo;
	
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	//public List<Professor> getProfessores() {
		//return professores;
	//}

	//public void setProfessores(List<Professor> professores) {
		//this.professores = professores;
	//}
	
	
	
}
