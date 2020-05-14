package controllers;

import java.util.List;

import models.Aluno;
import play.mvc.Controller;

public class Alunos extends Controller {
	
	public static void formAlunos() {
		render();
	}
	
	public static void salvar(Aluno a) {
	a.save();
	formAlunos();
	}
	
	public static void listarAlunos() {
		List<Aluno> lista = Aluno.findAll();
		render(lista);
	}
	
	public static void editar(long id) {
		Aluno a = Aluno.findById(id);
		renderTemplate("Alunos/formAlunos.html", a);
	}
	
	public static void deletar(long id) {
		Aluno a = Aluno.findById(id);
		a.delete();
		
		listarAlunos();
	}

}
