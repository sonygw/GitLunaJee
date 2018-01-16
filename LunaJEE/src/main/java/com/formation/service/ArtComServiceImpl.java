package com.formation.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.DAO.ArtComDAO;
import com.formation.model.ArtCom;

@Service
@Transactional

public class ArtComServiceImpl implements ArtComService {

	@Autowired
	private ArtComDAO artComDao;

	/**
	 * constructeur vide
	 */
	public ArtComServiceImpl() {
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

		return artComDao.SelectAllArtComFromCommande(idCommande);

	}

	@Override
	public boolean DeleteArtComFromCommande(ArtCom obj) {

		return artComDao.DeleteArtComFromCommande(obj);

	}

	@Override
	public boolean UpdateArtComFromCommande(ArtCom obj, int idArtCom) {

		return artComDao.UpdateArtComFromCommande(obj, idArtCom);
	}

	@Override
	public boolean CreateArtComFromCommande(ArtCom obj) {

		return artComDao.CreateArtComFromCommande(obj);
	}

	@Override
	public boolean DeleteArtComFromIdCommande(int id) {

		return artComDao.DeleteArtComFromIdCommande(id);

	}


	@Override
	public boolean DeleteArtComFromIdArticle(int id) {

		return artComDao.DeleteArtComFromIdArticle(id);
	}

}