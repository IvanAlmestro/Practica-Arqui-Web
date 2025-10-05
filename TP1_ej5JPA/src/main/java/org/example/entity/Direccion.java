package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String ciudad;
    @Column
    private String calle;
    @OneToMany (mappedBy = "domicilio", fetch=FetchType.LAZY)
    private java.util.List<Persona> habitante;

    public Direccion(String ciudad, String calle) {
        super();
        this.ciudad = ciudad;
        this.calle = calle;

    }
    public Direccion(){
        super();
        this.habitante = new ArrayList<Persona>();
    }

    public int getId() {
        return id;
    }


    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", ciudad='" + ciudad + '\'' +
                ", calle='" + calle + '\'' +
                '}';
    }
}
