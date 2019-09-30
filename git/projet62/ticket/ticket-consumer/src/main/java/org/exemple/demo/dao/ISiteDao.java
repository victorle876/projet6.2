package org.exemple.demo.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;

import org.exemple.demo.entities.*;

public interface ISiteDao {
	
	public List<Site> getAllSites();

	public Site getSiteById(Long id);

	public Site createSite(int id, String LibelleSite, Secteur secteur,int NombreSecteur,
			int NombreCotation , int Longueur, int HauteurMini, int HauteurMaxi,
			Timestamp DateAjout);

	public Site deleteAll();
	public List<Site> findAll();

	public void delete (Site Site);

	public Site UpdateSite();


}
