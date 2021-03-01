package controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import models.Aluno;
import models.CentroAprendizagem;
import models.Frequencia;
import models.SalaVirtual;
import play.data.validation.Valid;
import play.modules.paginate.ValuePaginator;
import play.mvc.Before;
import play.mvc.Controller;

public class CentrosAprendizagem extends Controller {
	@Before(only = {"frequenciaAlunos", "ranking", "registro", "tabelaFrequencia"})
	static void rentringirSalaAoProfessor() {
		if (session.get("tipoUsuario") != null && !session.get("tipoUsuario").equalsIgnoreCase("Professor")) {
			Restricoes.restricoesAlunos();
		}
	}
	
	public static void registro(Long salaVirtual){
		
		SalaVirtual sala = SalaVirtual.findById(salaVirtual);
		List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;
		System.out.println(listaCas);
		render(salaVirtual,listaCas);		
	}
	

	public static void frequenciaAlunos( Long salaVirtual, Long id_CA, List<Integer> frequencia, List<Integer> participacao){
		ArrayList <Integer > teste = new ArrayList();
		
		SalaVirtual sala = SalaVirtual.findById(salaVirtual);
		List<Aluno> alunos = sala.alunos;
		Integer pontos = 0;
		
		ValuePaginator listaPaginadaAlunos = new ValuePaginator(alunos);
		listaPaginadaAlunos.setPageSize(10);
		
		if( frequencia != null) {
			
			for(Integer i = 0; i < alunos.size(); i++) {
				
				
				System.out.println("ID ALUNO "+ alunos.get(i).id);
				System.out.println("Nome: "+ alunos.get(i) + " Frequencia " + frequencia.get(i) + " Participação " + participacao.get(i));
				 
				Aluno aluno = Aluno.findById(alunos.get(i).id);
				CentroAprendizagem centro = CentroAprendizagem.findById(id_CA);
				Frequencia f = new Frequencia();
				
				
				System.out.println(f.grauFrequencia = frequencia.get(i));
				System.out.println(f.grauParticipacao = participacao.get(i));
				f.centroAprendizagem = centro;
				f.aluno = aluno;
				f.salas = sala;
				//f.id_Sala = salaVirtual;
				f.save();
				
				Aluno a = Aluno.findById(alunos.get(i).id);
				System.out.println();
				System.out.println("NOME DO ALUNO "+a.nome);
				System.out.println("QUANTOS ELE TEM: " +a.pontos);
				a.pontos = a.pontos + f.grauFrequencia + f.grauParticipacao;
				System.out.println("aluno "+ a.nome);
				
				System.out.println("QUAANTOS pontos ELE FICOU "+ a.pontos);
				a.save();
				System.out.println();
				}
		}

	
			render(id_CA, salaVirtual, listaPaginadaAlunos, alunos, frequencia);
			
	
	}
	
		
	public static void salvar(@Valid CentroAprendizagem c, Long idSalaVirtual) {
		if (validation.hasErrors()) {
			validation.keep();
			params.flash();
			registro(idSalaVirtual);
		}
		
		System.out.println("ID SA DA SALA "+idSalaVirtual);
		c.save();
		
		
		SalaVirtual sala = SalaVirtual.findById(idSalaVirtual);
		if(sala.centrosAprendizagem.contains(c) == false) {
			sala.centrosAprendizagem.add(c);
			c.salaVirtual = sala;
			sala.save();
			c.save();
		}
		List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;
		System.out.println(listaCas);
		renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, listaCas); 
			
		
	}
	
	public static void serializarDados(Long idSala) {
		SalaVirtual sala = SalaVirtual.findById(idSala);
		List <Aluno> alunosDaSala = sala.alunos;
		System.out.println(sala);
		//int pontosAlunos[] = new int[alunosDaSala.size()];
		for (int c = 0; c < alunosDaSala.size(); c++) {
			alunosDaSala.get(c).pontuacaoPorCA = 0;
			alunosDaSala.get(c).pontuacaoPorCA = alunosDaSala.get(c).getPontosPorSala(idSala);
			
			
		}
			System.out.println(alunosDaSala.size());
			Gson gson = new GsonBuilder().create();
			gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			//List <Aluno> alunosDaSala = salaVirtual.alunos;
			String result = gson.toJson(alunosDaSala);
			renderJSON(result);
			render(idSala);
	}
	
	public static void ranking(Long salaVirtual) {
		SalaVirtual sala = SalaVirtual.findById(salaVirtual);
		List<Aluno> alunos = sala.alunos;
		
		List<Aluno> listaAlunos= new ArrayList<>();
		for(int a = 0; a < alunos.size(); a++) {
			System.out.println(alunos.get(a).nome+"---"+ alunos.get(a).getPontosPorSala(salaVirtual));
			listaAlunos.add(alunos.get(a));
		}
		/**/
		//serializarDados(sala);
		listaAlunos.sort(new Comparator <Aluno>() {
		
			@Override
			public int compare(Aluno aluno1, Aluno aluno2) {
				System.out.println("TESTE 1 "+ aluno1);
				System.out.println("TESTE 2 "+ aluno2);
				System.out.println("");
				if(aluno1.getPontosPorSala(salaVirtual) < aluno2.getPontosPorSala(salaVirtual)) {
					return 1;
					
				}
				if(aluno2.getPontosPorSala(salaVirtual) < aluno1.getPontosPorSala(salaVirtual) ) {
					return -1;
				}
				return 0;
	
			
		}
		});
		
		
		System.out.println("TESTEEE: LISTA ORDENADA");
		System.out.println(listaAlunos);
		System.out.println(listaAlunos.size());
	
		render(salaVirtual, listaAlunos);
	}
	
	public static void tabelaFrequencia(Long salaVirtual) {
		
		SalaVirtual sala = SalaVirtual.findById(salaVirtual);
		List<Aluno> alunos = sala.alunos;
		
		for(int a1 = 0; a1 < alunos.size(); a1++) {
			System.out.println(alunos.get(a1).nome+"---"+ alunos.get(a1).getFrequencia(salaVirtual));
			alunos.get(a1).getFrequencia(salaVirtual);
		}	
		render(alunos, salaVirtual);
	}
}
