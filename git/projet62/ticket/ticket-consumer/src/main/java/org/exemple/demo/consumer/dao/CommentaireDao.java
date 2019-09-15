package org.exemple.demo.consumer.dao;

import org.exemple.demo.entities.*;

import org.exemple.demo.consumer.daoInterface.CommentaireDaoInterface;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CommentaireDao implements org.exemple.demo.consumer.daoInterface.CommentaireDaoInterface<Commentaire, String> {

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

	public void persist(Commentaire commentaire) {
		getCurrentSession().save(commentaire);
	}

	public void update(Commentaire commentaire) {
		getCurrentSession().update(commentaire);
	}

	public Commentaire findById(String id) {
		Commentaire Commentaire = (Commentaire) getCurrentSession().get(Commentaire.class, id);
		return Commentaire;
	}
	


	public void delete(Commentaire commentaire) {
		getCurrentSession().delete(commentaire);
	}

	@SuppressWarnings("unchecked")
	public List<Commentaire> findAll() {
		List<Commentaire> Commentaires = (List<Commentaire>) getCurrentSession()
				.createQuery("from Commentaire").list();
		return Commentaires;
	}
	
	@SuppressWarnings("unchecked")
	public Commentaire Find_By_Site_Abonne(Site site, Abonne abonne) {
		Commentaire Commentaire = (Commentaire) getCurrentSession().createQuery("Commentaire.Find_By_Site_User").list();;
		return Commentaire;
	}

	public void deleteAll() {
		List<Commentaire> commentaireList = findAll();
		for (Commentaire commentaire : commentaireList) {
			delete(commentaire);
		}
	}

}
