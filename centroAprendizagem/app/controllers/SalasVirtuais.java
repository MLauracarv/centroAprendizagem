package controllers;

import java.util.List;

import models.SalaVirtual;
import play.mvc.Controller;

public class SalasVirtuais extends Controller {
	
	public static void formSalasVirtuais() {
		render();
	}
	public static void salvar(SalaVirtual s) {
		s.save();
		SalasVirtuais.formSalasVirtuais();
	}
	

	
	public static void listarSalasVirtuais() {
		List<SalaVirtual> lista = SalaVirtual.findAll();
		render(lista);
	}
	
	public static void editar(long id) {
		SalaVirtual s = SalaVirtual.findById(id);
		renderTemplate("SalasVirtuais/formSalasVirtuais.html", s);
	}
	
	public static void deletar(long id) {
		SalaVirtual s = SalaVirtual.findById(id);
		s.delete();
		
		listarSalasVirtuais();
	}
	
}
