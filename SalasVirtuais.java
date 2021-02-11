package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import java.util.UUID;

import models.Aluno;
import models.CentroAprendizagem;
import models.Professor;
import models.SalaVirtual;
import controllers.Alunos;
import controllers.Professores;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import play.db.jpa.GenericModel.JPAQuery;
import play.modules.paginate.ValuePaginator;
import play.mvc.Controller;

public class SalasVirtuais extends Controller {
	
	public static void formSalasVirtuais() {
		render();
		
	}
	
	 public static void mostrarSalaProfessores(long id, SalaVirtual s) {
		 SalaVirtual sala = SalaVirtual.findById(id);
		 List<Aluno> salas = sala.alunos;
		 ValuePaginator listaPaginadaAlunos = new ValuePaginator(salas);
		 listaPaginadaAlunos.setPageSize(10);
		 
		 if(salas.isEmpty()) {
			listaPaginadaAlunos = null;
		}
		else {
			listaPaginadaAlunos = listaPaginadaAlunos; 
		}
		 List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;
		
			List<Aluno> alunos = sala.alunos;
			
			List<Aluno> listaAlunosRanking= new ArrayList<>();
			for(int a = 0; a < alunos.size(); a++) {
				System.out.println(alunos.get(a).nome+"---"+ alunos.get(a).getPontosPorSala(sala.id));
				listaAlunosRanking.add(alunos.get(a));
			}
			
			listaAlunosRanking.sort(new Comparator <Aluno>() {
			
				@Override
				public int compare(Aluno aluno1, Aluno aluno2) {
					if(aluno1.getPontosPorSala(sala.id) < aluno2.getPontosPorSala(sala.id)) {
						return 1;
						
					}
					if(aluno2.getPontosPorSala(sala.id) < aluno1.getPontosPorSala(sala.id) ) {
						return -1;
					}
					return 0;
		
				
			}
			});
			List <Aluno> listaPodio = new ArrayList<>();
			
			if(listaAlunosRanking.size() == 0) {
				listaPodio = null;
			}
			if(listaAlunosRanking.size() == 1) {
				for(Integer a = 0; a <1; a++) {
					listaPodio.add(listaAlunosRanking.get(a));
				}	
			}
			if(listaAlunosRanking.size() == 2) {
				for(Integer a = 0; a <2; a++) {
					listaPodio.add(listaAlunosRanking.get(a));
				}	
			}
			if(listaAlunosRanking.size() > 2) {
				
				for(Integer a = 0; a <3; a++) {
					listaPodio.add(listaAlunosRanking.get(a));
				}
			}
			
		
			
		
			
	
		 System.out.println("PODIO "+listaPodio);
		
		 long salaVirtual = sala.id;
		 renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, s, listaPaginadaAlunos, listaCas, listaAlunosRanking, listaPodio, salaVirtual);
	}
	
	 
	 public static void mostrarSalaAlunos(long id, SalaVirtual s) {
		 SalaVirtual sala = SalaVirtual.findById(id);
		 List<Aluno> alunos = sala.alunos;
		 ValuePaginator listaPaginadaAlunos = new ValuePaginator(alunos);
		 listaPaginadaAlunos.setPageSize(2);
		 
		 List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;
		 renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html", sala, s, listaPaginadaAlunos, listaCas);
		 
	}
		 
	
	public static void autenticarCodigo(String codigo, SalaVirtual s) {
		SalaVirtual salaVirtual= SalaVirtual.find("codigo = ?", codigo).first();
		
		String idA = session.get("idAluno");
		Long idTeste= Long.valueOf(idA);
		Aluno aluno = Aluno.findById(idTeste);
		
				if(salaVirtual== null) {
					SalasVirtuais.entrarNovaSalaVirtual();	
				}
				
				Long idSala = salaVirtual.id;
				SalaVirtual sala  = SalaVirtual.findById(idSala);
				s =  sala;
				
				if(s.alunos.contains(aluno) == false) {
					s.alunos.add(aluno);
					s.save();
				}
				
				List<Aluno> alunos = sala.alunos;
				ValuePaginator listaPaginadaAlunos = new ValuePaginator(alunos);
				listaPaginadaAlunos.setPageSize(10);
				
				renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html",  salaVirtual,listaPaginadaAlunos);			
	}
	
	public static void mostrarSala(long i) {
		SalaVirtual salaVirtual= SalaVirtual.findById(i);
		renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html",  salaVirtual);			
	}
	
	
	public static void salvar(SalaVirtual s) {
		if(s.id == null) {
			s.save();
			detalhes(s.id, s);	
		}
		else {
			s.save();
			SalaVirtual sala = s;
			List<Aluno> salas = sala.alunos;
			renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, s, salas);
		}
		
	}
	public static void listarSalasVirtuais() {
		List<SalaVirtual> lista = SalaVirtual.findAll();
		render(lista);
	}
	
	public static void editar(long id) {
		SalaVirtual s = SalaVirtual.findById(id);
		//List<Professor> professores = Professor.findAll();
		renderTemplate("SalasVirtuais/formSalasVirtuais.html", s);
	}
	
	public static void deletar(long id) {
		SalaVirtual s = SalaVirtual.findById(id);
		s.delete();
		indexProfessores();
	}
	public static void detalhes(long id, SalaVirtual s) {
		
		SalaVirtual sala = SalaVirtual.findById(id);
		String idP = session.get("idProfessor");
		Long idProfessor= Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
				
		if(sala.professores.contains(professor) == false) {
			sala.professores.add(professor);
			sala.save();
		}
		
		List<Aluno> salas = sala.alunos;
		ValuePaginator listaPaginadaAlunos = new ValuePaginator(salas);
		listaPaginadaAlunos.setPageSize(10);
		
		if(salas.isEmpty()) {
			listaPaginadaAlunos = null;
		}
		else {
			listaPaginadaAlunos = listaPaginadaAlunos; 
		}
		
		renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, s, salas, listaPaginadaAlunos);	
	}
		
	
	
	public static void novaSalaVirtual(Long id){
		System.out.println("mostrar id" + id);
		String idP = session.get("idProfessor");
		Long idProfessor= Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
		List <SalaVirtual> salas = professor.salasVirtuais;
		
		
		SalaVirtual sala= SalaVirtual.findById(id);
		List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;
		
		render(salas, listaCas);
		
		
	}
	
	public static void novaSalaVirtualAlunos(){
		
	
		
		render();
	}
	
		
	
	public static void entrarNovaSalaVirtual() {
		render();
		
	}

	public static void indexProfessores() {
		String idP = session.get("idProfessor");
		Long idProfessor= Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
		List <SalaVirtual> salas = professor.salasVirtuais;
		render(salas);
		
	}
	
}