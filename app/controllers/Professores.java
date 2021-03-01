package controllers;
import java.util.List;
import java.util.Random;

import models.Aluno;
import models.Professor;
import models.SalaVirtual;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;


public class Professores extends Controller {
	@Before(only = {"listarProfessores"})
	static void rentringirSalaAoProfessor() {
		if (session.get("tipoUsuario") != null && !session.get("tipoUsuario").equalsIgnoreCase("Professor")) {
			Restricoes.restricoesAlunos();
		}
	}
	
	public static void Feed() {
		render();
	}
	
	public static void editarFormQuestao() {
		renderTemplate("Professores/formQuestao.html");
	}
	
	public static void formsCriados() {
		render();
	}
	
	public static void resposta() {
		render();
	}
	
	public static void respostasAlunos() {
		render();
	}
	
	public static void formProfessores() {
		render();
	}
	
	public static void formAlternativas() {
		render();
	}
	
	public static void salvar(@Valid Professor prof) {
		if (validation.hasErrors()) {
			validation.keep();
			params.flash();		
			PainelLoginUsuario.index();
		}
		prof.save();
		Login.autenticar(prof.email, prof.senha);
	}
	
	public static void listarProfessores() {
		List<Professor> lista = Professor.findAll();
		render(lista);
	}
	
	public static void editar(long id) {
		Professor p = Professor.findById(id);
		renderTemplate("Professores/formProfessores.html", p);
		
	}
	public static void deletar(long id) {
		Professor p = Professor.findById(id);
		p.delete();
		
		listarProfessores();
	}
	
	
	public static void formQuestao() {
		render();
	}
}