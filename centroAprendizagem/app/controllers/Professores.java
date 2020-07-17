package controllers;
import java.util.List;
import java.util.Random;

import models.Aluno;
import models.Professor;
import models.SalaVirtual;
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
		String idP = session.get("idProfessor");
		Long idProfessor= Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
		List <SalaVirtual> salas = professor.salasVirtuais;
		render(salas);
		render();	
	}
	
	
	
	
}