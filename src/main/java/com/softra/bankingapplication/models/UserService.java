package com.softra.bankingapplication.models;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{
	@Autowired
	private UserDao userdao; //all repository uses IDao. Use qualifier to specify
	
	//to find a user
	@Override
	public User findById(int userid) {
		System.out.println("Inside findOne of UserService");
		Optional<User> user = userdao.findById(userid);
//		return dao.findById(id);
		return user.get();
	}
	
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		System.out.println("Inside findByUsernameAndPassword of UserService");
		return userdao.findByUsernameAndPassword(username, password);
	}
	
	@Override
	//to create a user
	public User save(User user) {
		System.out.println("Inside save of UserService");
		return userdao.save(user);
	}
	
	@Override
	//to change a user password
	public void updatePassword(String password, int id) {
		System.out.println("Inside updatePassword of UserService");
		userdao.updatePassword(password, id);
	}

	@Override
	public void logout() {
		System.out.println("Logged out");
		
	}

	
}
