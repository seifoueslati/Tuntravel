package com.ensat.services;
import org.springframework.beans.factory.annotation.Autowired;

import com.ensat.entities.Bagage;
//import com.ensat.entities.Product;
import com.ensat.repositories.BagageRepository;
//import com.ensat.repositories.ProductRepository;
import org.springframework.stereotype.Service;
@Service
public class BagageServiceImpl implements BagageService  {
	private BagageRepository bagageRepository;

    @Autowired
    public void setBagageRepository(BagageRepository bagageRepository) {
        this.bagageRepository = bagageRepository;
    }

    public Iterable<Bagage> listAllBagages() {
        return bagageRepository.findAll();
    }


    public Bagage getBagageById(Integer id) {
        return bagageRepository.findOne(id);
    }

 
    public Bagage saveBagage(Bagage bagage) {
        return bagageRepository.save(bagage);
    }

 

    public void add(Integer id) {
        bagageRepository.change(id);
    }
    
    public void addtag(Integer id) {
        bagageRepository.changetag(id);
    }

    public void deleteBagage(Integer id) {
    	bagageRepository.delete(id);
    }

}
