package com.formation.DAO;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.model.ArtCom;

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
		
		@SuppressWarnings("unchecked")
		TypedQuery<ArtCom> result = sessionFactory.getCurrentSession().createQuery("from artCom where idCommande =" +idCommande);
		return (ArrayList<ArtCom>) result.getResultList();

	}

	@Override
	public boolean DeleteArtComFromCommande(ArtCom obj) {
		
		sessionFactory.getCurrentSession().delete(obj);
		
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean UpdateArtComFromCommande(ArtCom obj, int idArtCom) {

		Query query = sessionFactory.getCurrentSession().createQuery("Update artCom SET idCommande = " + obj.getIdArtCom() + ", idArticle = "
				+ obj.getIdArticle() + "," + obj.getQuantite() + " where idArtCom = " + idArtCom);
			

			query.executeUpdate();
		return true;
	}

	@Override
	public boolean CreateArtComFromCommande(ArtCom obj) {

		sessionFactory.getCurrentSession().save(obj);

		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean DeleteArtComFromIdCommande(int id) {

		
		
		Query query = sessionFactory.getCurrentSession().createQuery("Delete from artCom where idCommande =" + id);
		
		query.executeUpdate();

		return true;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean DeleteArtComFromIdArticle(int id) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("Delete from artCom where idArticle =" + id);
		query.executeUpdate();
		return true;
	}

}