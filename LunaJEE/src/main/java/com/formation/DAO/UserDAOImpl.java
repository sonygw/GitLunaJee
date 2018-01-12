package com.formation.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.formation.model.User;

public class UserDAOImpl implements UserDAO {
	
	private Connection conn;


public UserDAOImpl() {
	// TODO Auto-generated constructor stub
}


	public UserDAOImpl(Connection conn) {
	super();
	this.conn = conn;
}


	@Override
	public ArrayList<User> SelectAllUsers() {
		
		ArrayList<User> users = new ArrayList<User>(); 
		User user = null;
		
		ResultSet result = null;
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM user");
			
			while(result.next()) {
				user = new User(result.getInt("idUser"), result.getString("nom"), result.getString("login"), result.getString("mdp"), result.getBoolean("admin"));
				users.add(user);
			}
		
			} catch(SQLException e) {
				e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean UpdateUser(User user, int id) {
		
		boolean result = false;


		try {
			Statement state = conn.createStatement();
			state.executeUpdate("UPDATE user SET nom ='"+ user.getNom() + "', login='" + user.getLogin() + "', mdp= '"
					+ user.getMotDePasse() + "', admin= " + user.isAdmin() + " WHERE idUser=" + id);
			result = true;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public boolean CreateUser(User user) {

		boolean result = false;


		try {
			Statement state = conn.createStatement();
			state.executeUpdate("INSERT INTO user values (null, '"+ user.getNom() + "','" + user.getLogin() + "','"
					+ user.getMotDePasse() + "'," + user.isAdmin());
			result = true;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public boolean DeleteUser(int id) {
		
		
		boolean result = false;
	
		try {
			Statement state = conn.createStatement();
			state.executeUpdate("DELETE FROM user WHERE idUser=" + id);
			result = true;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public User SelectUser(int id) {
		
		ResultSet result;
		User user = null;
		
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM user WHERE idUser=" + id);
			result.next();
			user = new User(result.getInt("idUser"), result.getString("nom"), result.getString("login"), result.getString("mdp"), result.getBoolean("admin"));

			} catch(SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
	}
	
	
