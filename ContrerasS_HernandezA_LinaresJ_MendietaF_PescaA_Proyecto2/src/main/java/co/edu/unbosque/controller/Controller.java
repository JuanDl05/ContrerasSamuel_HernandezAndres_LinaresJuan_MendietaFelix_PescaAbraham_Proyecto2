package co.edu.unbosque.controller;

import java.util.Scanner;

import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.model.JanitorDTO;
import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.model.PsychologistDTO;
import co.edu.unbosque.model.persistence.AlcoholicDAO;
import co.edu.unbosque.model.persistence.JanitorDAO;
import co.edu.unbosque.model.persistence.PsychologistDAO;

public class Controller {

	private AlcoholicDAO alDao;
	private PsychologistDAO psyDao;
	private JanitorDAO jDao;
	private PersonDTO pDto;
	private AlcoholicDTO alDto;
	private PsychologistDTO psyDto;
	private JanitorDTO jDto;
	private Scanner sc;

	public Controller() {
		alDao = new AlcoholicDAO();
		psyDao = new PsychologistDAO();
		jDao = new JanitorDAO();
		sc = new Scanner(System.in);
		run();
	}

	public void run() {
		user: while (true) {
			System.out.println("Hola!, bienvenido");
			System.out.println("Ingreso de: ");
			System.out.println(" 1. Administrador \n 2. Alcoholico \n 3. Psicólogo \n 4. Conserje \n 5. Salir");
			System.out.println("-----------------------------------------");
			int option = sc.nextInt();
		}
	}

}
