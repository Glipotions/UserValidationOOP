package Odev.core.abstracts;

import Odev.entities.concretes.User;

public interface UserValidationService {

	boolean registerValidator(User user);
	boolean loginValidator(String email, String password);
}
