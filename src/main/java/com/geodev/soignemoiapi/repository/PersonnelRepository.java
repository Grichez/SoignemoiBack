package com.geodev.soignemoiapi.repository;

import com.geodev.soignemoiapi.pojo.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel,Long> {

}
