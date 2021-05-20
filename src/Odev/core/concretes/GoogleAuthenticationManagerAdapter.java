package Odev.core.concretes;

import Odev.core.abstracts.AuthService;
import Odev.googleAuthenticator.GoogleAuthenticatorManager;

public class GoogleAuthenticationManagerAdapter implements AuthService{
	GoogleAuthenticatorManager manager=new GoogleAuthenticatorManager();

	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		manager.register(id,firstName,lastName,email,password);
		System.out.println("Google hesabý ile kayýt olundu : " + email);
	}

	@Override
	public void login(String email, String password) {
		manager.login(email, password);
		System.out.println("Google hesabý ile giriþ yapýldý : " + email);
	}
}
