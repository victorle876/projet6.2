package org.exemple.demo.services;
import java.util.List;
import javax.persistence.*;

import org.exemple.demo.consumer.dao.CotationDao;
import org.exemple.demo.consumer.dao.*;dao.*;
import org.exemple.demo.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.exemple.demo.hibernate.*;

public class CotationService {
	private static CotationDao CotationDao;
	
    public CotationService() {
    	CotationDao = new CotationDao();
    }

	public void persist(Cotation cotation) {
		CotationDao.openCurrentSessionwithTransaction();
		CotationDao.persist(cotation);
		CotationDao.closeCurrentSessionwithTransaction();
	}

	public void update(Cotation cotation) {
		CotationDao.openCurrentSessionwithTransaction();
		CotationDao.update(cotation);
		CotationDao.closeCurrentSessionwithTransaction();
	}

	public Cotation findById(String id) {
		CotationDao.openCurrentSession();
		Cotation Cotation = CotationDao.findById(id);
		CotationDao.closeCurrentSession();
		return Cotation;
	}

	public void delete(String id) {
		CotationDao.openCurrentSessionwithTransaction();
		Cotation Cotation = CotationDao.findById(id);
		CotationDao.delete(Cotation);
		CotationDao.closeCurrentSessionwithTransaction();
	}

	public List<Cotation> findAll() {
		CotationDao.openCurrentSession();
		List<Cotation> Cotations = CotationDao.findAll();
		CotationDao.closeCurrentSession();
		return Cotations;
	}

	public void deleteAll() {
		CotationDao.openCurrentSessionwithTransaction();
		CotationDao.deleteAll();
		CotationDao.closeCurrentSessionwithTransaction();
	}

	public CotationDao CotationDao() {
		return CotationDao;
	}

}

