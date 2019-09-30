package org.exemple.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.exemple.demo.entities.*;

public interface ICotationDao {
	public List<Cotation> getllCotations();

	public Cotation getCotationById(Long id);

	public Cotation createCotation(int id, String LibelleCotation, String NumDifficulte);

	public Cotation deleteAll();
	public List<Cotation> findAll();
	public Commentaire UpdateCommentaire();

	public void delete(Cotation Cotation);


}
