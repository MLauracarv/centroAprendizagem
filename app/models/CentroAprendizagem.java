package models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class CentroAprendizagem extends Model{
	
	public String data;
	public String horario;
	public String assunto;
	public String local;
	
	
	@ManyToOne
	@JoinColumn(name="idSalaVirtual")
	public SalaVirtual salaVirtual;
	
	

}
