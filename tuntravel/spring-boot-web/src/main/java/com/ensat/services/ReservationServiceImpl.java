package com.ensat.services;

import com.ensat.entities.Product;
import com.ensat.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product service implement.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public void setProductRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Iterable<Product> listAllProducts() {
        return reservationRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return reservationRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return reservationRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        reservationRepository.delete(id);
    }

}
