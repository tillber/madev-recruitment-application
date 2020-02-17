package se.madev.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.madev.main.integration.CompetenceRepository;
import se.madev.main.model.Competence;

@Service
public class ApplicationService {


	@Autowired
	CompetenceRepository competenceRepository;

	//@Autowired
	//ApplicationRepository applicationRepository;
	
	public List<Competence> getCompetences(){
		List<Competence> competence = competenceRepository.findAll();

		return competence;
	}
}