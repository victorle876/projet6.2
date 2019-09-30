package org.exemple.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.exemple.demo.entities.*;

public interface INiveauDao {
	public List<Niveau> getNiveaus();

	public Niveau getNiveauById(Long id);

	public Niveau createNiveau(int id, String LibelleNiveau);

	public Niveau deleteAll();
	public List<Niveau> findAll();

	public void delete(Niveau Niveau);

	public Niveau UpdateNiveau();

}
