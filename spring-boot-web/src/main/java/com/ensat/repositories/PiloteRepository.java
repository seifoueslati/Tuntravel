package com.ensat.repositories;

import org.springframework.data.repository.CrudRepository;
import com.ensat.entities.Pilote;

public interface PiloteRepository  extends CrudRepository<Pilote, Integer> {

}
