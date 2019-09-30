package org.exemple.demo.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.exemple.demo.entities.*;

public class NiveauDao implements INiveauDao, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	private Niveau Niveau;
	private Niveau Niveau1 = null;

	// liste des abonnes
	@SuppressWarnings("unchecked")
	public List<Niveau> getAllNiveaus() {
		return em.createQuery("select * from Niveau").getResultList();
	}

	public Niveau getNiveauById(long id) {
		return (Niveau) em.find(Niveau.class, id);
	}

	public Niveau createNiveau(int id, String LibelleNiveau) {
		Niveau NouveauNiveau = new Niveau(id,LibelleNiveau);
		NouveauNiveau.setId(Niveau.getId());
		NouveauNiveau.setLibelleNiveau(Niveau.getLibelleNiveau());

		em.persist(NouveauNiveau);
		return NouveauNiveau;
	}

	public Niveau UpdateNiveau() {
		em.getTransaction().begin();

		Niveau Niveau1 = em.find(Niveau.class, Niveau.getId());
		Niveau1.setLibelleNiveau(Niveau.getLibelleNiveau());

		em.getTransaction().commit();
		em.close();
		return Niveau1;

	}

	public void delete(Niveau Niveau) {
		em.remove(em.merge(Niveau));
	}

	public Niveau deleteAll() {
		((List<Niveau>) em.createQuery("select * from Niveau").getResultList()).stream()
				.forEach((Niveau2) -> {
					em.remove(Niveau2);
				});
	}

}
