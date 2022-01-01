package com.example.evokeshedul.Repository;

import com.example.evokeshedul.Entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SessionRepository extends JpaRepository<SessionEntity,String> {

   //@Query("SELECT SD from SessionEntity SD where SD.StartTime =:SessionTime AND SD.Date =:Date AND SD.IsBooked = 1")
    @Query(value = "SELECT * FROM sessions where StartTime=:SessionTime AND Date=:Date AND IsBooked = 0", nativeQuery = true)
    List <SessionEntity> GetSessionSchedule(String SessionTime, String Date);


    @Query(value = "SELECT * FROM sessions", nativeQuery = true)
    List <SessionEntity> GetAll();
}
