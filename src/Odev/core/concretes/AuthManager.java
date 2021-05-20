package Odev.core.concretes;

import Odev.business.abstracts.UserService;
import Odev.core.abstracts.AuthService;
import Odev.core.abstracts.UserValidationService;
import Odev.core.abstracts.VerificationService;
import Odev.entities.concretes.User;

public class AuthManager implements AuthService{

	UserService userService;
	UserValidationService userValidationService;
	VerificationService verificationService;
	


	public AuthManager() {

	}

	public AuthManager(UserService userService,VerificationService verificationService,UserValidationService userValidationService) {
		super();
		this.userService = userService;
		this.verificationService=verificationService;
		this.userValidationService=userValidationService;

	}
	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {

		User userToRegister = new User(id, firstName, lastName, email, password);
		if(!this.userValidationService.registerValidator(userToRegister))
		{
			System.out.println("Kullan�c� bilgilerinizi kontrol ediniz!");
		}
		
		if(!checkIfUserExists(email))
		{
			System.out.println("Bu e-mail adresi ile kay�t mevcut. L�tfen ba�ka bir mail adresi giriniz.");
			return;
		}
		if (!this.verificationService.verificate(userToRegister)) {
			System.out.println("�yelik do�rulama i�lemi tamamlanmad��� i�in kay�t yap�lamad�!");
			return;
		}

		userService.add(userToRegister);
		
	}

	@Override
	public void login(String email, String password) {
		if(!this.userValidationService.loginValidator(email, password))
		{
			System.out.println("Giri� bilgilerinizi kontrol ediniz!");
			return;
		}
		User userToLogin=userService.getByEmailAndPassword(email, password);
		
		if (userToLogin == null) {
			System.out.println("E-posta veya �ifrenizi kontrol ediniz!");
			return;
		}
		if(!checkIfUserVerified(userToLogin)) 
		{
			System.out.println("�yelik do�rulama i�lemi tamamlanamad��� i�in giri� yap�lamad�!");
			return;
		}
		System.out.println("Giri� ba�ar�l�! Ho�geldiniz, " + userToLogin.getFirstName() + " " + userToLogin.getLastName());
	}
	
	private boolean checkIfUserExists(String email)
	{
		return userService.getByMail(email)==null;
	}
	
	private boolean checkIfUserVerified(User user)
	{
		return verificationService.verificate(user);
	}

}
