package com.geodev.soignemoiapp.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Sejour {
    @Id
    @NotNull
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sejourID;
    private Date dateDebut;
    private int nbreNuits;
    private String motif;
    private String specialite;
    @Enumerated(EnumType.STRING)
    private Statut statut;

    @ManyToOne @JoinColumn(name = "utilisateurID")
    private Utilisateur utilisateur;

    @ManyToOne @JoinColumn(name = "medecinID")
    private Medecin medecin;

}

enum Statut {AVENIR,ENCOURS,TERMINE}
