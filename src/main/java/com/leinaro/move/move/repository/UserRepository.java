package com.leinaro.move.move.repository;

import com.leinaro.move.move.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT s FROM User WHERE s.authUid = :authUid")
//    Optional<User> findUserByAuthUid(@Param("authUid")String authUid);
    Optional<User> findByAuthUid(String authUid);


}
