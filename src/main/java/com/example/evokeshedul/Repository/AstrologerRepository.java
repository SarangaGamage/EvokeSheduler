package com.example.evokeshedul.Repository;

import com.example.evokeshedul.Entity.AstrologersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AstrologerRepository extends JpaRepository <AstrologersEntity,Integer> {
    @Query(value = "SELECT * FROM astrologers WHERE Id=:Id", nativeQuery = true)
    AstrologersEntity GetAstrologerMobile(String Id);

}
