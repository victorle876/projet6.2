package org.exemple.demo.consumer.dao;

import java.util.List;
import org.exemple.demo.entities.*;
import org.exemple.demo.consumer.daoInterface.AbonneDaoInterface;
import org.exemple.demo.consumer.daoInterface.ReservationDaoInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public abstract class ReservationDao implements ReservationDaoInterface {
	private AbstractDao AbstractDao;
	public ReservationDao(){
		
	}
 
    public void persist(Reservation reservation) {
    	AbstractDao.getCurrentSession().save(reservation);
    }
 
    public void update(Reservation reservation) {
    	AbstractDao.getCurrentSession().update(reservation);
    }
 
    public Reservation findById(String id) {
        Reservation Reservation = (Reservation) AbstractDao.getCurrentSession().get(Reservation.class, id);
        return Reservation; 
    }
 
    public void delete(Reservation reservation) {
    	AbstractDao.getCurrentSession().delete(reservation);
    }
 
    @SuppressWarnings("unchecked")
    public List<Reservation> findAll() {
        List<Reservation> Reservations = (List<Reservation>) AbstractDao.getCurrentSession().createQuery("from Reservation").list();
        return Reservations;
    }
    
    @SuppressWarnings("unchecked")
    public Reservation findByTopologie_Reservation(Reservation reservation, Topologie topologie) {
        List<Reservation> Reservations = (List<Reservation>) AbstractDao.getCurrentSession().createQuery(Reservation.Find_By_Reservation_Topologie).list();
        return Reservations;
    }
 
    public void deleteAll() {
        List<Reservation> reservationList = findAll();
        for (Reservation reservation : reservationList) {
            delete(reservation);
        }
    }
}
