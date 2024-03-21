package com.geodev.soignemoiapi.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Personnel {
    @Id
    @NotNull
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personnelID;
    private String nom;
    private String prenom;
//    @ManyToOne
//    @JoinColumn(name="userID")
//    private User user;

    @Size(max = 50)
    @Email
    private String email;
}
