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
	
	public static void autenticarCodigo(String codigo, Long id, SalaVirtual s) {
		

		SalaVirtual salaVirtual= SalaVirtual.find("codigo = ?", codigo).first();
				
			if(salaVirtual == null) {
				SalasVirtuais.entrarNovaSalaVirtual();
				
			}
			
		
			renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html", salaVirtual);
				}
	
	//SalaVirtual s = SalaVirtual.findById(id);
	//List<Professor> professores = Professor.findAll();
	
	
	//String teste = autenticarCodigo(null);
	
	
	//public static void detalhamento(Long id, SalasVirtuais autenticarCodigo ) {
	//	SalaVirtual sala = SalaVirtual.findById(id);
	//	renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html", sala);
	

	//}
	
	//public static void detalhamento(Long id, SalasVirtuais autenticarCodigo ) {
	//	SalaVirtual sala = SalaVirtual.findById(id);
	//	renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html", sala);
	

	//}
	
	public static void salvar(SalaVirtual s) {
		s.save();	
		detalhes(s.id, s);	
		
		//detalhamento(null, s);
	}
	
	
	
	
	
	
	//public static void enviar(String codigo) {
	//	SalaVirtual sala = SalaVirtual.findById(codigo);
	//}
	
	
	
	//public static void enviar(String codigo) {
	//	SalaVirtual s = SalaVirtual.find(codigo);
	//}
	//public static String autenticarCodigo(String codigo) {
		
	//	SalaVirtual salaVirtual= SalaVirtual.find("codigo = ?", codigo).first();
		
	//		if(salaVirtual == null) {
	//			Alunos.entrarNovaSalaVirtual();
	//			return null;
	//		}
	//		else {
				
	//			SalasVirtuais.novaSalaVirtualAlunos();
	//			return codigo;
				
	//		}
	//}

	 
	//public static void detalhamento(String codigo) {
		// TODO Auto-generated method stub
		
	//}

	//import controllers.Alunos;
	//public static SalaVirtual detalhamento(   ) {
		//return null;
		
		//if(codigo == s.codigo ) {
		//	return s;
		//}
		//else {
		//	return null;
		//}
	//}
	
	
	
	//public static void detalhamento(Long id, SalaVirtual s) {
	//	SalaVirtual sala = SalaVirtual.findById(id);
	//	renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html", sala, s);
		
	//}

		
	public static void listarSalasVirtuais() {
		List<SalaVirtual> lista = SalaVirtual.findAll();
		render(lista);
	}
	
	public static void editar(long id) {
		SalaVirtual s = SalaVirtual.findById(id);
		List<Professor> professores = Professor.findAll();
		renderTemplate("SalasVirtuais/formSalasVirtuais.html", s, professores);
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
