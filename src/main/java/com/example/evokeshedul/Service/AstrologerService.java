package com.example.evokeshedul.Service;

import com.example.evokeshedul.Dto.SessionDto;
import com.example.evokeshedul.Entity.AstrologersEntity;
import com.example.evokeshedul.Entity.SessionEntity;
import com.example.evokeshedul.Entity.UserAstrologersEntity;
import com.example.evokeshedul.Repository.AstrologerRepository;
import com.example.evokeshedul.Repository.SessionRepository;
import com.example.evokeshedul.Repository.UserAstrologerRepository;
import com.example.evokeshedul.Util.MessageAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@Service
public class AstrologerService extends Thread {

    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    AstrologerRepository astrologerRepository;
    @Autowired
    UserAstrologerRepository userAstrologerRepository;

    @Scheduled(cron = "*/60 * * * * *")
  //  @Scheduled(cron = "*/60 0-35 6-21 * * ?")
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String Today = sdf.format(now);
        Calendar now1 = Calendar.getInstance();
        now1.add(Calendar.MINUTE, 5);
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:00");
        List<SessionEntity> sessionEntities = sessionRepository.GetSessionSchedule(df.format(now1.getTime()), Today);
        System.out.println("Checked Time" +df.format(now1.getTime()));
        System.out.println("Checked date" +Today);
        System.out.println(sessionEntities.size());
        if (sessionEntities.size() != 0) {
            for (SessionEntity sessionEntity : sessionEntities) {
                UserAstrologersEntity userAstrologersEntity = userAstrologerRepository.GetAstrologerUserId(sessionEntity.getAstrologerId().toString());
                System.out.println(userAstrologersEntity.getAstrologerId());
                AstrologersEntity astrologersEntity = astrologerRepository.GetAstrologerMobile(userAstrologersEntity.getUserId().toString());
                System.out.println(userAstrologersEntity.getUserId().toString());
                MessageAPI.SendMessage(astrologersEntity.getMobile());
            }
        } else {
            System.out.println("No Session Found!!!");
        }
    }

}

