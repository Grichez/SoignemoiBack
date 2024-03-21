package com.geodev.soignemoiapi.repository;

import com.geodev.soignemoiapi.pojo.Sejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SejourRepository extends JpaRepository<Sejour,Long> {
    @Query("Select sej from Sejour sej where sej.patient.patientID = ?1")
   List<Sejour> listerSejourPatient(Long idPatient);
}
