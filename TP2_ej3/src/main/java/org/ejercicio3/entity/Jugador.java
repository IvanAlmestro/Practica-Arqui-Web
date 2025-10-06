package org.ejercicio3.entity;

import jakarta.persistence.*;

@Entity
public class Jugador {
    @Id
    private int jugadorId;

    @Column
    private String nombre;

    @Column(unique = true)
    private String posicion;

    @ManyToOne
    @JoinColumn(name = "equipoId")
    private Equipo equipo;

    public Jugador() {

    }
    public Jugador(int jugadorId, String nombre, String posicion, Equipo equipo) {
        this.jugadorId = jugadorId;
        this.nombre = nombre;
        this.posicion = posicion;
        this.equipo = equipo;
    }


    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }


    public int getJugadorId() {
        return jugadorId;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
