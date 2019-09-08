package org.demo.webapp.struts.ActionSupport;
import com.opensymphony.xwork2.Action.*;

import org.exemple.demo.entities.*;
import org.exemple.demo.consumer.dao.*;
import org.exemple.demo.consumer.*;
import org.exemple.demo.business.*;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String Nom_Abonne;

	private String Prenom_Abonne;

	private String Date_Naissance;

	private String Password;

	private String Role_Abonne;
	private String Mail_Abonne;
	private String Date_Adhesion;
	private String Niveau_Abonne;
	private String Result;

	public void setNom_Abonne(String Nom_Abonne) {
		this.Nom_Abonne = Nom_Abonne;
	}

	public void setPrenom_Abonne(String Prenom_Abonne) {
		this.Prenom_Abonne = Prenom_Abonne;
	}

	public void setDate_Naissance(String Date_Naissance) {
		this.Date_Naissance = Date_Naissance;
	}

	public void setRole_Abonne(String Role_Abonne) {
		this.Role_Abonne = Role_Abonne;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	public void setResult(String Result) {
		this.Result = Result;
	}

	public void setMail_Abonne(String Mail_Abonne) {
		this.Mail_Abonne = Mail_Abonne;
	}

	public void setdate_adhesion(String Date_Adhesion) {
		this.Date_Adhesion = Date_Adhesion;
	}

	public String getNom_Abonne() {
		return Nom_Abonne;
	}

	public String getPrenom_Abonne() {
		return Prenom_Abonne;
	}

	public String getDate_naissance() {
		return Date_Naissance;
	}
	
	public String getResult() {
		return Result;
	}

	public String getRole_Abonne() {
		return Role_Abonne;
	}

	public String getPassword() {
		return Password;
	}

	public String getMail_Abonne()
	{
		return Mail_Abonne;	
	}


	public String getDate_Adhesion() {
		return Date_Adhesion;
	}

	@Override
	public String DoRegister() throws Exception {
		
		if (!Nom_Abonne.isEmpty()) && (!PreNom_Abonne.isEmpty()) && (!password.isEmpty())
		&& 
		{
			abonne = new Abonne();
			abonne.set(getNom_Abonne);
			abonne.set(getPrenom_Abonne);
			abonne.set(getDate_Naissance);
			abonne.set(getRole_Abonne);
			abonne.set(getPassword);
			abonne.set(getMail_Abonne);
			abonne.set(getDate_Adhesion);
			
			abonneService.persist(abonne);
	
			result = ActionSupport.SUCCESS;
			else
			{
				this.addActionError("Les champs principaux doivent être remplies");
			}
	}

	public void throwException() throws Exception {
		throw new Exception("Exception thrown from throwException");
	}

}
