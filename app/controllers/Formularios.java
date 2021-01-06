package controllers;
import models.Formulario;
import models.Questao;
import play.mvc.Controller;

public class Formularios extends Controller {
	public static void salvarFormulario(Formulario f, Questao q) {
		f.save();
	}
	
	public static void deletarFormulario(long id) {
		Formulario f = Formulario.findById(id);
		f.delete();
	}
}
