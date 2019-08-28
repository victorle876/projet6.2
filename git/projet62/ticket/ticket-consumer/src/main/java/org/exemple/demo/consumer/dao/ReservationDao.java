package org.exemple.demo.consumer.dao;

import java.util.List;
import org.exemple.demo.entities.Reservation;

import org.exemple.demo.daoInterface.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public class ReservationDao implements ReservationDaoInterface<Reservation, String> {
	private Session currentSession; 
	private Transaction currentTransaction;
	
	public ReservationDao(){
		
	}
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
    
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    public Session getCurrentSession() {
        return currentSession;
    }
    
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
    
    public void closeCurrentSession() {
        currentSession.close();
    }
    
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    public void persist(Reservation reservation) {
        getCurrentSession().save(reservation);
    }
 
    public void update(Reservation reservation) {
    	 getCurrentSession().update(reservation);
    }
 
    public Reservation findById(String id) {
        Reservation Reservation = (Reservation)  getCurrentSession().get(Reservation.class, id);
        return Reservation; 
    }
 
    public void delete(Reservation reservation) {
    	 getCurrentSession().delete(reservation);
    }
 
    @SuppressWarnings("unchecked")
    public List<Reservation> findAll() {
        List<Reservation> Reservations = (List<Reservation>)  getCurrentSession().createQuery("from Reservation").list();
        return Reservations;
    }
 
    public void deleteAll() {
        List<Reservation> reservationList = findAll();
        for (Reservation reservation : reservationList) {
            delete(reservation);
        }
    }
}
