package org.ejercicio3.dao;

import jakarta.persistence.EntityManager;
import org.ejercicio3.entity.Jugador;

public class JugadorDAO {
    private EntityManager em;
    public JugadorDAO(EntityManager em) {
        this.em = em;
    }

    public void crearJugador(Jugador jugador) {
        em.createQuery("insert into Jugador values (?,?,?))")
                .setParameter(1, jugador.getNombre())
                .setParameter(2, jugador.getPosicion())
                .setParameter(3, jugador.getEquipo())
                .executeUpdate();
    }
    public void eliminarJugador(Jugador jugador) {
        em.createQuery("Delete from Jugador where nombre = ? AND posicion = ?")
                .setParameter(1, jugador.getNombre())
                .setParameter(2, jugador.getPosicion());

    }
}
