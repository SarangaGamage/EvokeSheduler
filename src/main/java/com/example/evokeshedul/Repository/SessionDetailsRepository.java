package com.example.evokeshedul.Repository;

import com.example.evokeshedul.Entity.SessionDetailsEntity;
import com.example.evokeshedul.Entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionDetailsRepository extends JpaRepository <SessionDetailsEntity, Integer> {
    @Query(value = "SELECT * FROM sessions", nativeQuery = true)
    List<SessionEntity> GetAll();
}
