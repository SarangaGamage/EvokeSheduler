package com.example.evokeshedul.Service;

import com.example.evokeshedul.Dto.UserHasSessionDto;
import com.example.evokeshedul.Entity.*;
import com.example.evokeshedul.Repository.CustomerRepository;
import com.example.evokeshedul.Repository.MessageTemplateRepository;
import com.example.evokeshedul.Repository.SessionRepository;
import com.example.evokeshedul.Repository.UserCustomerRepository;
import com.example.evokeshedul.Util.DateTime;
import com.example.evokeshedul.Util.MessageAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

public class UserCustomerService {

    @Autowired
    UserCustomerRepository userCustomerRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MessageTemplateRepository messageTemplateRepository;

    String Today = DateTime.GetTodayDate();

    @Scheduled(cron = "0 0 6 * * *")
    public void UserMainReminder() {
        List<SessionEntity> sessionEntities = sessionRepository.GetTodaySessions(Today);
        if (sessionEntities.size() != 0) {
            ArrayList<UserHasSessionDto> userHasSessionDtos = GetCustomerDetails(sessionEntities);
            for (UserHasSessionDto obj : userHasSessionDtos) {
                MessageAPI.SendMessage(obj.getMobileNumber(), "ssss");
            }
        } else {
            System.out.println("No Session Found For Today");
        }
    }

    public ArrayList<UserHasSessionDto> GetCustomerDetails(List<SessionEntity> EntityObject) {
        ArrayList<UserHasSessionDto> userHasSessionDtos = new ArrayList<>();
        for (SessionEntity sessionEntity : EntityObject) {
            UserCustomerEntity userCustomerEntity = userCustomerRepository.GetCustomerId(sessionEntity.getAstrologerId().toString());
            System.out.println(userCustomerEntity.getCustomerId());
            CustomerEntity customerEntity = customerRepository.GetCustomerMobile(userCustomerEntity.getUserId().toString());
            System.out.println(userCustomerEntity.getUserId().toString());
            userHasSessionDtos.add(new UserHasSessionDto(customerEntity.getMobile(),sessionEntity.getStartTime(),sessionEntity.getEndTime(),sessionEntity.getDate()));
        }
        return userHasSessionDtos;
    }
}
