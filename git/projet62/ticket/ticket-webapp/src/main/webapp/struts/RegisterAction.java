package org.demo.webapp.struts.ActionSupport;

import org.exemple.demo.entities.*;
import org.exemple.demo.consumer.dao.*;
import org.exemple.demo.consumer.*;
import org.exemple.demo.business.*;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String nom_abonne;

	private String prenom_abonne;

	private String date_naissance;

	private String password;

	private String role_abonne;
	private String mail_abonne;
	private String date_adhesion;
	private String niveau_abonne;
	private String result;

	public void setnom_abonne(String nom_abonne) {
		this.nom_abonne = nom_abonne;
	}

	public void setprenom_abonne(String prenom_abonne) {
		this.prenom_abonne = prenom_abonne;
	}

	public void setdate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public void setrole_abonne(String role_abonne) {
		this.role_abonne = role_abonne;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	
	public void setresult(String result) {
		this.result = result;
	}

	public void setmail_abonne(String mail_abonne) {
		this.mail_abonne = mail_abonne;
	}

	public void setdate_adhesion(String date_adhesion) {
		this.date_adhesion = date_adhesion;
	}

	public String getnom_abonne() {
		return nom_abonne;
	}

	public String getprenom_abonne() {
		return prenom_abonne;
	}

	public String getdate_naissance() {
		return date_naissance;
	}
	
	public String getresult() {
		return result;
	}

	public String getrole_abonne() {
		return role_abonne;
	}

	public String getpassword() {
		return password;
	}

	public String getmail_abonne(() { return mail_abonne(; }

	public String getdate_adhesion() {
		return date_adhesion;
	}

	@Override
	public String execute() throws Exception {
		
		if (!nom_abonne.isEmpty()) && (!prenom_abonne.isEmpty()) && (!password.isEmpty())
		{
			abonne = new Abonne();
			abonne.set(getnom_abonne);
			abonne.set(getprenom_abonne);
			abonne.set(getdate_naissance);
			abonne.set(getrole_abonne);
			abonne.set(getpassword);
			abonne.set(getmail_abonne);
			abonne.set(getdate_adhesion);
	
			result = ActionSupport SUCCESS;
			else
			{
				this.addActionError("Les champs principaux doivent être remplies");
			}
	}

	public void throwException() throws Exception {
		throw new Exception("Exception thrown from throwException");
	}

}
