package models;
import enums.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import enums.TipoUsuario;
import javax.persistence.Entity;

import play.db.jpa.Model;
import play.mvc.Scope.Session;

@Entity
public class Aluno extends Model implements Comparable<Aluno>{
	public String nome;
	public Long matricula;
	public String email;
	public String senha;
	public int pontos;
	
	public int getPontos() {
		return pontos;
	}
	
	public TipoUsuario tipoUsuario;
	
	public Aluno() {
	tipoUsuario = TipoUsuario.ALUNO;
	}
	
	@ManyToMany(mappedBy="alunos")
	public List<SalaVirtual> salasVirtuais;
	
	public int getPontosPorSala(Long salaId) {
		List<Frequencia> frequencias = Frequencia.find("aluno=? and id_Sala=?", this, salaId).fetch();
		
		int soma = 0;
		for(int i = 0; i<frequencias.size();i++) {
			soma += frequencias.get(i).grauFrequencia + frequencias.get(i).grauParticipacao;
		}
		return soma;
		//metodo para comparar pela soma
	}

	@Override
		public int compareTo(Aluno a) {
			return (a.pontos - this.pontos);
			
	}	
	
	
	
	
}
