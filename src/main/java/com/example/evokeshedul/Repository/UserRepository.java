package com.example.evokeshedul.Repository;

import com.example.evokeshedul.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserEntity,Integer> {


}
