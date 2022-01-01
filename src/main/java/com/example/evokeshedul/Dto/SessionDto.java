package com.example.evokeshedul.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SessionDto {
    private Integer Id;
    private Integer CustomerId, AstrologerId, ServiceId, SessionId, IsBooked, PaymentStatus, ForAnother, Status, UserCreated, UserModified, IsDeleted;
    private String SessionLink, StartTime, EndTime, FirstName, LastName, CountryCode, Mobile, Email, DOB, AnotherPersonName, AnotherPersonMobile, DateCreated, DateModified,CustomerName,AstrologerName,SpecializationType;
    private Double PaymentAmount;
    private String Date;
}
