package org.example.entity;

import javax.persistence.*;

@Entity
public class Socio {
    @Id
    private int id;
    @Column
    private String tipo;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Persona persona_id;

    public int getId() {
        return id;
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Persona getPersona_id() {
        return persona_id;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", persona_id=" + persona_id +
                '}';
    }
}
