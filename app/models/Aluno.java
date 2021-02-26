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
	@Expose
	public String nome;
	
	@Expose
	public Long matricula;
	
	@Expose
	public String email;
	
	public String senha;
	
	public int pontos;
	
	@Expose
	@Transient
	public Integer pontuacaoPorCA;
	
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
		List<Frequencia> frequencias = Frequencia.find("aluno=? and IdSala=?", this, salaId).fetch();
		
		int soma = 0;
		for(int i = 0; i<frequencias.size();i++) {
			soma += frequencias.get(i).grauFrequencia + frequencias.get(i).grauParticipacao;
		}
		return soma;
		//metodo para comparar pela soma
	}
	
	public Integer[] getFrequencia(Long salaId) {
		List<Frequencia> frequencias = Frequencia.find("aluno=? and id_Sala=?", this, salaId).fetch();
		
		Integer frequencia = 0;
		int  participacao = 0;
		Integer[] retorno = new Integer[2];
		for(int i = 0; i<frequencias.size();i++) {
			frequencia = frequencias.get(i).grauFrequencia; 
			participacao = frequencias.get(i).grauParticipacao;
			retorno[0] = frequencia;
			retorno[1] = participacao;
			
		}
		return retorno;
		
		//return participacao;
		//metodo para comparar pela soma
	}

	@Override
		public int compareTo(Aluno a) {
			return (a.pontos - this.pontos);
			
	}	
	
	
	
	
}
