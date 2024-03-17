package com.geodev.soignemoiapp.repository;

import com.geodev.soignemoiapp.pojo.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin,Long> {

    @Query("Select med from Medecin med where med.specialite like ?1%")
    List<Medecin> RechercherMedecinParSpecialite(String specialite);
}
