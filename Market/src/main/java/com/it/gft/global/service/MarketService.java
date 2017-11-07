package com.it.gft.global.service;

import java.util.List;

import com.it.gft.global.model.Market;

public interface MarketService {

    void saveClient(Market client);

    List<Market> findAllClients(Boolean orderBy, String name);

    List<Market> findAllClients();

    void deleteClientById(Integer id);

    void deleteClient(Market Client);

    Market findById(Integer id);

    void updateClient(Market Client);
}
