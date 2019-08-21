package org.exemple.demo.dao;

import org.exemple.demo.daoInterface.*;

import java.util.List;

import org.exemple.demo.entities.Commentaire;
import org.hibernate.SessionFactory;
import org.exemple.demo.entities.Commentaire;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CommentaireDao implements CommentaireDaoInterface<Commentaire, String> {

	SessionFactory sessionFactory;
	private Session currentSession;
	private Transaction currentTransaction;

	public CommentaireDao() {

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

	public void persist(Commentaire commentaire) {
		sessionFactory.getCurrentSession().save(commentaire);
	}

	public void update(Commentaire commentaire) {
		sessionFactory.getCurrentSession().update(commentaire);
	}

	public Commentaire findById(String id) {
		Commentaire Commentaire = (Commentaire) sessionFactory.getCurrentSession().get(Commentaire.class, id);
		return Commentaire;
	}

	public void delete(Commentaire commentaire) {
		sessionFactory.getCurrentSession().delete(commentaire);
	}

	@SuppressWarnings("unchecked")
	public List<Commentaire> findAll() {
		List<Commentaire> Commentaires = (List<Commentaire>) sessionFactory.getCurrentSession()
				.createQuery("from Commentaire").list();
		return Commentaires;
	}

	public void deleteAll() {
		List<Commentaire> entityList = findAll();
		for (Commentaire entity : entityList) {
			delete(entity);
		}
	}

}
