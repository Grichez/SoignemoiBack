package com.geodev.soignemoiapp.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Medecin {

    @Id
    @NotNull
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medecinID;
    private String nom;
    private String prenom;
    private String specialite;
    private String matricule;

    @ManyToOne @JoinColumn(name="userID")
    private User user;

    @ManyToMany
    @JoinTable( name = "Travailler",
            joinColumns = @JoinColumn( name = "medecinID" ),
            inverseJoinColumns = @JoinColumn( name = "planningID" ) )
    private List<Planning> planningList = new ArrayList<>();

}
