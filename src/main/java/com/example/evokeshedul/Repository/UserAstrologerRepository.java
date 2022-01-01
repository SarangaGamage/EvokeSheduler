package com.example.evokeshedul.Repository;

import com.example.evokeshedul.Entity.SessionEntity;
import com.example.evokeshedul.Entity.UserAstrologersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAstrologerRepository extends JpaRepository <UserAstrologersEntity, Integer> {
    @Query(value = "SELECT * FROM userastrologers WHERE AstrologerId=:AstrologerId", nativeQuery = true)
    UserAstrologersEntity GetAstrologerUserId(String AstrologerId);
}
