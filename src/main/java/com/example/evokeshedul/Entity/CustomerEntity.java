package com.example.evokeshedul.Entity;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")
public class CustomerEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String FirstName;
    private String LastName;
    private String CountryCode;
    private String Mobile;
    private String Email;
    private String DateOfBirth;
    private Integer Status;
    private String DateCreated;
    private Integer UserModified;
    private String DateModified;
    private Integer IsDeleted;
}

