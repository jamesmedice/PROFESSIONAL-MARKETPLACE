package com.it.gft.global.service;

import java.util.List;

import com.it.gft.global.model.FilterEvent;

public interface FilterEventService {

    void save(FilterEvent filterEvent);

    List<FilterEvent> findAll();

    FilterEvent findById(Integer id);

    void update(FilterEvent filterEvent);
}
