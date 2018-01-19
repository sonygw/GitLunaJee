package com.formation.service;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.DAO.UserDAO;
import com.formation.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<User> SelectAllUsers() {

		return userDao.SelectAllUsers();
	}

	@Override
	public boolean SaveOrUpdateUser(User user) {

		if (userDao.SaveOrUpdateUser(user).getIdUser() != 0)
			return true;
		else
			return false;

	
	}

	

	@Override
	public boolean DeleteUser(User user) {

		if (userDao.DeleteUser(user).getIdUser() != 0)
			return false;
		else
			return true;
	}

	@Override
	public User SelectUser(int id) {

		return userDao.SelectUser(id);
	}
}
