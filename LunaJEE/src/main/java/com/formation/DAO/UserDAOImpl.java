package com.formation.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.model.User;

public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<User> SelectAllUsers() {

		@SuppressWarnings("unchecked")
		ArrayList<User> users = (ArrayList<User>) sessionFactory.getCurrentSession().createQuery("from User")
				.getResultList();
		return users;
	}

	@Override
	public boolean UpdateUser(User user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	@Override
	public boolean CreateUser(User user) {

		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	@Override
	public boolean DeleteUser(User user) {

		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	public User SelectUser(int id) {

		return (User) sessionFactory.getCurrentSession().createQuery("FROM user WHERE idUser=" + id);
	}
}
