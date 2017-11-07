package com.it.gft.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.gft.global.dao.MarketDAO;
import com.it.gft.global.model.Market;
import com.it.gft.global.service.MarketService;

/**
 * 
 * @author TOSS
 *
 */
@Service("marketService")
@Transactional
public class MarketServiceImpl implements MarketService {

    @Autowired(required = true)
    private MarketDAO marketDAO;

    @Override
    public void saveClient(Market client) {
	marketDAO.save(client);
    }

    @Override
    public List<Market> findAllClients(Boolean orderBy, String name) {
	return marketDAO.findAll(orderBy, name);
    }

    @Override
    public List<Market> findAllClients() {
	return marketDAO.findAll(false, null);
    }

    @Override
    public void deleteClientById(Integer id) {
	marketDAO.deleteById(id);
    }

    @Override
    public void deleteClient(Market client) {
	marketDAO.delete(client);
    }

    @Override
    public Market findById(Integer id) {
	return marketDAO.findById(id);
    }

    @Override
    public void updateClient(Market client) {
	marketDAO.update(client);
    }

}
