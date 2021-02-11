/*package controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Aluno;
import models.Frequencia;
import models.Professor;
import models.SalaVirtual;
import play.mvc.Controller;

public class Alunos extends Controller {
	
	
	public static void formAlunos() {
		render();
	}
	
	public static void salvar(Aluno a) {
	a.save();
	Login.autenticar(a.email, a.senha);
	}
	
	public static void listarAlunos() {
		List<Aluno> lista = Aluno.findAll();
		render(lista);
	}
	
	public static void editar(long id) {
		Aluno a = Aluno.findById(id);
		renderTemplate("Alunos/formAlunos.html", a);
	}
	
	public static void deletar(long id) {
		Aluno a = Aluno.findById(id);
		a.delete();
		listarAlunos();
	}
	public static void indexAlunos() {
		
		String idA = session.get("idAluno");
		Long idAluno= Long.valueOf(idA);
		Aluno aluno = Aluno.findById(idAluno);
		List <SalaVirtual> salas = aluno.salasVirtuais;
		render( salas);
		
	}
	
	static Integer soma = 0;
	public static void calcularPontuacao(long idAluno, long id_CA, Aluno a, Frequencia freq) {
		//Integer soma = a.soma;
		//soma = Aluno.soma;
		//System.out.println("SOMA TOTAL " +soma);	
		ArrayList <Integer > var= new ArrayList();
		var.add(freq.grauFrequencia + freq.grauParticipacao);
		
		for(int i=0; i<var.size(); i++) {
			soma += var.get(i);
			
			
		}

	}
	
	
	}
*/



package controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Aluno;
import models.Frequencia;
import models.Professor;
import models.SalaVirtual;
import play.mvc.Controller;

public class Alunos extends Controller {
	
	
	private static final Object Terça = null;
	public static void formAlunos() {
		render();
	}
	
	public static void salvar(Aluno a) {
	a.save();
	Login.autenticar(a.email, a.senha);
	}
	
	public static void listarAlunos() {
		List<Aluno> lista = Aluno.findAll();
		render(lista);
	}
	
	public static void editar(long id) {
		Aluno a = Aluno.findById(id);
		renderTemplate("Alunos/formAlunos.html", a);
	}
	
	public static void deletar(long id) {
		Aluno a = Aluno.findById(id);
		a.delete();
		listarAlunos();
	}
	public static void indexAlunos() {
		
		String idA = session.get("idAluno");
		Long idAluno= Long.valueOf(idA);
		Aluno aluno = Aluno.findById(idAluno);
		List <SalaVirtual> salas = aluno.salasVirtuais;
		
		
		//tabela resumo
		List <SalaVirtual> salasAlunos = aluno.salasVirtuais;
		System.out.println("ver salas   "+salasAlunos);
		List <SalaVirtual> salasAlunosSegunda =  new ArrayList();
		List <SalaVirtual> salasAlunosTerça =  new ArrayList();
		List <SalaVirtual> salasAlunosQuarta = new ArrayList();
		List <SalaVirtual> salasAlunosQuinta = new ArrayList();
		List <SalaVirtual> salasAlunosSexta = new ArrayList();
		
		//System.out.println("DIAAAAAS "+salasAlunos.get(1).getDia());
		
		for(int a = 0; a < salasAlunos.size(); a++) {
			System.out.println("dia que ta pegando "+ salasAlunos.get(a).dia);
		
			System.out.println(salasAlunos.get(a).dia.equals("Terça"));
			
			
			
			
			if(salasAlunos.get(a).dia.equals("Segunda")){
				System.out.println("Mensagem"+ salasAlunos.get(a).dia );
				salasAlunosSegunda.add(salasAlunos.get(a));	
			}
			if(salasAlunos.get(a).dia.equals("Terça")){
				System.out.println("add Terça");
				salasAlunosTerça.add(salasAlunos.get(a));
				System.out.println("add Terça");
			}
			if(salasAlunos.get(a).dia.equals("Quarta")){
				System.out.println("add Quarta");
				salasAlunosQuarta.add(salasAlunos.get(a));
			}
			if(salasAlunos.get(a).dia.equals("Quinta")){
				System.out.println("add Quinta");
				salasAlunosQuinta.add(salasAlunos.get(a));
			}
			if(salasAlunos.get(a).dia.equals("Sexta")){
				System.out.println("add sexta");
				salasAlunosSexta.add(salasAlunos.get(a));
			}
			
		}
		
		System.out.println("seg "+salasAlunosSegunda);
		System.out.println("Ter " + salasAlunosTerça);
		System.out.println("Qua "+salasAlunosQuarta);
		System.out.println("Qui "+salasAlunosQuinta);
		System.out.println("Sex "+salasAlunosSexta);
		
		System.out.println("size");
		System.out.println("seg "+salasAlunosSegunda.size());
		System.out.println("Ter " + salasAlunosTerça.size());
		System.out.println("Qua "+salasAlunosQuarta.size());
		System.out.println("Qui "+salasAlunosQuinta.size());
		System.out.println("Sex "+salasAlunosSexta.size());
		
	
		if(salasAlunosSegunda.size() == 0) {
			System.out.println("seg é nulo. sala: "+salasAlunosSegunda);
			salasAlunosSegunda = null;
			System.out.println("seg no if  "+ salasAlunosSegunda);
		}
		else {
			
		}
		
		if(salasAlunosTerça.size() == 0) {
			salasAlunosTerça= null;
			System.out.println("ter no if  "+ salasAlunosTerça);
		}
		else {
			
		}
		
		if(salasAlunosQuarta.size() == 0) {
			salasAlunosQuarta= null;
			System.out.println("quar no if  "+ salasAlunosQuarta);
		}
		else {
			
		}
		
		if(salasAlunosQuinta.size() == 0) {
			salasAlunosQuinta= null;
			System.out.println("quin no if  "+ salasAlunosQuinta);
		}
		else {
			
		}
		
		if(salasAlunosSexta.size() == 0) {
			salasAlunosSexta= null;
			System.out.println("sex no if  "+ salasAlunosSexta);
		}
		else {
			
		}
		
		render( salas, salasAlunosSegunda, salasAlunosTerça, salasAlunosQuarta, salasAlunosQuinta, salasAlunosSexta);
		
		
	
		
	}
	
	static Integer soma = 0;
	public static void calcularPontuacao(long idAluno, long id_CA, Aluno a, Frequencia freq) {
		//Integer soma = a.soma;
		//soma = Aluno.soma;
		//System.out.println("SOMA TOTAL " +soma);	
		ArrayList <Integer > var= new ArrayList();
		var.add(freq.grauFrequencia + freq.grauParticipacao);
		
		for(int i=0; i<var.size(); i++) {
			soma += var.get(i);
			
			
		}

	}
	
	
	}