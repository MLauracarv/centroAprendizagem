package controllers;


import java.util.Random;
import java.util.UUID;

import play.mvc.Controller;



	public class Codigo extends Controller{
	
		public static String geradorDeCodigos(String[] args) {
		UUID codigo= UUID.randomUUID();
		
			if (codigo.toString().length() > 10) {
			return codigo.toString().substring(0, 8);	
			}
			render(codigo);
			return null;
	
		}
		
		
	}
	
	
	




