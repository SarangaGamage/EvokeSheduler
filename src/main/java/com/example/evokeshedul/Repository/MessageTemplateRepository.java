package com.example.evokeshedul.Repository;

import com.example.evokeshedul.Entity.AstrologersEntity;
import com.example.evokeshedul.Entity.MessageTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageTemplateRepository extends JpaRepository<MessageTemplateEntity, Integer> {
    @Query(value = "SELECT * FROM messagetemplates WHERE TemplateId=:TemplateId", nativeQuery = true)
    AstrologersEntity GetMessageTemplate(String TemplateId);
}
