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
	
	public static void frequenciaAlunos(Long salaVirtual, Long id_CA, Long frequencia,Long participacao, Long id_Aluno){
		
		Long frequencia1 = frequencia;
		int n = 10; // tamanho do vetor
		Long[] v = new Long[n]; 
		int i; // índice ou posição

		for (int z = 0; z<2; z++) {
			System.out.println("MOSTRE z "+ z);
			for (i=0; i<n; i++) {
				v[0] = salaVirtual; 
				v[1] = id_CA;
				v[2] = frequencia1; 
				v[3] = participacao; 
				v[4] = id_Aluno;
		  
			}
			System.out.println();
			System.out.println("TESTE");
			System.out.println("MOSTRE i "+ i);
			System.out.println("SALA " + v[0] );
			System.out.println("ID_CA " + v[1] );
			System.out.println("FREQUENCIA " + v[2] );
			System.out.println("PARTICIPAÇÃO " + v[3] );
			System.out.println("ID_ ALUNO " + v[4] );
			System.out.println();
		
		}
	
	  
		//System.out.println("TA CHEGANDO F:"+frequencia1+" p "+ participacao+ " id "+ id_Aluno);
		
		//System.out.println("id: " +id_CA);
		
		//System.out.println("idSALA " +salaVirtual);
		
		SalaVirtual sala = SalaVirtual.findById(salaVirtual);
		List<Aluno> alunos = sala.alunos;
		
		ValuePaginator listaPaginadaAlunos = new ValuePaginator(alunos);
		listaPaginadaAlunos.setPageSize(10);
		//salvarFrequenciaAlunos(frequencia, participacao, id);
		render(listaPaginadaAlunos, salaVirtual, sala);
		//salvarFrequenciaAlunos(frequencia, 0, id_CA);
		
	}
		
	

	public static void salvar( CentroAprendizagem c, Long salaVirtual) {
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
	
	public static void salvarFrequenciaAlunos(int frequencia, int participacao, Long id ) {
		
		System.out.println("Frequencia "+ frequencia);
		System.out.println("Participação "+participacao);
		System.out.println("IDDDDD "+id);

	
		
		
	}
}
