package org.exemple.demo.dao;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.exemple.demo.entities.*;

@Transactional
public class AbonneDao implements IAbonneDao, Serializable {
	private static final long serialVersionUID = 1L;
	  @PersistenceContext
	  private EntityManager em;
	  private Abonne abonne;
	  private Abonne abonne1 = null;
	  // liste des abonnes
	  @SuppressWarnings("unchecked")
	  public List<Abonne> getAllAbonnes(){
	      return em.createQuery("select * from Abonne").getResultList();
	  }
	  
		public Abonne getAbonneById(long id) {
	    	return (Abonne) em.find(Abonne.class, id);
	  }

		public Abonne createAbonne(int id,String NomAbonne, String PrenomAbonne,
				String Password, String MailAbonne, String RoleAbonne,
				String NiveauAbonne, Timestamp DateAdhesion, Timestamp DateNaissance) {
			Abonne NouvelAbonne = new Abonne(id, NomAbonne,PrenomAbonne,
					Password, MailAbonne, RoleAbonne,NiveauAbonne,DateAdhesion,
					DateNaissance);
			NouvelAbonne.setId(abonne.getId());
			NouvelAbonne.setNomAbonne(abonne.getNomAbonne()); 
			NouvelAbonne.setPrenomAbonne(abonne.getPrenomAbonne());
			NouvelAbonne.setPassword(abonne.getPassword());
			NouvelAbonne.setMailAbonne(abonne.getMailAbonne());
			NouvelAbonne.setRoleAbonne(abonne.getRoleAbonne());
			NouvelAbonne.setNiveauAbonne(abonne.getNiveauAbonne());
			NouvelAbonne.setDateAdhesion(abonne.getDateAdhesion());
			NouvelAbonne.setDateNaissance(abonne.getDateNaissance());
		    em.persist(NouvelAbonne);
		    return NouvelAbonne;
	  }
		
		public Abonne UpdateAbonne() {
			em.getTransaction().begin();
			 
			Abonne abonne1 = em.find(Abonne.class, abonne.getId());
			abonne1.setNomAbonne(abonne.getNomAbonne());       
			em.getTransaction().commit();
			em.close();
			
			return abonne1;
			
		}

		public void delete(Abonne abonne) {
		  em.remove(em.merge(abonne));
	  }
	  
	  public void deleteAll() {
		  ((List<Abonne>)em.createQuery("select * from Abonne").getResultList()).stream().forEach((abonne2) -> {
		      em.remove(abonne2);
		  });
	  }
}
