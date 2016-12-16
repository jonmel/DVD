package fi.haagahelia.mel.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.mel.domain.DVDstore;
import fi.haagahelia.mel.domain.Reservation;
import fi.haagahelia.mel.domain.GenreRepository;
import fi.haagahelia.mel.domain.MemberStatusRepository;
import fi.haagahelia.mel.domain.DVDstoreRepository;
import fi.haagahelia.mel.domain.ReservationRepository;

@Controller
public class DVDstoreController {
	
	@Autowired
	private DVDstoreRepository dvdstorerepository; 
	
	@Autowired
	private ReservationRepository reservationrepository; 

	@Autowired
	private GenreRepository genrerepository; 
	
	@Autowired
	private MemberStatusRepository memberstatusrepository; 
	
	
	@RequestMapping(value="/login")
	public String login() {	
	    return "login";
	    }	
	
	@RequestMapping(value="/api")
	public String api() {	
	    return "api";
	    }	
	
	@RequestMapping(value="/logout")
	public String logout() {	
	    return "login";
	    }	
  
    @RequestMapping(value="/DVDlist")
    public String DVDList(Model model) {	
        model.addAttribute("DVDs", dvdstorerepository.findAll());
        model.addAttribute("DVDs1", reservationrepository.findAll());
        return "DVDlist" ;
    }

    @RequestMapping(value = "/add")
    public String addDVD(Model model){
    	model.addAttribute("DVD", new DVDstore());
    	model.addAttribute("genre", genrerepository.findAll());
        return "addDVD";
    }   
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(DVDstore DVD){
        dvdstorerepository.save(DVD);
        return "redirect:DVDlist";
     
    }    
 
    @RequestMapping(value = "/add1")
    public String addDVD1(Model model){
    	model.addAttribute("DVD1", new Reservation());
    	model.addAttribute("DVDs", dvdstorerepository.findAll());
    	model.addAttribute("MemberStatus", memberstatusrepository.findAll());
        return "addreservation";
    }     
    
    @RequestMapping(value = "/save1", method = RequestMethod.POST)
    public String save1(Reservation DVD1){
        reservationrepository.save(DVD1);
        return "redirect:dvdlist";
              
    }  
     
     
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteDVD(@PathVariable("id") Long DVDId, Model model) {
    	dvdstorerepository.delete(DVDId);
        return "redirect:../DVDlist";
    }     
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete1/{id1}", method = RequestMethod.GET)
    public String deleteDVD1(@PathVariable("id1") Long DVDId1, Model model1) {
    	reservationrepository.delete(DVDId1);
        return "redirect:../DVDlist";
   
    }  
}