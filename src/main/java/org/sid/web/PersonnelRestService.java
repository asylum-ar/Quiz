package org.sid.web;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.sid.dao.CommentaireRepository;
import org.sid.dao.PersonnelRepository;
import org.sid.entities.Commentaire;
import org.sid.entities.Personnel;
import org.sid.service.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")	

public class PersonnelRestService {
	@Autowired
	private PersonnelRepository PersonnelRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@RequestMapping(value = "/personnel",method = RequestMethod.GET)
	public List<Personnel> getPErsonnel(){
		
		return PersonnelRepository.findAllByOrderByIdAsc();
		}
	@RequestMapping(value = "/personnel",method = RequestMethod.POST)
	public Personnel save (@RequestBody Personnel p){

		p.setDate(LocalDateTime.now().atZone(ZoneId.of("GMT+1")).toLocalDateTime());
		
		
		return PersonnelRepository.save(p);
		}
	
	@RequestMapping(value = "/personnel/{id}",method = RequestMethod.GET)
	public List<Personnel> getPersonnel(@PathVariable Long id){
		Optional<Personnel> p=PersonnelRepository.findById(id);
		Personnel personne=p.orElseThrow(null);
		List<Personnel> list=new ArrayList<Personnel>();
		list.add(personne);
		return list;
		}
	@RequestMapping(value = "/personnel/{id}",method = RequestMethod.DELETE)
	public boolean supprimer (@PathVariable Long id){
		PersonnelRepository.deleteById(id);
		return true;
		}
	@RequestMapping(value = "/commentaire/{id}",method = RequestMethod.POST)
	public Personnel getCommentaire(@PathVariable Long id,@RequestBody Data data){
		
		
	
		Optional<Personnel> p=PersonnelRepository.findById(id);
		Personnel personne=p.orElseThrow(null);
		Commentaire com =new Commentaire(data.getCommentaire());
		com.setDate(new Date());
		
		 Date localTime = new Date();
		   
	     //creating DateFormat for converting time from local timezone to GMT
	     DateFormat converter = new SimpleDateFormat("HH:mm:ss");
	   
	     //getting GMT timezone, you can get any timezone e.g. UTC
	     converter.setTimeZone(TimeZone.getTimeZone("GMT+1"));
	     System.out.println("local time : " + localTime);
	     System.out.println("time in GMT : " + converter.format(localTime));

	     com.setTime(converter.format(localTime));
		com.setUser(data.getUser());
		commentaireRepository.save(com);

		personne.getCommentaire().add(com);
		
		PersonnelRepository.save(personne);
		return personne;
		}
	
	@RequestMapping(value = "/test",method = RequestMethod.POST)
	public String date(@RequestBody String date){
		
		
//		Optional<Personnel> p=PersonnelRepository.findById((long) 1);
//		Personnel personne=p.orElseThrow(null);
//		personne.getDate();
//		
//		LocalTime l1 = personne.getDate().atZone(ZoneId.systemDefault()).toLocalTime();
//		
//		LocalTime l2 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
//		System.out.println(l1);
//	System.out.println(l2);
//		long minutes = ChronoUnit.MINUTES.between(l1, l2);
//		
//		System.out.println(l2);
//		System.out.println(l1.until(l2, MINUTES));
//		System.out.println(MINUTES.between(l1, l2));
//		long t=l1.until(l2, MINUTES);
//		personne.setDuree(minutes);
//		PersonnelRepository.save(personne);
//		
//		LocalDateTime  l4 = personne.getDate().atZone(ZoneId.of("GMT+1")).toLocalDateTime();
//		LocalDateTime  l5 = date.toInstant().atZone(ZoneId.of("GMT+1")).toLocalDateTime();
//		long minutes = ChronoUnit.MINUTES.between(l4, l5);
//System.out.println(minutes);
//		
//		 Date localTime = new Date();
//		   
//	     //creating DateFormat for converting time from local timezone to GMT
//	     DateFormat converter = new SimpleDateFormat("HH:mm:ss");
//	   
//	     //getting GMT timezone, you can get any timezone e.g. UTC
//	     converter.setTimeZone(TimeZone.getTimeZone("GMT+1"));
//	     LocalDateTime fiveMinutes = LocalDateTime.of(2020, Month.APRIL,12 , 0, 20);
//	     
//
//	     LocalDateTime fiveMinutesLater = LocalDateTime.now().plusMinutes(20);
//	     Long minutesBetween=ChronoUnit.MINUTES.between(fiveMinutes,fiveMinutesLater);
//	     System.out.println("Diffrence between time in munutes : "+minutesBetween);
		int i = Integer.parseInt(date.trim());
	System.out.println(i);
    long minutes = TimeUnit.MILLISECONDS.toMinutes(i);
    // long seconds = (milliseconds / 1000);
    long seconds = TimeUnit.MILLISECONDS.toSeconds(i);
    System.out.format("%d Milliseconds = %d minutes\n", i, minutes );
    System.out.println("Or");
    System.out.format("%d Milliseconds = %d seconds", i, seconds );
    
//    String datemin=Long.toString(minutes);
    
    String d=minutes+" minutes";
    System.out.println(d);

	return  d;
	
		}
	
	

}
