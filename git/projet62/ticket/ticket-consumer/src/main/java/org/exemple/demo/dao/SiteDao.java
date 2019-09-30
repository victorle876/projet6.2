package org.exemple.demo.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.exemple.demo.entities.*;

public class SiteDao implements ISiteDao, Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	private Site site;
	private Site site1 = null;

	// liste des abonnes
	@SuppressWarnings("unchecked")
	public List<Site> getAllSites() {
		return em.createQuery("select * from Site").getResultList();
	}

	public Site getSiteById(long id) {
		return (Site) em.find(Site.class, id);
	}

	public Site CreateSite(int id, String LibelleSite, Secteur secteur,int NombreSecteur,
			int NombreCotation , int Longueur, int HauteurMini, int HauteurMaxi,
			Timestamp DateAjout)  {
		Site NouveauSite = new Site(id,LibelleSite, secteur, NombreSecteur,
				NombreCotation , Longueur, HauteurMini, HauteurMaxi,
				DateAjout) ;
		NouveauSite.setSiteId(site.getSiteId());
		NouveauSite.setLibelleSite(site.getLibelleSite());
		NouveauSite.setSecteur(site.getSecteur());
		NouveauSite.setNombreSecteur(site.getNombreSecteur());
		NouveauSite.setNombreCotation(site.getNombreCotation());
		NouveauSite.setLongueur(site.getLongueur());
		NouveauSite.setHauteurMini(site.getHauteurMini());
		NouveauSite.setHauteurMaxi(site.getHauteurMaxi());
		em.persist(NouveauSite);
		return NouveauSite;
	}

	public Site UpdateSite() {
		em.getTransaction().begin();

		Site Site1 = em.find(Site.class, site.getSiteId());
		Site1.setSecteur(site.getSecteur());

		em.getTransaction().commit();
		em.close();
		return Site1;

	}

	public void delete(Site Site) {
		em.remove(em.merge(Site));
	}

	public Site deleteAll() {
		((List<Site>) em.createQuery("select * from Site").getResultList()).stream()
				.forEach((Site2) -> {
					em.remove(Site2);
				});
	}

}
