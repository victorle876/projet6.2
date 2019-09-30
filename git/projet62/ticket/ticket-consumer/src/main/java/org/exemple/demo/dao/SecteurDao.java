package org.exemple.demo.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.exemple.demo.entities.*;

public class SecteurDao implements ISecteurDao, Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	private Secteur Secteur;
	private Secteur Secteur1 = null;

	// liste des abonnes
	@SuppressWarnings("unchecked")
	public List<Secteur> getAllSecteurs() {
		return em.createQuery("select * from Secteur").getResultList();
	}

	public Secteur getSecteurById(long id) {
		return (Secteur) em.find(Secteur.class, id);
	}

	public Secteur CreateSecteur(int id, String LibelleSecteur, Cotation cotation, int LongueurSecteur)  {
		Secteur NouveauSecteur = new Secteur(id,LibelleSecteur,cotation, LongueurSecteur) ;
		NouveauSecteur.setSecteurId(Secteur.getSecteurId());
		NouveauSecteur.setLibelleSecteur(Secteur.getLibelleSecteur());
		NouveauSecteur.setCotation(Secteur.getCotation());
		NouveauSecteur.setLongueurSecteur(Secteur.getLongueurSecteur());
		em.persist(NouveauSecteur);
		return NouveauSecteur;
	}

	public Secteur UpdateSecteur() {
		em.getTransaction().begin();

		Secteur Secteur1 = em.find(Secteur.class, Secteur.getSecteurId());
		Secteur1.setLibelleSecteur(Secteur.getLibelleSecteur());

		em.getTransaction().commit();
		em.close();
		return Secteur1;

	}

	public void delete(Secteur Secteur) {
		em.remove(em.merge(Secteur));
	}

	public Secteur deleteAll() {
		((List<Secteur>) em.createQuery("select * from Secteur").getResultList()).stream()
				.forEach((Secteur2) -> {
					em.remove(Secteur2);
				});
	}

}
