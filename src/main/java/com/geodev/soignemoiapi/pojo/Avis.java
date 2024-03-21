package com.geodev.soignemoiapi.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Avis {

    @Id
    @NotNull
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avisID;
    private String libelle;
    private Date dateAvis;
    private String descritption;

    @ManyToOne @JoinColumn(name ="medecinID")
    private Medecin medecin ;
}
