package com.geodev.soignemoiapi.repository;

import com.geodev.soignemoiapi.pojo.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisRepository extends JpaRepository<Avis,Long> {

}
