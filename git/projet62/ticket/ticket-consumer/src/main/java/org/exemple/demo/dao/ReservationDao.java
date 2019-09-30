package org.exemple.demo.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.exemple.demo.entities.*;

public class ReservationDao implements IReservationDao, Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	private Reservation reservation;
	private Reservation reservation1 = null;

	// liste des abonnes
	@SuppressWarnings("unchecked")
	public List<Reservation> getAllreservations() {
		return em.createQuery("select * from Reservation").getResultList();
	}

	public Reservation getreservationById(long id) {
		return (Reservation) em.find(Reservation.class, id);
	}

	public Reservation CreateReservation(int id, String Auteur, Topologie topologie,
			Abonne abonne, Timestamp DateAjout) {
		Reservation NouveauReservation = new Reservation(id,Auteur,topologie,
			 abonne,DateAjout);
		NouveauReservation.setId(reservation.getId());
		NouveauReservation.setAuteur(reservation.getAuteur());
		NouveauReservation.setTopologie(reservation.getTopologie());
		NouveauReservation.setAbonne(reservation.getAbonne());
		NouveauReservation.setDateAjout(reservation.getDateAjout());
		em.persist(NouveauReservation);
		return NouveauReservation;
	}

	public Reservation Updatereservation() {
		em.getTransaction().begin();

		Reservation reservation1 = em.find(Reservation.class, reservation.getId());
		reservation1.setAuteur(reservation.getAuteur());

		em.getTransaction().commit();
		em.close();
		return reservation1;

	}

	public void delete(Reservation reservation) {
		em.remove(em.merge(reservation));
	}

	public Reservation deleteAll() {
		((List<Reservation>) em.createQuery("select * from Reservation").getResultList()).stream()
				.forEach((reservation2) -> {
					em.remove(reservation2);
				});
	}

}
