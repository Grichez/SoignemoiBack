package com.geodev.soignemoiapi.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medecinID;
    private String nom;
    private String prenom;
    private String specialite;
    private String matricule;

    @Size(max = 50)
    @Email
    private String email;

//    @ManyToOne @JoinColumn(name="userID")
//    private User user;

    @ManyToMany
    @JoinTable( name = "Travailler",
            joinColumns = @JoinColumn( name = "medecinID" ),
            inverseJoinColumns = @JoinColumn( name = "planningID" ) )
    private List<Planning> planningList = new ArrayList<>();

}
