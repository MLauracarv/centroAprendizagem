package controllers;
import java.util.List;
import java.util.Random;

import models.Aluno;
import models.Professor;
import play.mvc.Controller;


public class Professores extends Controller {
	
	public static void formProfessores() {
		render();
	}
	public static void salvar(Professor prof) {
	prof.save();
	Login.autenticar(prof.email, prof.senha);
	}
	public static void listarProfessores() {
		List<Professor> lista = Professor.findAll();
		render(lista);
	}
	
	//public static void numero(String[] args) {
	//	int lista1 = NumeroAleatorio.main(args);
	//render(lista1);
	//}
	

	
	public static void editar(long id) {
		Professor p = Professor.findById(id);
		renderTemplate("Professores/formProfessores.html", p);
		
	}
	public static void deletar(long id) {
		Professor p = Professor.findById(id);
		p.delete();
		
		listarProfessores();
	}
	public static void indexProfessores() {
		render();
	}
	
	
}