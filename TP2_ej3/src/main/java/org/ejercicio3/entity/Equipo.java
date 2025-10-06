package org.ejercicio3.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;


import java.util.ArrayList;
@Entity
public class Equipo {
    @Id
    private int equipoId;

    @OneToMany
    private ArrayList<Jugador> jugadores;
    @OneToOne
    private DirectorTecnico dt;
    @ManyToOne
    private Torneo torneo;
    @Column
    private String nombre;

    public Equipo(DirectorTecnico dt, Torneo torneo, String nombre) {
        this.jugadores = new ArrayList<>(jugadores);
        this.dt = dt;
        this.torneo = torneo;
        this.nombre = nombre;
    }

    public Equipo() {

    }

    public int getId() {
        return equipoId;
    }



    public ArrayList<Jugador> getJugadores() {
        return new ArrayList<>(jugadores);
    }


    public DirectorTecnico getDt() {
        return dt;
    }

    public void setDt(DirectorTecnico dt) {
        this.dt = dt;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
