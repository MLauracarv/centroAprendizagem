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
		
		System.out.println("TESTEEEEE"+salaVirtual);
		SalaVirtual sala = SalaVirtual.findById(salaVirtual);
		List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;
		System.out.println(listaCas);
		render(salaVirtual,listaCas);		
	}
	

	public static void frequenciaAlunos( Long salaVirtual, Long id_CA, List<Integer> frequencia, List<Integer> participacao){
		ArrayList <Integer > teste = new ArrayList();
		
		SalaVirtual sala = SalaVirtual.findById(salaVirtual);
		List<Aluno> alunos = sala.alunos;
		
		
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
				f.soma = frequencia.get(i)+ participacao.get(i);
				
				f.save();
				System.out.println();
				
				teste.add(f.soma);
				
				
				}
				
				Collections.sort(teste);
			
				System.out.println("LISTA ORDENADA");
				for(Integer i1 = 0; i1 < teste.size(); i1++) {
				System.out.println("RESULTADO "+ teste.get(i1) );
				
				
				}	
			}
	
		
		
		
			render(id_CA, salaVirtual, listaPaginadaAlunos, alunos, frequencia);
		
		
	}
		
	public static void salvar( CentroAprendizagem c, Long idSalaVirtual) {
		c.save();
		
		SalaVirtual sala = SalaVirtual.findById(idSalaVirtual);
		if(sala.centrosAprendizagem.contains(c) == false) {
			sala.centrosAprendizagem.add(c);
			sala.save();
		}
		List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;
		System.out.println(listaCas);
		renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, listaCas); 
			
		
	}
	
	public static void ranking() {
		Aluno aluno;
		
		//Collections.sort(list<aluno> aluno);
		render();
	}

	
}