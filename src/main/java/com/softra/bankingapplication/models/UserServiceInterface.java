package com.softra.bankingapplication.models;

import java.util.Optional;

public interface UserServiceInterface {
	
	public User findById(int userid);
	
	//login
	public User findByUsernameAndPassword(String username, String password);
	
	public User save(User user);
	
	public void updatePassword(String password, int id);
	
	//logout
	public void logout();
}
