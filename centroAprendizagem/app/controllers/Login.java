package controllers;


import models.Aluno;
import models.Professor;
import models.SalaVirtual;
import play.mvc.Controller;

public class Login extends Controller {
	
	public static void logout() {
		session.clear();
		PainelLoginUsuario.index();
	}
	
	public static void autenticar(String email, String senha) {
		
	Professor professor= Professor.find("email = ? and senha = ?", email , senha).first();
	Aluno aluno = Aluno.find("email = ? and senha = ?", email , senha).first();
	
	
		if(professor == null & aluno == null) {
			PainelLoginUsuario.index();
		} else {
			if (professor != null){
			session.put("nomeProfessor", professor.nome);
			session.put("matriculaProfessor", professor.matricula);
			session.put("emailProfessor", professor.email);
			session.put("idProfessor", professor.id);
			SalasVirtuais.indexProfessores();
			}
			else {
			session.put("nomeAluno", aluno.nome);
			session.put("matriculaAluno", aluno.matricula);
			session.put("emailAluno", aluno.email);
			session.put("idAluno", aluno.id);
			Alunos.indexAlunos();
			}
		}
	}
	
	
	
}
		

