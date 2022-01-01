package com.example.evokeshedul.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="sessions")
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer CustomerId, AstrologerId, ServiceId, SessionId, IsBooked, PaymentStatus, ForAnother, Status, UserCreated, UserModified, IsDeleted;
    private String SessionLink, StartTime, EndTime, FirstName, LastName, CountryCode, Mobile, Email, DOB, AnotherPersonName, AnotherPersonMobile, DateCreated, DateModified;
    private Double PaymentAmount;
    private String Date;
}
