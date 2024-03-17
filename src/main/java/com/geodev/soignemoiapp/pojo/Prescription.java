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
public class Prescription {
    @Id
    @NotNull
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionID;
    private Date dateDebut;
    private int dureeTraitement;

    @ManyToOne @JoinColumn(name ="medecinID")
    private Medecin medecin ;

}
