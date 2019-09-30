package org.exemple.demo.dao;
import org.exemple.demo.entities.*;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;

public interface ICommentaireDao {

	public List<Commentaire> getCommentaires();

	public Commentaire getCommentaireById(Long id);
	public Commentaire createCommentaire(int id, String Auteur, Timestamp DateMaj, 
			String ZoneCommentaire, String Etat);
	
	public Commentaire UpdateCommentaire();

	public Commentaire createCommentaire(Commentaire commentaire);

	public Commentaire deleteAll();
	public List<Commentaire> findAll();

	public void delete(Commentaire commentaire);


}
