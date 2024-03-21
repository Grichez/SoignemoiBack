package com.geodev.soignemoiapp.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Patient {
    @Id
    @NotNull
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientID;
    private String nom;
    private String prenom;
    private String adressePostal;
    private String ville;
    private int codePostal;
    @ManyToOne @JoinColumn(name="userID")
    private User user;

}
