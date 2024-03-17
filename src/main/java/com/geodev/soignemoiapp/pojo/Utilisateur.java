package com.geodev.soignemoiapp.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Utilisateur {
    @Id
    @NotNull
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long utilisateurID;
    private String nom;
    private String prenom;
    private String email;
    private String adressePostal;
    private String ville;
    private int codePostal;
    private String utilsateurMDP;

}
