package models;
import java.util.ArrayList;

import controllers.Questoes;
import play.db.jpa.Model;

public class Formulario extends Model {
	public String titulo;
	public ArrayList<Questoes> questao;
}
