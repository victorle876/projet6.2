package org.exemple.demo.consumer.dao;

public class DaoFactory {
private final AbonneInterfaceDao AbonneDao = new AbonneDao();
	
  public AbonneDao getAbonneDao() {
//	  AbonneDao AbonneDao;
	return new AbonneDao();
  }
  
  public CommentaireDao getCommentaireDao(){
		return new CommentaireDao();
	}
  
  public CotationDao getCotationDao(){
		return new CotationDao();
	}
  
  public NiveauDao getNiveauDao(){
		return new NiveauDao();
	}
  public ReservationDao getReservationDao(){
		return new ReservationDao();
	}
  public SecteurDao SecteurDao(){
		return new SecteurDao();
	}
  public SiteDao getSiteDao(){
		return new SiteDao();
	}
  
  public TopologieDao getTopologieDao(){
		return new TopologieDao();
	}
  
  
}
