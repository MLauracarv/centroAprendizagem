package models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Frequencia extends Model {

	public String data;
	public Long id_aluno;
	public Long id_CA;
	public int grauParticipacao;
	public int grauFrequencia;
}
