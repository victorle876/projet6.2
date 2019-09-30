package org.exemple.demo.dao;
import org.exemple.demo.entities.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CotationDao implements ICotationDao, Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	private Cotation Cotation;
	private Cotation Cotation1 = null;

	// liste des abonnes
	@SuppressWarnings("unchecked")
	public List<Cotation> getAllCotations() {
		return em.createQuery("select * from Cotation").getResultList();
	}

	public Cotation getCotationById(long id) {
		return (Cotation) em.find(Cotation.class, id);
	}

	public Cotation createCotation(int id, String LibelleCotation, String NumDifficulte) {
		Cotation NouveauCotation = new Cotation(id,LibelleCotation,NumDifficulte);
		NouveauCotation.setId(Cotation.getId());
		NouveauCotation.setCotation(Cotation.getLibelleCotation());
		NouveauCotation.setNumDifficulte(Cotation.getNumDifficulte());
		em.persist(NouveauCotation);
		return NouveauCotation;
	}

	public Cotation UpdateCotation() {
		em.getTransaction().begin();

		Cotation Cotation1 = em.find(Cotation.class, Cotation.getId());
		Cotation1.setCotation(Cotation.getLibelleCotation());
		em.getTransaction().commit();
		em.close();
		return Cotation1;

	}

	public void delete(Cotation Cotation) {
		em.remove(em.merge(Cotation));
	}

	public Cotation deleteAll() {
		((List<Cotation>) em.createQuery("select * from Cotation").getResultList()).stream()
				.forEach((Cotation2) -> {
					em.remove(Cotation2);
				});
	}
}
