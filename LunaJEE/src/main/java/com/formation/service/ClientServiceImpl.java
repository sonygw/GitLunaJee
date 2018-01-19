/**
 * 
 */
package com.formation.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.DAO.ClientDAO;
import com.formation.model.Client;

/**
 * @author SDJ09
 *
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDao;

	public ClientServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Client SelectClient(int id) {

		return clientDao.SelectClient(id);

	}

	@Override
	public ArrayList<Client> SelectAllClients() {
		return clientDao.SelectAllClients();
	}

	@Override
	public boolean DeleteClient(Client obj) {

		if (clientDao.DeleteClient(obj).getIdClient() != 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean SaveOrUpdateClient(Client obj) {

		if (clientDao.SaveOrUpdateClient(obj).getIdClient() != 0)
			return true;
		else
			return false;
	}

	@Override
	public ArrayList<Client> SelectAllClientsByName(String nom) {

		return clientDao.SelectAllClientsByName(nom);
	}

	@Override
	public boolean SelectLastClient() {

		if (clientDao.SelectLastClient().getIdClient() != 0)
			return true;
		else
			return false;


	}

}