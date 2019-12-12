package com.ensat.services;

import com.ensat.entities.Product;

public interface ReservationService {

    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

}
