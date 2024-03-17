package com.geodev.soignemoiapp.repository;

import com.geodev.soignemoiapp.pojo.Sejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SejourRepository extends JpaRepository<Sejour,Long> {

}
