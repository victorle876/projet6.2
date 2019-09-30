package org.exemple.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.exemple.demo.entities.*;

public interface ISecteurDao {
	
	public List<Secteur> getAllSecteurs();

	public Secteur getSecteurById(Long id);

	public Secteur createSecteur(int id, String LibelleSecteur, Cotation cotation, int LongueurSecteur) ;

	public Secteur deleteAll();
	public List<Secteur> findAll();


	public void delete (Secteur Secteur);

	public Secteur UpdateSecteur();

}
