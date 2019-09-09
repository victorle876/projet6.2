package org.exemple.demo.services;
import java.util.List;
import javax.persistence.*;

import org.exemple.demo.consumer.dao.*;
import org.exemple.demo.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.exemple.demo.hibernate.*;


public class ReservationService {
	private static ReservationDao ReservationDao;
	private static Reservation reservation;
	private static Topologie topologie;
	
	public ReservationService() {
		ReservationDao = new ReservationDao();
	}

	public void persist(Reservation Reservation) {
		ReservationDao.openCurrentSessionwithTransaction();
		ReservationDao.persist(Reservation);
		ReservationDao.closeCurrentSessionwithTransaction();
	}

	public void update(Reservation Reservation) {
		ReservationDao.openCurrentSessionwithTransaction();
		ReservationDao.update(Reservation);
		ReservationDao.closeCurrentSessionwithTransaction();
	}

	public Reservation findById(String id) {
		ReservationDao.openCurrentSession();
		Reservation Reservation = ReservationDao.findById(id);
		ReservationDao.closeCurrentSession();
		return Reservation;
	}

	public void delete(String id) {
		ReservationDao.openCurrentSessionwithTransaction();
		Reservation Reservation = ReservationDao.findById(id);
		ReservationDao.delete(Reservation);
		ReservationDao.closeCurrentSessionwithTransaction();
	}

	public List<Reservation> findAll() {
		ReservationDao.openCurrentSession();
		List<Reservation> Reservations = ReservationDao.findAll();
		ReservationDao.closeCurrentSession();
		return Reservations;
	}
	
	public List<Reservation> findByTopologie_Reservation() {
		ReservationDao.openCurrentSession();
		Reservation Reservations = ReservationDao.findByTopologie_Reservation(reservation, topologie);
		ReservationDao.closeCurrentSession();
		return Reservations;
	}

	public void deleteAll() {
		ReservationDao.openCurrentSessionwithTransaction();
		ReservationDao.deleteAll();
		ReservationDao.closeCurrentSessionwithTransaction();
	}

	public ReservationDao ReservationDao() {
		return ReservationDao;
	}
}
