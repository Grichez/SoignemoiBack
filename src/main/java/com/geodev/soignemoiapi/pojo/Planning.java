package com.geodev.soignemoiapi.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planningID;
    private Date jour;
    private boolean disponible;
    private int nbrePatient;

    @ManyToMany
    @JoinTable( name = "Travailler",
            joinColumns = @JoinColumn( name = "planningID" ),
            inverseJoinColumns = @JoinColumn( name = "medecinID" ) )
    private List<Medecin> medecinList = new ArrayList<>();

}
