package com.geodev.soignemoiapp.security.repository;

import com.geodev.soignemoiapp.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    boolean existsUserByEmail(String email);

}
