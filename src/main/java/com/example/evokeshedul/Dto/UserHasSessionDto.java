package com.example.evokeshedul.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserHasSessionDto {

    private String MobileNumber;
    private String StartTime;
    private String EndTime;
    private String Date;
    private String Customer;


    public UserHasSessionDto(String MobileNumber, String StartTime, String EndTime, String Date, String Customer){
        this.MobileNumber = MobileNumber;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Date = Date;
        this.Customer = Customer;
    }
    public UserHasSessionDto(String MobileNumber, String StartTime, String EndTime, String Date){
        this.MobileNumber = MobileNumber;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Date = Date;
    }
}
