package com.ensat.services;



import com.ensat.entities.Pilote;
import com.ensat.repositories.PiloteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product service implement.
 */
@Service
public class PiloteServiceImpl implements PiloteService {
    private PiloteRepository piloteRepository;

    @Autowired
    public void setPiloteRepository(PiloteRepository piloteRepository) {
        this.piloteRepository = piloteRepository;
    }

	@Override
	public Iterable<Pilote> listAllPilotes() {
        return piloteRepository.findAll();

	}


	public Pilote getPilotetById(Integer id) {
        return (Pilote) piloteRepository.findOne(id);
	}

	@Override
	public Pilote savePilote(Pilote pilote) {
        return piloteRepository.save(pilote);
	}

	@Override
	public void deletePilote(Integer id) {
		  piloteRepository.delete(id);


	}
}
