package com.ensat.repositories;

import com.ensat.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Product, Integer> {

}
