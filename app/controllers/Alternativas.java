package controllers;

import models.Alternativa;
import play.mvc.Controller;

public class Alternativas extends Controller {
	public static void salvarAlternativas(Alternativa a) {
		a.save();
	}
}
