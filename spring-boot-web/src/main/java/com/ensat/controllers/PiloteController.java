package com.ensat.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.entities.Pilote;
import com.ensat.services.PiloteService;
@Controller
public class PiloteController {

    private PiloteService piloteService;

    @Autowired
    public void setPiloteService(PiloteService piloteService) {
        this.piloteService = piloteService;
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/pilotes", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("pilotes", piloteService.listAllPilotes());
        System.out.println("Returning rpilotes:");
        return "pilotes";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("pilote/{id}")
    public String showPilote(@PathVariable Integer id, Model model) {
        model.addAttribute("pilote", piloteService.getPilotetById(id));
        return "piloteshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("pilote/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("pilote", piloteService.getPilotetById(id));
        return "piloteform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("pilote/new")
    public String newPilote(Model model) {
        model.addAttribute("pilote", new Pilote());
        return "piloteform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "pilote", method = RequestMethod.POST)
    public String savePilote(Pilote pilote) {
        piloteService.savePilote(pilote);
        return "redirect:/pilote/" + pilote.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("pilote/delete/{id}")
    public String delete(@PathVariable Integer id) {
        piloteService.deletePilote(id);
        return "redirect:/pilotes";
    }

	

}
