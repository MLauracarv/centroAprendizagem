package controllers;

import java.util.List;


import java.util.UUID;

import models.Aluno;
import models.Professor;
import models.SalaVirtual;
import controllers.Alunos;
import play.db.jpa.GenericModel.JPAQuery;
import play.mvc.Controller;

public class SalasVirtuais extends Controller {
	
	public static void formSalasVirtuais() {
		render();
	}
	
	public static void detalhes(long id, SalaVirtual s) {
		SalaVirtual sala = SalaVirtual.findById(id);
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
		Long idAluno= Long.valueOf(idA);
		
				if(salaVirtual== null) {
					SalasVirtuais.entrarNovaSalaVirtual();	
				}
				Aluno aluno = Aluno.findById(idAluno);
					
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
