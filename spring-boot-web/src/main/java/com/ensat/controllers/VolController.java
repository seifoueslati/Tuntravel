package com.ensat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ensat.entities.Vol;
import com.ensat.services.VolService;


@Controller
public class VolController {
	
	
    private VolService volService;

    @Autowired
    public void setAvionService(VolService volService) {
        this.volService = volService;
    }
    @RequestMapping(value = "/vols", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("vols", volService.listAllVols());
        System.out.println("Returning rvols:");
        return "vols";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("vol/{id}")
    public String showVol(@PathVariable Integer id, Model model) {
        model.addAttribute("vol", volService.getVolById(id));
        return "volshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("vol/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("vol", volService.getVolById(id));
        return "volform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("vol/new")
    public String newVol(Model model) {
        model.addAttribute("vol", new Vol());
        return "volform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "vol", method = RequestMethod.POST)
    public String saveVol(Vol vol) {
        volService.saveVol(vol);
        return "redirect:/vol/" + vol.getId();

    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("vol/delete/{id}")
    public String delete(@PathVariable Integer id) {
        volService.deleteVol(id);
        return "redirect:/vols";
    }


}
