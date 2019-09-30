package org.exemple.demo.dao;
import org.exemple.demo.entities.*;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;

public interface IAbonneDao {
	public List<Abonne> getAllAbonnes();
	
	public Abonne getAbonneById(long id);
	public Abonne createAbonne (int id,String NomAbonne, String PrenomAbonne,
			String Password, String MailAbonne, String RoleAbonne,
			String NiveauAbonne, Timestamp DateAdhesion, Timestamp DateNaissance);
	
	public void deleteAll();
	
	public Abonne UpdateAbonne();
	
	public void delete(Abonne abonne);
	
}
