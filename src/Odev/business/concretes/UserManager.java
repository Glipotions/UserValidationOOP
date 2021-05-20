package Odev.business.concretes;

import java.util.List;

import Odev.business.abstracts.UserService;
import Odev.dataAccess.abstracts.UserDao;
import Odev.entities.concretes.User;

public class UserManager implements UserService{

	UserDao userDao;
	public UserManager(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public void add(User user) {
		userDao.add(user);
		System.out.println("Kullanýcý eklendi.");
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		System.out.println("Kullanýcý güncellendi.");
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		System.out.println("Kullanýcý silindi");
		
	}

	@Override
	public User getById(int id) {
		
		return userDao.getById(id);
	}

	@Override
	public User getByMail(String email) {
	
		return userDao.getByMail(email);
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		
		return userDao.getByEmailAndPassword(email, password);
	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}
}
