package org.sid.web;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.sid.dao.PersonnelRepository;
import org.sid.dao.ResultatRepository;
import org.sid.entities.Personnel;
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
public class ResultatRestService {
	@Autowired
	private ResultatRepository resultatRepository;
	@Autowired
	private PersonnelRepository personneRepository;

	@RequestMapping(value = "/resultat/{id}",method = RequestMethod.POST,consumes = {"application/JSON"})
	public Resultat save (@RequestBody Resultat resultats,@PathVariable Long id){
	//System.out.println("A : "+resultats.getA()+" , G : "+resultats.getG()+" , N : "+resultats.getN()+" , E :"+resultats.getE());
		//System.out.println("p : "+resultats.getP());
		Optional<Personnel> p=this.personneRepository.findById(id);
		Personnel personne=p.orElseThrow(null);
		if(resultats.getDatetime()!=0)
		{	int i = resultats.getDatetime();
		System.out.println(resultats.getDatetime());
	    long minutes = TimeUnit.MILLISECONDS.toMinutes(i);
	    String dateminute=minutes+" minutes";
			personne.setDuree(dateminute);
		}else {
			personne.setDuree("Temps dépassé ");
		}
	
    // long seconds = (milliseconds / 1000);
  //  long seconds = TimeUnit.MILLISECONDS.toSeconds(i);
   // System.out.format("%d Milliseconds = %d minutes\n", i, minutes );
    System.out.println("Or");
   // System.out.format("%d Milliseconds = %d seconds", i, seconds );
    
//    String datemin=Long.toString(minutes);
    
    
    
		
		Resultat resultat=this.resultatRepository.save(resultats);
		personne.getResultat().add(resultat);
		
		this.personneRepository.save(personne);
		return resultats;
	}
	@RequestMapping(value = "/resultat",method = RequestMethod.GET)
	public List<Resultat> getResultat(){
		return resultatRepository.findAll();
		}
	
	
	
	public Personnel date(Personnel personn){
		
		Date date=new Date();

		personn.getDate();
		
		LocalTime l1 = personn.getDate().atZone(ZoneId.systemDefault()).toLocalTime();
		
		LocalTime l2 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
		System.out.println(l1);
	System.out.println(l2);
		long minutes = ChronoUnit.MINUTES.between(l1, l2);
		
		System.out.println(l2);
//		System.out.println(l1.until(l2, MINUTES));
//		System.out.println(MINUTES.between(l1, l2));
//		long t=l1.until(l2, MINUTES);
		
	
		

	     
	return personn;
	
		}
}
