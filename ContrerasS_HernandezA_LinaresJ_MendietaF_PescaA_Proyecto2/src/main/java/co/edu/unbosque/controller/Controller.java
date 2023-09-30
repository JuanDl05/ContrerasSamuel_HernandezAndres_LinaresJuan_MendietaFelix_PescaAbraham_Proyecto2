package co.edu.unbosque.controller;

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
	
	public Controller() {
		alDao = new AlcoholicDAO();
		psyDao = new PsychologistDAO();
		jDao = new JanitorDAO();
		run();
	}
	
	public void run() {
		user: while(true) {
			
		}
	}

}
