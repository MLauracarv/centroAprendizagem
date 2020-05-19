package controllers;

import java.util.List;
import java.util.Random;

import play.mvc.Controller;

public class NumeroAleatorio extends Controller{
	
	public static int geradorDeNumerosAleatorios(String[] args) {
		
		Random numero = new Random();
	
		for(int contagem = 0; contagem < 1 ; contagem ++) {
			int valor = numero.nextInt();
			return valor;
		}
		render(numero);
		return 0;
	}

	//public static List<NumeroAleatorio> findAll() {
		// TODO Auto-generated method stub
		//return valor;
	//}

}


