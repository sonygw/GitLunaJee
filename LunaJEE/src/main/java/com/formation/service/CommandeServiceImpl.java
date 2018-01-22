package com.formation.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.DAO.CommandeDAO;
import com.formation.model.Commande;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	private CommandeDAO commandeDao;

	@Override
	public ArrayList<Commande> SelectAllCommandes() {

		return commandeDao.SelectAllCommandes();
	}

	@Override
	public ArrayList<Commande> SelectCommandesClient(int idclient) {

		return commandeDao.SelectCommandesClient(idclient); 
	}

	@Override
	public Commande SelectCommande(int id) {

		return commandeDao.SelectCommande(id);
	}

	@Override
	public ArrayList<Commande> SelectCommandesArticles(int id) {

		return commandeDao.SelectCommandesArticles(id);
	}

	@Override
	public boolean SaveOrUpdateCommande(Commande commande) {
		if (commandeDao.SaveOrUpdateCommande(commande).getIdCommande() != 0)
			return true;
		else 
			return false;
	}

	@Override
	public boolean DeleteCommande(Commande commande) {
		if (commandeDao.DeleteCommande(commande).getIdCommande() != 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean SelectLastCommande() {

 	if (commandeDao.SelectLastCommande().getIdCommande() != 0)
			return true;
		else
			return false;
	}

}
