package com.ensat.controllers;

import com.ensat.entities.Product;
import com.ensat.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Product controller.
 */
@Controller
public class Reservationontroller {

    private ReservationService reservationService;

    @Autowired
    public void setProductService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", reservationService.listAllProducts());
        System.out.println("Returning Reservations:");
        return "products";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("reservations/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", reservationService.getProductById(id));
        return "productshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("reservations/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", reservationService.getProductById(id));
        return "productform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("reservations/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        reservationService.saveProduct(product);
        return "redirect:/reservations/" + product.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("reservations/delete/{id}")
    public String delete(@PathVariable Integer id) {
        reservationService.deleteProduct(id);
        return "redirect:/reservations";
    }

}
