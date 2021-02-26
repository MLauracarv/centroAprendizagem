package controllers;
import models.SalaVirtual;
import models.Tabuleiro;
import play.mvc.Controller;

public class Tabuleiros extends Controller {
	public static void indexTabuleiro() {
		render();
	}
	
	public static void formTabuleiro(Long salaVirtual) {
		Tabuleiro tabuleiro1 = Tabuleiro.find("idSalaVirtual = ?", salaVirtual).first();
		if(tabuleiro1 == null ) {
			System.out.println("");
			System.out.println("ESSE TABULEIRO NAO EXISTEEEE ");
			System.out.println("");
		}
		else {
			System.out.println("Esse tabuleiro existe. n crie outro!");
			indexTabuleiro();
		}
		render(salaVirtual);
	}
	
	public static void salvarTabuleiro(Tabuleiro t, Long idSala) {
		SalaVirtual sala = SalaVirtual.findById(idSala);
		t.salaVirtual = sala;
		t.save();
		renderTemplate("Tabuleiros/indexTabuleiro.html");
	}
}	
