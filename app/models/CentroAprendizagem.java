package models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class CentroAprendizagem extends Model{
	
	public String data;
	public String horario;
	public String assunto;
	public String local;
	public Long idSalaVirtual;
	
	@ManyToMany(mappedBy="centrosAprendizagem")
	public List<SalaVirtual> salasVirtuais;
	
	

}
