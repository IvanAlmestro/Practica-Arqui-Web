package org.example.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private Timestamp fecha;

    @ManyToMany (fetch = FetchType.LAZY)
    private List<Persona> jugadores;

    public Turno() {
        super();
        this.jugadores = new ArrayList<>();
    }

    public Turno(int id, Timestamp fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }


    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public List<Persona> getJugadores() {
        return new ArrayList<>(jugadores);
    }

}
