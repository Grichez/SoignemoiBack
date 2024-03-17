package com.geodev.soignemoiapp.repository;

import com.geodev.soignemoiapp.pojo.Planning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningRepository extends JpaRepository<Planning,Long> {

}
