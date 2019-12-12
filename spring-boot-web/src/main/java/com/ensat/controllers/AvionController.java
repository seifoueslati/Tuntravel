package com.ensat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.entities.Avion;
import com.ensat.services.AvionService;


@Controller
public class AvionController {

	
    private AvionService avionService;

    @Autowired
    public void setAvionService(AvionService avionService) {
        this.avionService = avionService;
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/avions", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("avions", avionService.listAllAvions());
        System.out.println("Returning ravions:");
        return "avions";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("avion/{id}")
    public String showAvion(@PathVariable Integer id, Model model) {
        model.addAttribute("avion", avionService.getAvionById(id));
        return "avionshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("avion/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("avion", avionService.getAvionById(id));
        return "avionform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("avion/new")
    public String newAvion(Model model) {
        model.addAttribute("avion", new Avion());
        return "avionform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "avion", method = RequestMethod.POST)
    public String saveAvion(Avion avion) {
        avionService.saveAvion(avion);
        return "redirect:/avion/" + avion.getId();

    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("avion/delete/{id}")
    public String delete(@PathVariable Integer id) {
        avionService.deleteAvion(id);
        return "redirect:/avions";
    }

	
}
