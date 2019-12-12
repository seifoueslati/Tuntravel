package com.ensat.repositories;


import com.ensat.entities.Bagage;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
public interface BagageRepository extends CrudRepository<Bagage, Integer>,JpaRepository<Bagage, Integer> {
 

	@Modifying
    @Transactional
    @Query(value = "INSERT INTO `gestbagage`(`id_vol`, `id_bagage`, `id_client`) VALUES ('vol01',:Try,'client3')", nativeQuery = true)
    public void change(@Param("Try")Integer id);
	
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO `tagbagage`(`tag`, `id_bagage`) VALUES ('tag14254788',:Try)", nativeQuery = true)
    public void changetag(@Param("Try")Integer id);
	
	
	/*@Query(value="INSERT INTO gestbagage VALUES ('vol01','tryy','client3')", nativeQuery=true)
	int change();*/
}
