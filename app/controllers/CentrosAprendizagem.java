package controllers;

import java.util.List;

import models.Aluno;
import models.CentroAprendizagem;
import models.SalaVirtual;
import play.modules.paginate.ValuePaginator;
import play.mvc.Controller;

public class CentrosAprendizagem extends Controller {

	
	public static void registro(Long salaVirtual){
		
		render(salaVirtual);		
	}
	
	public static void frequenciaAlunos(Long salaVirtual){

		System.out.println("id " +salaVirtual);
		SalaVirtual sala = SalaVirtual.findById(salaVirtual);
		List<Aluno> alunos = sala.alunos;
		ValuePaginator listaPaginadaAlunos = new ValuePaginator(alunos);
		listaPaginadaAlunos.setPageSize(10);
		render(listaPaginadaAlunos);
		
	}
	

	public static void salvar( CentroAprendizagem c, Long salaVirtual) {
		System.out.println("TESTE "+ salaVirtual);
		c.save();
		
		SalaVirtual sala = SalaVirtual.findById(c.idSalaVirtual);
		if(sala.centrosAprendizagem.contains(c) == false) {
			sala.centrosAprendizagem.add(c);
			sala.save();
		}
		List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;
		System.out.println(listaCas);
		renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, listaCas); 
				
	}
	
	public static void salvarFrequenciaAlunos(int frequencia, int participacao ) {
		
		System.out.println("Frequencia "+ frequencia);
		System.out.println("Participação "+participacao);
	
		
		
	}
}
