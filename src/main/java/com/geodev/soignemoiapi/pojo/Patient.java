package com.geodev.soignemoiapi.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientID;
    private String nom;
    private String prenom;
    private String adressePostal;
    private String ville;
    private int codePostal;
//    @ManyToOne @JoinColumn(name="userID")
//    private User user;
    @NotBlank
    @Size(max = 50)
    @Email
    private String useremail;

}
