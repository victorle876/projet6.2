package org.exemple.demo.services;
import java.util.List;

import org.exemple.demo.consumer.dao.AbonneDao;
import org.exemple.demo.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.exemple.demo.hibernate.*;
import org.exemple.demo.consumer.dao.SiteDao;
import org.exemple.demo.entities.Site;

public class SiteService {
private static SiteDao SiteDao;
	
	public SiteService() {
		SiteDao = new SiteDao();
	}

	public void persist(Site Site) {
		SiteDao.openCurrentSessionwithTransaction();
		SiteDao.persist(Site);
		SiteDao.closeCurrentSessionwithTransaction();
	}

	public void update(Site Site) {
		SiteDao.openCurrentSessionwithTransaction();
		SiteDao.update(Site);
		SiteDao.closeCurrentSessionwithTransaction();
	}

	public Site findById(String id) {
		SiteDao.openCurrentSession();
		Site Site = SiteDao.findById(id);
		SiteDao.closeCurrentSession();
		return Site;
	}

	public void delete(String id) {
		SiteDao.openCurrentSessionwithTransaction();
		Site Site = SiteDao.findById(id);
		SiteDao.delete(Site);
		SiteDao.closeCurrentSessionwithTransaction();
	}

	public List<Site> findAll() {
		SiteDao.openCurrentSession();
		List<Site> Sites = SiteDao.findAll();
		SiteDao.closeCurrentSession();
		return Sites;
	}

	public void deleteAll() {
		SiteDao.openCurrentSessionwithTransaction();
		SiteDao.deleteAll();
		SiteDao.closeCurrentSessionwithTransaction();
	}

	public SiteDao SiteDao() {
		return SiteDao;
	}

}
