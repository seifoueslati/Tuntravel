package com.ensat.services;

import com.ensat.entities.Avion;


public interface AvionService {
    Iterable<Avion> listAllAvions();

    Avion getAvionById(Integer id);

    Avion saveAvion(Avion avion);

    void deleteAvion(Integer id);

}
