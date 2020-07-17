package controllers;

import java.util.List;


import java.util.UUID;

import models.Aluno;
import models.Professor;
import models.SalaVirtual;
import controllers.Alunos;
import controllers.Professores;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import play.db.jpa.GenericModel.JPAQuery;
import play.mvc.Controller;

public class SalasVirtuais extends Controller {
	
	public static void formSalasVirtuais() {
		render();
		
	}
	
	 public static void mostrarSalaProfessores(long id, SalaVirtual s) {
		 SalaVirtual sala = SalaVirtual.findById(id);
		 List<Aluno> salas = sala.alunos;
		 renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, s, salas);
	}
	 
	 public static void mostrarSalaAlunos(long id, SalaVirtual s) {
		 SalaVirtual sala = SalaVirtual.findById(id);
		 renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html", sala, s);
	}
	 
	
	
	public static void editar(long id) {
		SalaVirtual s = SalaVirtual.findById(id);
		List<Professor> professores = Professor.findAll();
	
		renderTemplate("SalasVirtuais/formSalasVirtuais.html", s, professores);
	}
	
	public static void autenticarCodigo(String codigo, SalaVirtual s) {
		SalaVirtual salaVirtual= SalaVirtual.find("codigo = ?", codigo).first();
		
		
		String idA = session.get("idAluno");
		Long idTeste= Long.valueOf(idA);
		Aluno aluno = Aluno.findById(idTeste);
		
				if(salaVirtual== null) {
					SalasVirtuais.entrarNovaSalaVirtual();	
				}
				
					
				Long idSala = salaVirtual.id;
				SalaVirtual sala  = SalaVirtual.findById(idSala);
				s =  sala;
				
				if(s.alunos.contains(aluno) == false) {
					s.alunos.add(aluno);
					s.save();
				}
				
		renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html",  salaVirtual);			
	}
	
	public static void mostrarSala(long i) {

		System.out.println("IDDD "+ i);
		SalaVirtual salaVirtual= SalaVirtual.findById(i);
		
		renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html",  salaVirtual);			
	}
	
	
	public static void salvar(SalaVirtual s) {
		
		if(s.id == null) {
			s.save();
			
			detalhes(s.id, s);	
		}
		else {
			s.save();
			SalaVirtual sala = s;
			List<Aluno> salas = sala.alunos;
			renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, s, salas);
		}
		
	}
	public static void detalhes(long id, SalaVirtual s) {
		
		SalaVirtual sala = SalaVirtual.findById(id);
		
		String idP = session.get("idProfessor");
		Long idProfessor= Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
				
		if(sala.professores.contains(professor) == false) {
			sala.professores.add(professor);
			sala.save();
		}
		
		List<Aluno> salas = sala.alunos;
		
		renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, s, salas);	
	}
		
	public static void listarSalasVirtuais() {
		List<SalaVirtual> lista = SalaVirtual.findAll();
		render(lista);
	}
	
	public static void deletar(long id) {
		SalaVirtual s = SalaVirtual.findById(id);
		s.delete();
		listarSalasVirtuais();
	}
	
	public static void novaSalaVirtual(){
		
		String idP = session.get("idProfessor");
		Long idProfessor= Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
		List <SalaVirtual> salas = professor.salasVirtuais;
		render(salas);
	}
	
	public static void novaSalaVirtualAlunos(){
		render();
	}
	
	public static void entrarNovaSalaVirtual() {
		render();
		
	}
	public static void mostrarListaAlunos(long id) {
		String idP = session.get("idProfessor");
		Long idProfessor= Long.valueOf(idP);
		id= 2;
		SalaVirtual sala = SalaVirtual.findById(id);
		List<Aluno> alunos = sala.alunos;
		
		render(alunos);
		renderTemplate("SalasVirtuais/novaSalaVirtual", alunos);	
	}
	

	
}