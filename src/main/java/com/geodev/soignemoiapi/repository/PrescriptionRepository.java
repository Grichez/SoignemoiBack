package com.geodev.soignemoiapi.repository;

import com.geodev.soignemoiapi.pojo.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

}
