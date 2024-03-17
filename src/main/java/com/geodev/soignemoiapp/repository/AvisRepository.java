package com.geodev.soignemoiapp.repository;

import com.geodev.soignemoiapp.pojo.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisRepository extends JpaRepository<Avis,Long> {

}
