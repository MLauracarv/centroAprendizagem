package controllers;

import java.util.List;

import models.Aluno;
import models.Comentario;
import models.Feed;
import models.Mensagem;
import models.Professor;
import models.SalaVirtual;
import models.Tabuleiro;
import play.mvc.Controller;

public class Feeds extends Controller {

	public static void criarFeed(Long idSalaVirtual) {
		Feed feed1 = Feed.find("idSalaVirtual = ?", idSalaVirtual).first();
		String idP= session.get("idProfessor");
		Long idProfessor= Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
	
		Long matricula = professor.matricula;
		
		if(feed1 != null ) {
			long idFeed = feed1.id;
			List<Comentario> listarComentarios=  Comentario.find("idFeed = ?", idFeed).fetch();
			List<Mensagem> listarMensagens =  Mensagem.find("idFeed = ?", idFeed).fetch();
			renderTemplate("Mensagens/feed.html", idSalaVirtual, idFeed, listarMensagens, matricula, listarComentarios);
			
		}
		else {
			render(idSalaVirtual);
		}

	}
	
	/*public static void feed(Long idSalaVirtual) {
		SalaVirtual sala = SalaVirtual.findById(idSalaVirtual);
		
		//Feed <List> retorno = Feed.findById(idSalaVirtual);
		//List<Feed> feeds = Feed.findAll();
		//System.out.println("FEEDS "+feeds);
		//#{list items 'mensagens', as: 'mensagem'}
		//#{/list}
		//List<Feed> feed =  sala.feed;
		//List<Aluno> alunos = sala.alunos;
		//System.out.println("LISTAAAA "+feed);
		//SalaVirtual sala = s;
		//List<Aluno> salas = sala.alunos;
		//System.out.println("LISTA????  "+mensagens);
		
		render(idSalaVirtual);
		
	}
	*/
	public static void salvar(Long idSalaVirtual, Feed feed) {
		
		String idP= session.get("idProfessor");
		Long idProfessor= Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
		SalaVirtual sala = SalaVirtual.findById(idSalaVirtual);
		feed.salaVirtual = sala; 
		feed.save();
		long idFeed = feed.id;
		System.out.println("idFeed salvar "+ idFeed);
		detalhes(idSalaVirtual, idFeed);
	}
	
	public static void detalhes(long idSalaVirtual, long idFeed) {
		
		System.out.println("idFeed detalhes "+ idFeed);
		
		renderTemplate("Mensagens/Feed.html", idSalaVirtual, idFeed );
	}
	
	

}
