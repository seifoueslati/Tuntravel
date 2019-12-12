package com.ensat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.Avion;
import com.ensat.repositories.AvionRepository;
import com.ensat.repositories.ProductRepository;
@Service
public class AvionServiceImpl implements AvionService {

    private AvionRepository avionRepository;

    @Autowired
    public void setAvionRepository(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }
	@Override
	public Iterable<Avion> listAllAvions() {
        return avionRepository.findAll();

	}

	@Override
	public Avion getAvionById(Integer id) {
        return avionRepository.findOne(id);

	}

	@Override
	public Avion saveAvion(Avion avion) {
        return avionRepository.save(avion);

	}

	@Override
	public void deleteAvion(Integer id) {
		  avionRepository.delete(id);		
	}
	
	

}
