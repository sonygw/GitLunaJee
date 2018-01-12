package com.formation.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.formation.model.ArtCom;

/**
 * 
 * @author Lou
 *
 */
public class ArtComDAOSQL implements ArtComDAO {

	Connection conn = null;
	Statement state = null;

	/**
	 * constructeur vide
	 */
	public ArtComDAOSQL() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructeur avec la connection
	 * 
	 * @param conn
	 *            connexionJDBC
	 */
	public ArtComDAOSQL(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public ArrayList<ArtCom> SelectAllArtComFromCommande(int idCommande) {
		ResultSet result = null;
		ArrayList<ArtCom> articles = new ArrayList<ArtCom>();

		ArtCom resultat = null;

		try {
			state = conn.createStatement();
			result = state.executeQuery("Select * from artCom where idCommande =" + idCommande);

			while (result.next()) {
				resultat = new ArtCom(result.getInt("idArtCom"), result.getInt("idCommande"),
						result.getInt("idArticle"), result.getInt("quantite"));
				articles.add(resultat);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return articles;
	}

	@Override
	public boolean DeleteArtComFromCommande(ArtCom obj) {

		boolean result = false;
		try {
			state = conn.createStatement();
			state.executeUpdate("Delete from artCom where idArtCom =" + obj.getIdArtCom());
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean UpdateArtComFromCommande(ArtCom obj, int idArtCom) {

		boolean result = false;

		try {
			state = conn.createStatement();
			state.executeUpdate("Update artCom SET idCommande = " + obj.getIdArtCom() + ", idArticle = "
					+ obj.getIdArticle() + "," + obj.getQuantite() + " where idArtCom = " + idArtCom);
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean CreateArtComFromCommande(ArtCom obj) {
		boolean result = false;

		try {
			state = conn.createStatement();
			state.executeUpdate("insert into artCom values (null, " + obj.getIdCommande() + "," + obj.getIdArticle()
					+ "," + obj.getQuantite() + ")");
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean DeleteArtComFromIdCommande(int id) {

		boolean result = false;
		try {
			state = conn.createStatement();
			state.executeUpdate("Delete from artCom where idCommande =" + id);
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public boolean DeleteArtComFromIdArticle(int id) {
		boolean result = false;
		try {
			state = conn.createStatement();
			state.executeUpdate("Delete from artCom where idArticle =" + id);
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
