package com.ensat.services;

import com.ensat.entities.Pilote;

public interface PiloteService {


    Iterable<Pilote> listAllPilotes();

    Pilote getPilotetById(Integer id);

    Pilote savePilote(Pilote pilote);

    void deletePilote(Integer id);

	
}
