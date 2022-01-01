package com.example.evokeshedul.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Username")
    private String userName;

    @Column(name = "Password")
    private String userPassword;

    @Column(name = "UserTypeId")
    private Integer userTypeId;

    @Column(name = "IsBlocked")
    private Integer isBlocked;

    @Column(name = "Status")
    private Integer userStatus;

    @Column(name = "UserCreated")
    private String userCreated;

    @Column(name = "DateCreated")
    private String userDateCreated;

    @Column(name = "UserModified")
    private String userModified;

    @Column(name = "DateModified")
    private String userDateModified;

    @Column(name = "IsDeleted")
    private Integer isUserDeleted;
}
