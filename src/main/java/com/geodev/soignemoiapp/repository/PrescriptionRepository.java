package com.geodev.soignemoiapp.repository;

import com.geodev.soignemoiapp.pojo.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

}
