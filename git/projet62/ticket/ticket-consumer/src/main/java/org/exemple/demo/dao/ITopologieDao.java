package org.exemple.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.exemple.demo.entities.Topologie;

public interface ITopologieDao {
	public List<Topologie> getTopologies();

	public Topologie getTopologieById(Long id);

	public Topologie createTopologie(Topologie Topologie);

	public Topologie deleteAll();
	public List<Topologie> findAll();

	public Topologie delete(Topologie Topologie);

	public EntityManager getEntityManager();

}
