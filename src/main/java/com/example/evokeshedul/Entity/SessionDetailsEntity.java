package com.example.evokeshedul.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sessiondetails")
public class SessionDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer SessionId;
    private String SubmittedBy;
    private String Name1;
    private String Name2;
    private String DOB1;
    private String DOB2;
    private String Time1;
    private String Time2;
    private String Place1;
    private String Place2;
    private String Gender;
    private String BusinessType;
    private String Location;
    private String Reason;
    private String Kendara1;
    private String Kendara2;
    private String HousePlan;
    private String LandPlan;
    private String PalmImage;
    private Integer Status;
    private Integer UserCreated;
    private LocalDateTime DateCreated;
    private Integer UserModified;
    private LocalDateTime DateModified;
    private Integer IsDeleted;
}
