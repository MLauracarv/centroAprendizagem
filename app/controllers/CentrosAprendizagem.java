package controllers;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import models.Aluno;
import models.CentroAprendizagem;
import models.Frequencia;
import models.SalaVirtual;
import play.modules.paginate.ValuePaginator;
import play.mvc.Controller;

public class CentrosAprendizagem extends Controller {

	
	public static void registro(Long salaVirtual, long id){
		
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
				f.id_Sala = salaVirtual;
				f.save();
				
				Aluno a = Aluno.findById(alunos.get(i).id);
				System.out.println();
				System.out.println("NOME DO ALUNO "+a.nome);
				System.out.println("QUANTOS ELE TEM: " +a.pontos);
				a.pontos = a.pontos + f.grauFrequencia + f.grauParticipacao;
				System.out.println("aluno "+ a.nome);
				System.out.println("somaAluno: "+ f.somaAluno);
				System.out.println("QUAANTOS pontos ELE FICOU "+ a.pontos);
				a.save();
				System.out.println();
				}
		}

	
			render(id_CA, salaVirtual, listaPaginadaAlunos, alunos, frequencia);
			
	
	}
	
	
	
	/*public static void calcular(Frequencia f, Aluno a) {
		f.aluno = a;
		a.pontos = f.grauFrequencia + f.grauParticipacao;
		System.out.println("aluno "+ a);
		System.out.println("pontos "+ a.pontos);
		
		
		
		
	}*/
		
	public static void salvar( CentroAprendizagem c, Long idSalaVirtual) {
		
		
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
	
	public static void ranking(Long salaVirtual) {
		SalaVirtual sala = SalaVirtual.findById(salaVirtual);
		List<Aluno> alunos = sala.alunos;
		Collections.sort(alunos);
		
		System.out.println("LISTA ORDENADA");
		for(int a1 = 0; a1 < alunos.size(); a1++) {
			System.out.println(alunos.get(a1).nome+"---"+ alunos.get(a1).getPontosPorSala(salaVirtual));
		}
		
		render(alunos, salaVirtual);
	}

	
}