package org.exemple.demo.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;

import org.exemple.demo.entities.*;

public interface IReservationDao {
	public List<Reservation> getReservations();

	public Reservation getReservationById(Long id);

	public Reservation CreateReservation(int id, String Auteur, Topologie topologie,
			Abonne abonne, Timestamp DateAjout);

	public Reservation deleteAll();
	public List<Reservation> findAll();

	public Reservation delete(Reservation Reservation);

	public void delete(Niveau Niveau);

	public Niveau UpdateNiveau();
}
