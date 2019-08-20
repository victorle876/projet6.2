package org.exemple.demo.dao;

import java.util.List;
import org.exemple.demo.entities.Reservation;

import org.exemple.demo.daoInterface.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public class ReservationDao implements ReservationDaoInterface<Reservation, String> {
	SessionFactory sessionFactory;
	
	public ReservationDao(){
		
	}
    public void persist(Reservation entity) {
        sessionFactory.getCurrentSession().save(entity);
    }
 
    public void update(Reservation entity) {
    	 sessionFactory.getCurrentSession().update(entity);
    }
 
    public Reservation findById(String id) {
        Reservation Reservation = (Reservation)  sessionFactory.getCurrentSession().get(Reservation.class, id);
        return Reservation; 
    }
 
    public void delete(Reservation entity) {
    	 sessionFactory.getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Reservation> findAll() {
        List<Reservation> Reservations = (List<Reservation>)  sessionFactory.getCurrentSession().createQuery("from Reservation").list();
        return Reservations;
    }
 
    public void deleteAll() {
        List<Reservation> entityList = findAll();
        for (Reservation entity : entityList) {
            delete(entity);
        }
    }
}
