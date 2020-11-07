package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import enums.TipoUsuario;
import play.db.jpa.Model;

@Entity
public class Professor extends Model{
	public String nome;
	public Long matricula;
	public String email;
	public String senha;
	
	public TipoUsuario tipoUsuario;
	
	public Professor() {
	tipoUsuario = TipoUsuario.PROFESSOR;
	}
	
	@ManyToMany(mappedBy="professores")
	public List<SalaVirtual> salasVirtuais;
	
	@OneToMany
	@JoinColumn(name="idSalaVirtual")
	public List <CentroAprendizagem> centrosAprendizagem;
	
	
	//@ManyToMany(mappedBy="professores")
	//public List<SalaVirtual> salasVirtuais;
	
	
}
