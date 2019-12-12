package com.ensat.services;

import com.ensat.entities.Bagage;


public interface BagageService {

	Iterable<Bagage> listAllBagages();

    Bagage getBagageById(Integer id);

    Bagage saveBagage(Bagage bagage);

    void deleteBagage(Integer id);
    void add(Integer id);
    void addtag(Integer id);
}
