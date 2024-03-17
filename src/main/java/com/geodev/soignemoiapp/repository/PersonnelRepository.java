package com.geodev.soignemoiapp.repository;

import com.geodev.soignemoiapp.pojo.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel,Long> {

}
