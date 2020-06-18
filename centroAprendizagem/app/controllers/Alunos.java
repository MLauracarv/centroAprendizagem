package controllers;


import java.util.List;
import java.util.UUID;

import models.Aluno;
import models.Professor;
import models.SalaVirtual;
import play.mvc.Controller;

public class Alunos extends Controller {
	
	public static void formAlunos() {
		render();
	}
	
	public static void salvar(Aluno a) {
	a.save();
	Login.autenticar(a.email, a.senha);
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
	public static void indexAlunos() {
		//Long idProfessor = 10;
		//Professor professor = Professor.findById(idProfessor);
		//List<Projeto> projetosProfessor = professor.projetos
		
		String idA = session.get("idAluno");
		Long idAluno= Long.valueOf(idA);
		Aluno aluno = Aluno.findById(idAluno);
		List <SalaVirtual> salas = aluno.salasVirtuais;
		
		System.out.println("Salassss: "+ aluno.salasVirtuais);
		
	
		
		render( salas);
	}
	
	
	}
	
	
	
	
	


