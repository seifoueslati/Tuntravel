package com.ensat.controllers;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.management.Query;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.entities.Bagage;
import com.ensat.repositories.BagageRepository;
import com.ensat.services.BagageService;
import com.ensat.services.EmailService;

import antlr.collections.List;

@Controller
public class BagageController {

	
	
	
	
	  private BagageService bagageService;
	 
	    @Autowired
	    public void setBagageService(BagageService bagageService) {
	        this.bagageService = bagageService;
	    }

	    /**
	     * List all products.
	     *
	     * @param model
	     * @return
	     */
	    @RequestMapping(value = "/bagages", method = RequestMethod.GET)
	    public String list(Model model) {
	        model.addAttribute("bagages", bagageService.listAllBagages());
	        System.out.println("Returning bagages:");
	        return "bagages";
	    }

	    /**
	     * View a specific product by its id.
	     *
	     * @param id
	     * @param model
	     * @return
	     */
	    @RequestMapping("bagage/{id}")
	    public String showBagage(@PathVariable Integer id, Model model) {
	        model.addAttribute("bagage", bagageService.getBagageById(id));
	        return "bagageshow";
	    }

	    // Afficher le formulaire de modification du Product
	    @RequestMapping("bagage/edit/{id}")
	    public String edit(@PathVariable Integer id, Model model) {
	        model.addAttribute("bagage", bagageService.getBagageById(id));
	        return "bagageform";
	    }

	    /**
	     * New product.
	     *
	     * @param model
	     * @return
	     */
	    @RequestMapping("bagage/new")
	    public String newBagage(Model model) {
	        model.addAttribute("bagage", new Bagage());
	       
	        return "bagageform";
	    }

	    /**
	     * Save product to database.
	     *
	     * @param bagage
	     * @return
	     * @throws MessagingException 
	     */
	    @RequestMapping(value = "bagage", method = RequestMethod.POST)
	    public String saveBagage(Bagage bagage) throws MessagingException {
	       bagageService.saveBagage(bagage);

	       bagageService.add(bagage.getId());
	       
	       sende("seif.oueslati@esprit.tn", "you aded a new luggage", "new luggage has been aded for you and well send you the rfid tag so you can track it!");
	     
	       bagageService.addtag(bagage.getId());
	       
	       sende("seif.oueslati@esprit.tn", "luggage", "your tag is tag14254788");
		     
	    //   
	       return "redirect:/bagages";
	       
	    }

	 	@Autowired
    	private JavaMailSender javaMailSender;
	    
	    
	   
	    	
	    	//
	   
	    	public String sende(String to, String subject, String body) throws MessagingException{
	    	

	    		

	    			MimeMessage message = javaMailSender.createMimeMessage();
	    			MimeMessageHelper helper;

	    			helper = new MimeMessageHelper(message, true);
	    			// helper.setText(html, "utf-8", "html").
	    			helper.setSubject(subject);
	    			helper.setTo(to);
	    			helper.setText(body, true); // true = html

	    			javaMailSender.send(message);
	    			return "success";

	    		
	    	
	    	}
		
		
		

		/**
	     * Delete product by its id.
	     *
	     * @param id
	     * @return
	     */
	    @RequestMapping("bagage/delete/{id}")
	    public String delete(@PathVariable Integer id) {
	        bagageService.deleteBagage(id);
	        return "redirect:/bagages";
	    }

}
