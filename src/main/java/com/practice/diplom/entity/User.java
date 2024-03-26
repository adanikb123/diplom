package com.practice.diplom.entity;

import com.practice.diplom.entity.enums.RoleType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users",
        uniqueConstraints =
                {
                        @UniqueConstraint(columnNames = "name"),
                        @UniqueConstraint(columnNames = "email")
                }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "email",nullable = false,length = 50,unique = true)
    private String email;

    @Column(name = "password",nullable = false,length =  60)
    private String password;

    @Column(name = "role_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(mappedBy = "user")
    List<UserSong> userSongs ;
}
