package com.ensat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.entities.Enregistrement;
import com.ensat.services.EnregistrementService;


@Controller
public class EnregistrementController {
	
	private EnregistrementService enregistrementService;

    @Autowired
    public void setEnregistrementService(EnregistrementService enregistrementService) {
        this.enregistrementService = enregistrementService;
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/enregistrement", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("enregistrements", enregistrementService.listAllEnregistrement());
        System.out.println("Returning enregistrement:");
        return "enregistrement";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("enregistrement/{id}")
    public String showEnregistrement(@PathVariable Integer id, Model model) {
        model.addAttribute("enregistrement", enregistrementService.getEnregistrementById(id));
        return "enregistrementshow";
    }


    @RequestMapping("enregistrement/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("enregistrement", enregistrementService.getEnregistrementById(id));
        return "enregistrementform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("enregistrement/new")
    public String newEnregistrement(Model model) {
        model.addAttribute("enregistrement", new Enregistrement());
        return "enregistrementform";
    }

  
    @RequestMapping(value = "enregistrement", method = RequestMethod.POST)
    public String saveEnregistrement(Enregistrement enregistrement) {
    	enregistrementService.saveEnregistrement(enregistrement);
        return "redirect:/enregistrement/" + enregistrement.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("Enregistrement/delete/{id}")
    public String delete(@PathVariable Integer id) {
    	enregistrementService.deleteEnregistrement(id);
        return "redirect:/enregistrement";
    }


}
