package com.formation.DAO;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.model.ArtCom;

/**
 * 
 * @author Lou
 *
 */
@Repository

public class ArtComDAOImpl implements ArtComDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * constructeur vide
	 */
	public ArtComDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructeur avec la connection
	 * 
	 * @param conn
	 *            connexionJDBC
	 */

	@Override
	public ArrayList<ArtCom> SelectAllArtComFromCommande(int idCommande) {
		
			//result = state.executeQuery("Select * from artCom where idCommande =" + idCommande);

		@SuppressWarnings("unchecked")
		TypedQuery<ArtCom> result = sessionFactory.getCurrentSession().createQuery("from artCom where idCommande =" +idCommande);
		return (ArrayList<ArtCom>) result.getResultList();

	}

	@Override
	public boolean DeleteArtComFromCommande(ArtCom obj) {

		boolean result = false;
		
		sessionFactory.getCurrentSession().delete(obj);
		result=true;
		
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean UpdateArtComFromCommande(ArtCom obj, int idArtCom) {

		boolean result = false;

		Query query = sessionFactory.getCurrentSession().createQuery("Update artCom SET idCommande = " + obj.getIdArtCom() + ", idArticle = "
				+ obj.getIdArticle() + "," + obj.getQuantite() + " where idArtCom = " + idArtCom);
			result = true;

			query.executeUpdate();
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean CreateArtComFromCommande(ArtCom obj) {
		boolean result = false;

		Query query = sessionFactory.getCurrentSession().createQuery("insert into artCom values (null, " + obj.getIdCommande() + "," + obj.getIdArticle()
		+ "," + obj.getQuantite() + ")");
			result = true;
			query.executeUpdate();

		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean DeleteArtComFromIdCommande(int id) {

		boolean result = false;
		
		Query query = sessionFactory.getCurrentSession().createQuery("Delete from artCom where idCommande =" + id);
		result = true;
		query.executeUpdate();

		return result;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean DeleteArtComFromIdArticle(int id) {
		boolean result = false;
		
		
		Query query = sessionFactory.getCurrentSession().createQuery("Delete from artCom where idArticle =" + id);
		query.executeUpdate();
		return result;
	}

}
