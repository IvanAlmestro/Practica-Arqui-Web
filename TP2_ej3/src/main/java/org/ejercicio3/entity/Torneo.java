package org.ejercicio3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
@Entity
public class Torneo {
    @Id
    private int id;
    @Column
    private String nombre;
    @OneToMany
    private ArrayList<Equipo> equiposInscriptos;


}
