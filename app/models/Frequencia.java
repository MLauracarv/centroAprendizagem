package models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Frequencia extends Model implements Comparable<Frequencia>{

	public Integer grauParticipacao;
	public Integer grauFrequencia;
	public Integer soma;

	
	@ManyToOne
	@JoinColumn(name="idAluno")
	public Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="idCa")
	public CentroAprendizagem centroAprendizagem;

	@Override
	public int compareTo(Frequencia freq) {
		return (freq.soma - this.soma );
	}
	
	
	

	
	
}
