package org.demo.webapp.struts.ActionSupport;
import org.exemple.demo.entities.*;
import org.exemple.demo.consumer.dao.*;
import org.exemple.demo.consumer.*;
import org.exemple.demo.business.*;

public class RegisterAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

    private String nom_abonne ;
	
    private String prenom_abonne ;
	
    private String date_naissance ;
	
    private String password ;

    private String role_abonne ;
    private String mail_abonne ;
    private String date_adhesion ;
    private String niveau_abonne ;
	

	@Override
	public String execute() throws Exception {

		
		return SUCCESS;
	}

	public void throwException() throws Exception {
		throw new Exception("Exception thrown from throwException");
	}

}