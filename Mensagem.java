package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Mensagem extends Model{
	public String conteudoMensagem;
	public String autorMensagem;
	public long matriculaAutorMensagem;
	public String nomeFoto;
	
	@ManyToOne
	@JoinColumn(name="idFeed")
	public Feed feed;
	
	@OneToMany
	@JoinColumn(name="idComentario")
	public List<Comentario> comentarios;

}
