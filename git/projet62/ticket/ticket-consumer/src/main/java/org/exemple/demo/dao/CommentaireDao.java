package org.exemple.demo.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.exemple.demo.entities.*;

public class CommentaireDao implements ICommentaireDao, Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	private Commentaire commentaire;
	private Commentaire commentaire1 = null;

	// liste des abonnes
	@SuppressWarnings("unchecked")
	public List<Commentaire> getAllCommentaires() {
		return em.createQuery("select * from Commentaire").getResultList();
	}

	public Commentaire getCommentaireById(long id) {
		return (Commentaire) em.find(Commentaire.class, id);
	}

	public Commentaire createCommentaire(int id, String Auteur, Timestamp DateMaj, String ZoneCommentaire,
			String Etat) {
		Commentaire NouveauCommentaire = new Commentaire(id, Auteur, DateMaj, ZoneCommentaire, Etat);
		NouveauCommentaire.setId(commentaire.getId());
		NouveauCommentaire.setAuteur(commentaire.getAuteur());
		NouveauCommentaire.setDateMaj(commentaire.getDateMaj());
		NouveauCommentaire.setZoneCommentaire(commentaire.getZoneCommentaire());
		NouveauCommentaire.setEtat(commentaire.getEtat());

		em.persist(NouveauCommentaire);
		return NouveauCommentaire;
	}

	public Commentaire UpdateCommentaire() {
		em.getTransaction().begin();

		Commentaire Commentaire1 = em.find(Commentaire.class, commentaire.getId());
		Commentaire1.setZoneCommentaire(commentaire.getZoneCommentaire());

		em.getTransaction().commit();
		em.close();
		return Commentaire1;

	}

	public void delete(Commentaire commentaire) {
		em.remove(em.merge(commentaire));
	}

	public Commentaire deleteAll() {
		((List<Commentaire>) em.createQuery("select * from Commentaire").getResultList()).stream()
				.forEach((commentaire2) -> {
					em.remove(commentaire2);
				});
	}

}
