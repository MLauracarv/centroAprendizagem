package models;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import antlr.collections.List;
import play.db.jpa.Model;

@Entity
public class Tabuleiro extends Model {
	public String nome;
	@OneToOne
	@JoinColumn(name="idSalaVirtual")
	public SalaVirtual salaVirtual;
}
