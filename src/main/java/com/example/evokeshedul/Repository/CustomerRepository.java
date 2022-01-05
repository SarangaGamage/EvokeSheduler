package com.example.evokeshedul.Repository;

import com.example.evokeshedul.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    @Query(value = "SELECT * FROM customers WHERE Id=:Id", nativeQuery = true)
    CustomerEntity GetCustomerMobile(String Id);
}
