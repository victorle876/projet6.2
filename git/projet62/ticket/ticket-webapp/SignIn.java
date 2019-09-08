
public class SignIn {
	private String Mail_Abonne;
	private String Result;
	private String Password;

	
	public String getMail_Abonne()
	{
		return Mail_Abonne;	
	}


	public String getDate_Adhesion() {
		return Date_Adhesion;
	}
	
	public String getResult() {
		return Result;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	public void setResult(String Result) {
		this.Result = Result;
		
	public String DoLogIn()
	{
		 Result = ActionSupport.INPUT;
		 Abonne abonne = abonneService.findUserById(Id);
		 if (abonne !=null) {
			 httpServletRequest.changeSessionId();

             this.session.put("abonne", abonne);
             Result = ActionSupport.SUCCESS;
		 }
			 
		 }
	}
	
	

}
