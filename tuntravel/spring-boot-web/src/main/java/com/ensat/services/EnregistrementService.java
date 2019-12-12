package com.ensat.services;

import com.ensat.entities.Enregistrement;

public interface EnregistrementService {
	
	
	Iterable<Enregistrement> listAllEnregistrement();

	Enregistrement getEnregistrementById(Integer id);

	Enregistrement saveEnregistrement(Enregistrement enregistrement);

    void deleteEnregistrement(Integer id);

}
