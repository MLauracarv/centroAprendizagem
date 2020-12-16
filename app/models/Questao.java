package models;

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
	public String respostaDiscursiva;
	public String comentario;
	public String tipoQuestao;
		
}
	