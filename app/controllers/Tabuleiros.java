package controllers;
import models.SalaVirtual;
import models.Tabuleiro;
import play.mvc.Controller;

public class Tabuleiros extends Controller {
	public static void indexTabuleiroAlunos(Long idSala) {
		Tabuleiro tabuleiro1 = Tabuleiro.find("idsalaVirtual = ?", idSala).first();
		if (tabuleiro1 != null) {
			render();
		} else {
			System.out.println("Esse tabuleiro não existe");
			renderTemplate("Tabuleiros/AvisoTabuleiro.html");
		}
	}
	
	public static void indexTabuleiro() {
		//Tabuleiro tabuleiro1 = Tabuleiro.find("idSalaVirtual = ?", salaVirtual).first();
		render();
	}
	
public static void formTabuleiro(Long salaVirtual, Tabuleiro tabuleiro) {
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
	
	
	public static void salvarTabuleiro(Long idSala, Tabuleiro t) {
		SalaVirtual sala = SalaVirtual.findById(idSala);	
		t.salaVirtual = sala;
		t.save();
		renderTemplate("Tabuleiros/indexTabuleiro.html");
	}
}	