package com.example.evokeshedul.Repository;


import com.example.evokeshedul.Entity.UserCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserCustomerRepository extends JpaRepository<UserCustomerEntity, Integer> {
    @Query(value = "SELECT * FROM usercustomers WHERE CustomerId=:CustomerId", nativeQuery = true)
    UserCustomerEntity GetCustomerId(String CustomerId);
}
