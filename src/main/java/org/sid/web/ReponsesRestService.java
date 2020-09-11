package org.sid.web;
import java.util.List;
import java.util.Optional;

import org.sid.dao.ReponsesRepository;
import org.sid.dao.ResultatRepository;
import org.sid.entities.Personnel;
import org.sid.entities.Reponses;
import org.sid.entities.Resultat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")	
public class ReponsesRestService {
	@Autowired
	private ReponsesRepository reponsesRepository;
	@Autowired
	private ResultatRepository resultatRepository;
	
	/*
	 * @RequestMapping(value = "/reponses",method = RequestMethod.POST) public
	 * Reponses save (@RequestBody Reponses r){ return reponsesRepository.save(r); }
	 */
	
	  @RequestMapping(value = "/reponses/{id}",method = RequestMethod.POST) public
	  Reponses save (@RequestBody Reponses r,@PathVariable Long id){
		  
	  Optional<Resultat> re=this.resultatRepository.findById(id); 
	  Resultat resultat=re.orElseThrow(null); 
	  resultat.setReponses(r);
	  
	  reponsesRepository.save(r); 
	  resultatRepository.save(resultat); 
	  return r;
	  }
	 
	@RequestMapping(value = "/reponses",method = RequestMethod.GET)
	public List<Reponses> getReponses(){
		return reponsesRepository.findAll();
		}
}
