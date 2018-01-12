package com.formation.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.formation.model.Commande;

public class CommandeDAOImpl implements CommandeDAO {

	private Connection conn;
	private Statement state;

	public CommandeDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public CommandeDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public ArrayList<Commande> SelectAllCommandes() {

		ArrayList<Commande> commandes = new ArrayList<Commande>();
		Commande commande = null;

		ResultSet result = null;
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM commande");

			while (result.next()) {
				commande = new Commande(result.getInt("idCommande"), result.getString("ref"),
						result.getDouble("prixHT"), result.getString("adresse"), result.getInt("idClient"),
						result.getString("date"), result.getString("reglement"));
				commandes.add(commande);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commandes;
	}

	@Override
	public ArrayList<Commande> SelectCommandesClient(int idclient) {
		ResultSet result = null;
		Commande commande = null;
		ArrayList<Commande> resultats = new ArrayList<Commande>();
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM commande WHERE idClient=" + idclient);
			while (result.next()) {
				commande = new Commande(result.getInt("idCommande"), result.getString("ref"),
						result.getDouble("prixHT"), result.getString("adresse"), result.getInt("idClient"),
						result.getString("date"), result.getString("reglement"));
				resultats.add(commande);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultats;
	}

	@Override
	public Commande SelectCommande(int id) {
		ResultSet result = null;
		Commande commande = null;

		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM commande WHERE idCommande=" + id);
			result.next();
			commande = new Commande(result.getInt("idCommande"), result.getString("ref"), result.getDouble("prixHT"),
					result.getString("adresse"), result.getInt("idClient"), result.getString("date"),
					result.getString("reglement"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commande;
	}

	@Override
	public ArrayList<Commande> SelectCommandesArticles(int id) {
		ResultSet result = null;
		Commande commande = null;
		ArrayList<Commande> resultats = new ArrayList<Commande>();

		try {
			state = conn.createStatement();
			result = state.executeQuery(
					"SELECT * FROM commande c, artcom a WHERE c.idCommande=a.idCommande AND a.idArticle=" + id);
			while (result.next()) {
				commande = new Commande(result.getInt("idCommande"), result.getString("ref"),
						result.getDouble("prixHT"), result.getString("adresse"), result.getInt("idClient"),
						result.getString("date"), result.getString("reglement"));
				resultats.add(commande);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultats;
	}

	@Override
	public boolean CreateCommande(Commande commande) {
		boolean result = false;

		try {
			state = conn.createStatement();
			String req = "INSERT INTO commande values (null,'" + commande.getRef() + "'," + commande.getPrixHT() + ",'"
					+ commande.getAdresse() + "'," + commande.getIdClient() + ",'" + commande.getDate() + "','"
					+ commande.getReglement() + "');";
			state.executeUpdate(req);

			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean UpdateCommande(Commande commande, int id) {
		boolean result = false;

		try {
			state = conn.createStatement();
			String str = "UPDATE commande SET ref = '" + commande.getRef() + "',prixHT =" + commande.getPrixHT()
					+ ", adresse='" + commande.getAdresse() + "', idClient= " + commande.getIdClient() + ", date= '"
					+ commande.getDate() + "', reglement= '" + commande.getReglement() + "' WHERE idCommande=" + id
					+ ";";
			state.executeUpdate(str);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean DeleteCommande(int id) {
		boolean result = false;

		try {
			state = conn.createStatement();
			state.executeUpdate("DELETE FROM commande WHERE idCommande=" + id);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Commande SelectLastCommande() {
		ResultSet result = null;
		Commande commande = null;

		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM commande ORDER BY idCommande DESC LIMIT 1 ");
			if (result.next())
				commande = new Commande(result.getInt("idCommande"), result.getString("ref"),
						result.getDouble("prixHT"), result.getString("adresse"), result.getInt("idClient"),
						result.getString("date"), result.getString("reglement"));
			else {
				commande = new Commande();
				commande.setIdCommande(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return commande;
	}

}
