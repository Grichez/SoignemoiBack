package com.geodev.soignemoiapp.repository;

import com.geodev.soignemoiapp.pojo.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament,Long> {

}
