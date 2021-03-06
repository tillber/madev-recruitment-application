package se.madev.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.madev.main.integration.ApplicationRepository;
import se.madev.main.integration.CompetenceRepository;
import se.madev.main.integration.StatusRepository;
import se.madev.main.model.Application;
import se.madev.main.model.Competence;

/**
 * Controller used for application related services.
 * @author madev
 *
 */
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class ApplicationService {

	@Autowired
	CompetenceRepository competenceRepository;

	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	/**
	 * Retrieves all of the competences in the database.
	 */
	public List<Competence> getCompetences(){
		List<Competence> competences = competenceRepository.findAll();
		return competences;
	}
	
	/**
	 * Retrieves all of the applications from the database.
	 */
	public List<Application> getApplications(){
		List<Application> applications = applicationRepository.findAll();
		return applications;
	}
	
	/**
	 * Saves the given application to the database.
	 */
	public void saveApplication(Application application) {
		System.err.println(application.getExperience());
		application.setStatus(statusRepository.findByType(application.getStatus().getType()));
		applicationRepository.save(application);
	}
}
