package Odev;

import Odev.business.abstracts.UserService;
import Odev.business.concretes.UserManager;
import Odev.core.abstracts.AuthService;
import Odev.core.concretes.AuthManager;
import Odev.core.concretes.EmailVerificationManager;
import Odev.core.concretes.UserValidationManager;
import Odev.dataAccess.concretes.GlipoUserDao;

public class Main {
	public static void main(String[] args) {
		UserService userService = new UserManager(new GlipoUserDao());

		AuthService authService = new AuthManager(userService,new EmailVerificationManager(),new UserValidationManager());
		authService.register(1, "Hamza", "Kavak", "glipotions@gmail.com", "12345"); 
		authService.login("glipotions@gmail.com", "12345");
		
	}
}
