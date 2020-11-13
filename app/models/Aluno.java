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
public class Aluno extends Model {
//implements Comparable<Aluno>{
	public String nome;
	public Long matricula;
	public String email;
	public String senha;
	public int pontos;
	
	//ArrayList <Integer > var= new ArrayList();
	//var.add(get.frequencia() + getpaticipacao);
	
	public int getPontos() {
		return pontos;
	}
	
	
	
	public TipoUsuario tipoUsuario;
	
	public Aluno() {
	tipoUsuario = TipoUsuario.ALUNO;
	}
	
	@ManyToMany(mappedBy="alunos")
	public List<SalaVirtual> salasVirtuais;
	
	//public static Integer soma = 0;
	
	
	
	/*@Override
		public int compareTo(Aluno a) {
			return (this.soma - a.soma);
			
	*/	
	
	//public static void calcularPontuacao(long idAluno, long id_CA, Aluno a, Frequencia freq) {
		
	//}
	
	
	
}
