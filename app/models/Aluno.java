package models;
import enums.TipoUsuario;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import enums.TipoUsuario;
import javax.persistence.Entity;

import play.db.jpa.Model;
import play.mvc.Scope.Session;

@Entity
public class Aluno extends Model{
	public String nome;
	public Long matricula;
	public String email;
	public String senha;
	
	public TipoUsuario tipoUsuario;
	
	public Aluno() {
	tipoUsuario = TipoUsuario.ALUNO;
	}
	
	@ManyToMany(mappedBy="alunos")
	public List<SalaVirtual> salasVirtuais;
	
	
	
	
}
