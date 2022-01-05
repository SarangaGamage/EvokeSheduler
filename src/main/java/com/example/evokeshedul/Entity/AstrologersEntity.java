package com.example.evokeshedul.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "astrologers")
public class AstrologersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "consultantId")
    private  Integer ConsultantId;

    @Column(name = "Title")
    private String Title;

    @Column(name = "FirstName")
    private String AstrologerFirstName;

    @Column(name = "LastName")
    private String AstrologerLastName;

    @Column(name = "ProfilePictureURL")
    private String ProfilePictureURL;

    @Column(name = "DateOfBirth")
    private String AstroDateOfBirth;

    @Column(name = "Mobile")
    private String Mobile;

    @Column(name = "NIC")
    private String NIC;

    @Column(name = "VideoUrl")
    private String VideoUrl;

    @Column(name = "BannerUrl")
    private String BannerUrl;

    @Column(name = "ShortDescription")
    private String ShortDescription;

    @Column(name = "LongDescription")
    private String LongDescription;

    @Column(name = "PointDescription")
    private String PointDescription;

    @Column(name = "Email")
    private String Email;

    @Column(name = "IntervalDuration")
    private Integer IntervalDuration;

    @Column(name = "AddressId")
    private Integer AddressId;

    @Column(name = "Status")
    private Integer Status;

    @Column(name = "UserCreated")
    private Integer AstrologerCreated;

    @Column(name = "DateCreated")
    private String AstrologerDateCreated;

    @Column(name = "UserModified")
    private String AstrologerModified;

    @Column(name = "DateModified")
    private String AstrologerDateModified;

    @Column(name = "IsDeleted")
    private Integer isAstrologerDeleted;
}
