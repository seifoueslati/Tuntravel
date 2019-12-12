package com.ensat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.Enregistrement;
import com.ensat.repositories.EnregistrementRepository;
import com.ensat.repositories.ReservationRepository;

@Service
public class EnregistrementServiceImpl  implements EnregistrementService{
	
	
	 private EnregistrementRepository enregistrementRepository;

	    @Autowired
	    public void setEnregistrementRepository(EnregistrementRepository enregistrementRepository) {
	        this.enregistrementRepository = enregistrementRepository;
	    }

	    @Override
	    public Iterable<Enregistrement> listAllEnregistrement() {
	        return enregistrementRepository.findAll();
	    }

	    @Override
	    public Enregistrement getEnregistrementById(Integer id) {
	        return enregistrementRepository.findOne(id);
	    }

	    @Override
	    public Enregistrement saveEnregistrement(Enregistrement enregistrement) {
	        return enregistrementRepository.save(enregistrement);
	    }

	    @Override
	    public void deleteEnregistrement(Integer id) {
	    	enregistrementRepository.delete(id);
	    }


}
