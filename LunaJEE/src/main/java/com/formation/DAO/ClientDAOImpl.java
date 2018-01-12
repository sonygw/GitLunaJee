/**
 * 
 */
package com.formation.DAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.formation.model.Client;

/**
 * @author SDJ09
 *
 */
public class ClientDAOImpl implements ClientDAO {

	Connection conn = null;
	Statement state = null;

	public ClientDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public ClientDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Client SelectClient(int id) {

		ResultSet result = null;

		Client resultat = null;

		try {
			state = conn.createStatement();
			result = state.executeQuery("Select * from client where idClient = " + id);
			result.next();
			resultat = new Client(result.getInt("idClient"), result.getString("nom"), result.getString("prenom"),
					result.getString("mail"), result.getString("adresse"), result.getBoolean("carteFidel"),
				 result.getString("telephone"),result.getString("remarques"), result.getString("dateCrea"), result.getString("code"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultat;
	}

	@Override
	public ArrayList<Client> SelectAllClients() {
		ResultSet result = null;
		ArrayList<Client> clients = new ArrayList<Client>();

		Client resultat = null;

		try {
			state = conn.createStatement();
			result = state.executeQuery("Select * from client");

			while (result.next()) {
				resultat = new Client(result.getInt("idClient"), result.getString("nom"), result.getString("prenom"),
						result.getString("mail"), result.getString("adresse"), result.getBoolean("carteFidel"),
						result.getString("remarques"), result.getString("telephone"), result.getString("dateCrea"), result.getString("code"));
				clients.add(resultat);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clients;
	}

	@Override
	public boolean DeleteClient(Client obj) {
		boolean result = false;
		try {
			state = conn.createStatement();
			state.executeUpdate("Delete from client where idClient =" + obj.getIdClient());
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean UpdateClient(Client obj, int id) {
		boolean result = false;

		try {
			state = conn.createStatement();
			
			String str = "Update client SET code = '" + obj.getCode() + "' ,nom = '" + obj.getNom() + "', prenom = '" + obj.getPrenom()
			+ "', mail = '" + obj.getEmail() + "', adresse = '" + obj.getAdresse() + "', carteFidel = "
			+ obj.isCarteFidelite() + ", remarques = '" + obj.getRemarques() + "', telephone = '"
			+ obj.getNumeroTelephone() + "', dateCrea = '" + obj.getDate() + "' where idClient = " + id + ";";
			
			state.executeUpdate(str);
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean CreateClient(Client obj) {
		boolean result = false;

		try {
			state = conn.createStatement();
			state.executeUpdate("insert into client values (null, '" + obj.getCode() + "','" + obj.getNom() + "','" + obj.getPrenom() + "','"
					+ obj.getEmail() + "','" + obj.getAdresse() + "'," + obj.isCarteFidelite() + ",'"
					+ obj.getRemarques() + "','" + obj.getNumeroTelephone() + "','" + obj.getDate() + "');");

			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<Client> SelectAllClientsByName(String nom) {
		ResultSet result = null;
		ArrayList<Client> clients = new ArrayList<Client>();

		Client resultat = null;

		try {
			state = conn.createStatement();
			result = state.executeQuery("Select * from client where nom like '" + nom + "%'");

			while (result.next()) {
				resultat = new Client(result.getInt("idClient"), result.getString("nom"), result.getString("prenom"),
						result.getString("mail"), result.getString("adresse"), result.getBoolean("carteFidel"),
						result.getString("remarques"), result.getString("telephone"), result.getString("dateCrea"), result.getString("code"));
				clients.add(resultat);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clients;
	}

	@Override
	public Client SelectLastClient() {
		ResultSet result = null;
		Client client = null;

		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM client ORDER BY idClient DESC LIMIT 1 ");
			result.next();
			client = new Client(result.getInt("idClient"), result.getString("nom"), result.getString("prenom"),
					result.getString("mail"), result.getString("adresse"), result.getBoolean("carteFidel"),
					result.getString("remarques"), result.getString("telephone"), result.getString("dateCrea"), result.getString("code"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

}
