package controllers;

import models.Alternativa;
import models.Questao;
import play.mvc.Controller;

public class Questoes extends Controller{
	
	public static void salvarQuestao(Questao questao) {
		questao.save();
	}
	
	public static void salvarAlt(Alternativa alt) {
		alt.save();
	}
}
