package controllers;

import java.util.List;


import java.util.UUID;

import models.Aluno;
import models.Professor;
import models.SalaVirtual;
import controllers.Alunos;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import play.db.jpa.GenericModel.JPAQuery;
import play.mvc.Controller;

public class SalasVirtuais extends Controller {
	
	public static void formSalasVirtuais() {
		render();
		
	}
	
	
	public static void detalhes(long id, SalaVirtual s) {
		
		SalaVirtual sala = SalaVirtual.findById(id);
		
		String idP = session.get("idProfessor");
		//System.out.println("Professor " + idP);
		Long idProfessor= Long.valueOf(idP);
		

		Professor professor = Professor.findById(idProfessor);
		
		sala.professores.add(professor);
		sala.save();
		
		renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, s);
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
		
		//String IDA = session.get("idAluno");
		
		System.out.println(idA);
		//Long idaluno= Long.valueOf(IDA);
	
		//Aluno aluno = Aluno.findById(idaluno);
		
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
	
	public static void salvar(SalaVirtual s) {
		s.save();	
		detalhes(s.id, s);	
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
		render();
	}
	
	public static void novaSalaVirtualAlunos(){
		render();
	}
	
	public static void entrarNovaSalaVirtual() {
		render();
	}
	

	
	
}
