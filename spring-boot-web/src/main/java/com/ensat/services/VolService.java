package com.ensat.services;


import com.ensat.entities.Vol;

public interface VolService {
    Iterable<Vol> listAllVols();

    Vol getVolById(Integer id);

    Vol saveVol(Vol vol);

    void deleteVol(Integer id);

}
