package org.ejercicio3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DirectorTecnico {
    @Id
    private int idDirector;
    private int idEquipo;
    @Column
    private String nombre;

    public DirectorTecnico() {
        super();
    }
    public DirectorTecnico(int idDirector, int idEquipo, String nombre) {
        super();
        this.idDirector = idDirector;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
    }

    public int getIdDirector() {
        return idDirector;
    }



    public int getIdEquipo() {
        return idEquipo;
    }


    public String getNombre() {
        return nombre;
    }


}
