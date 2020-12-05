package models;

import enums.TipoExercicio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.mysql.jdbc.Blob;
import javax.persistence.Entity;
import play.db.jpa.Model;
import play.mvc.Scope.Session;

@Entity
public class Questao extends Model {
	public String enunciado;
	//public Blob imagem;
	public TipoExercicio tipoExercicio;
	public ArrayList alternativas;
	public String respostaDiscursiva;
	public String comentario;
	
	/*
	public static void definirTipo(String tipoExercicio) {
		if(objetiva != null) { 
			tipoExercicio = "objetiva";
		}else{
			tipoExercicio = "discursiva";
		}
		/*
		if (tipoExerc == "objetiva") {
			tipoExercicio = TipoExercicio.OBJETIVA;
			
		} else if (tipoExerc == "discursiva") {
			tipoExercicio = TipoExercicio.DISCURSIVA;
		}
		*/
	/*	
	public static void save() {
		// TODO Auto-generated method stub
		
	}
	*/
	
}