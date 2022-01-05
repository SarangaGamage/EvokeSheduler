package com.example.evokeshedul.Service;

import com.example.evokeshedul.Dto.UserHasSessionDto;
import com.example.evokeshedul.Entity.AstrologersEntity;
import com.example.evokeshedul.Entity.SessionEntity;
import com.example.evokeshedul.Entity.UserAstrologersEntity;
import com.example.evokeshedul.Repository.AstrologerRepository;
import com.example.evokeshedul.Repository.SessionRepository;
import com.example.evokeshedul.Repository.UserAstrologerRepository;
import com.example.evokeshedul.Util.DateTime;
import com.example.evokeshedul.Util.MessageAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
@Service
public class UserAstrologerService {
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    AstrologerRepository astrologerRepository;
    @Autowired
    UserAstrologerRepository userAstrologerRepository;

    // String Today = DateTime.GetTodayDate();
    String Time = DateTime.GetTodayTime();
    String Today = "2021-12-31";
    String Message = "Dear @Astrologer,\n" +
            "\n" +
            "your today’s appointment schedule as follows.\n" +
            "\n" +
            "xxxxxx - (Customer Name) \n" +
            "\n" +
            "xxxxxx - (Customer Name)     \t\t\n" +
            "\n" +
            "xxxxxx - (Customer Name)\n" +
            "\n" +
            "xxxxxx - (Customer Name)\n" +
            "\n" +
            "\n" +
            "Thank You ";

    @Scheduled(cron = "*/6000000 * * * * *")
    //  @Scheduled(cron = "*/60 0-35 6-21 * * ?")
    public void AstrologerReminder() {
        List<SessionEntity> sessionEntities = sessionRepository.GetSessionSchedule(Time, Today);
        System.out.println("Checked Time" + Time);
        System.out.println("Checked date" + Today);
        System.out.println(sessionEntities.size());
        if (sessionEntities.size() != 0) {
            ArrayList<UserHasSessionDto> userHasSessionDtos = GetAstrologerDetails(sessionEntities);
            for (UserHasSessionDto obj : userHasSessionDtos) {
                MessageAPI.SendMessage(obj.getMobileNumber(), "");
            }
        } else {
            System.out.println("No Session Found");
        }
    }

    //@Scheduled(cron = "0 0 6 * * *")
    @Scheduled(cron = "*/6 * * * * *")
    //  @Scheduled(cron = "0 7 * * *")
    public void AstrologerMainReminder() {
        List<String> AstrologerList = sessionRepository.GetAstrologerIdForTodaySessions(Today);
        HashMap<String, String> SessionTimeList = new HashMap<>();

        for (int i = 0; i < AstrologerList.size(); i++) {
            SessionTimeList.clear();
            System.out.println(AstrologerList.size());
            System.out.println("checked id " +AstrologerList.get(i));
            List<SessionEntity> SessionListForAstrologer = sessionRepository.GetTodaySessionsByAstrologerId(AstrologerList.get(i), Today);

            for (SessionEntity sessionEntity : SessionListForAstrologer) {
                SessionTimeList.put(sessionEntity.getStartTime(), sessionEntity.getFirstName() + " " + sessionEntity.getLastName());
            }
            String AstrologerDetails = GetAstrologerDetailstest(AstrologerList.get(i));
            System.out.println(GetSessionDetails(SessionTimeList));

            String[] MobileNumber1 = AstrologerDetails.split("-", 0);
            System.out.println(Arrays.toString(AstrologerDetails.split("-", 0)));
        }
    }

    public ArrayList<UserHasSessionDto> GetAstrologerDetails(List<SessionEntity> EntityObject) {
        ArrayList<UserHasSessionDto> userHasSessionDtos = new ArrayList<>();
        for (SessionEntity sessionEntity : EntityObject) {
            UserAstrologersEntity userAstrologersEntity = userAstrologerRepository.GetAstrologerUserId(sessionEntity.getAstrologerId().toString());
            AstrologersEntity astrologersEntity = astrologerRepository.GetAstrologerMobile(userAstrologersEntity.getUserId().toString());
            userHasSessionDtos.add(new UserHasSessionDto(astrologersEntity.getMobile(), sessionEntity.getStartTime(), sessionEntity.getEndTime(), sessionEntity.getDate(), sessionEntity.getFirstName()));
        }
        return userHasSessionDtos;
    }

    public String GetAstrologerDetailstest(String AstrologerId) {
        UserAstrologersEntity userAstrologersEntity = userAstrologerRepository.GetAstrologerUserId(AstrologerId);
        AstrologersEntity astrologersEntity = null;
        if (userAstrologersEntity != null) {
            astrologersEntity = astrologerRepository.GetAstrologerMobile(userAstrologersEntity.getUserId().toString());
            return astrologersEntity.getMobile()+ "-"+ astrologersEntity.getAstrologerFirstName();
        } else {
            System.out.println("No Astrologer Found For The Id");
        }

      return null;
    }

    public static String GetSessionDetails(HashMap mp) {
        String SessionDetails = "";
        for (Object key: mp.keySet()){
            SessionDetails += key +" - "+mp.get(key)+ '\n';
        }
      return SessionDetails;
    }
}

