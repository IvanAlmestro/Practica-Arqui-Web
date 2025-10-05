package org.example.dao;

import org.example.entity.Persona;

import javax.persistence.EntityManager;
import java.util.List;

public class TurnoDAO {
    private EntityManager em;

    public TurnoDAO(EntityManager em) {
        this.em = em;
    }

    //a) recuperar todas las personas asignadas a un turno
    public List<Persona> getPersonaByTurnoId(int idTurno) {
        return em.createQuery("SELECT p FROM Persona p JOIN p.turnos t WHERE t.id = :idTurno", Persona.class)
                .setParameter("idTurno", idTurno)
                .getResultList();
    }
    //c)recuperar todas las personas que viven en una ciudad predeterminada.
    public List<Persona> getPersonaByCiudad(String ciudad) {
        return em.createQuery("SELECT p FROM Persona p JOIN p.domicilio d WHERE d.ciudad = :ciudad", Persona.class)
                .setParameter("ciudad" , ciudad)
                .getResultList();
    }

    // recuperar personas ordenadas por edad
    public List<Persona> getPersonaByAnio(){
        return em.createQuery("Select p From Persona p order by p.edad desc", Persona.class).getResultList();
    }
}
