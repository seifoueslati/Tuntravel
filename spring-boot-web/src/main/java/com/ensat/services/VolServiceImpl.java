package com.ensat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.Vol;
import com.ensat.repositories.VolRepository;
@Service
public class VolServiceImpl implements VolService {
	
    private VolRepository volRepository;

    @Autowired
    public void setVolRepository(VolRepository volRepository) {
        this.volRepository = volRepository;
    }

	@Override
	public Iterable<Vol> listAllVols() {
        return volRepository.findAll();
	}

	@Override
	public Vol getVolById(Integer id) {
        return volRepository.findOne(id);

	}

	@Override
	public Vol saveVol(Vol vol) {
        return volRepository.save(vol);

	}

	@Override
	public void deleteVol(Integer id) {
        volRepository.delete(id);		
	}
	

}
