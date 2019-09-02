
public class LoginAction {
	private static final long serialVersionUID = 1L;

	private String Mail_login;

	private String Password;

	private String Result;
	
	
	public void setMail_login(String Mail_login) {
		this.Mail_login = Mail_login;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public void setResult(String Result) {
		this.Result = Result;
	}
	
	public String getResult() {
		return Result;
	}

	public String getPassword() {
		return Password;
	}

	public String getMail_login() {
		return Mail_login;
	}
    
	public String Login(Mail_login,Password)
	{
		if (!Mail_login.isEmpty()) && (!Password.isEmpty())
		{
			Abonne abonne = abonneService.findUserById(Mail_login,password);
			if (Mail_login != null) && (Password != null)
			{
				result = ActionSupport.SUCCESS; 
			}
			
			else
			{
				result = ActionSupport.ERROR; 
			}
				
		}
	}
	
}
