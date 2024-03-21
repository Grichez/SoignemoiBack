package com.geodev.soignemoiapi.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Sejour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sejourID;
    private Date dateDebut;
    private int nbreNuits;
    private String motif;
    private String specialite;
    @Enumerated(EnumType.STRING)
    private Statut statut;

    @ManyToOne @JoinColumn(name = "patientID")
    private Patient patient;

    @ManyToOne @JoinColumn(name = "medecinID")
    private Medecin medecin;

    enum Statut {AVENIR,ENCOURS,TERMINE}
}


