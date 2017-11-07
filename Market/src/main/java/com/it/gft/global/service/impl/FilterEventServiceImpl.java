package com.it.gft.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.gft.global.dao.FilterEventDAO;
import com.it.gft.global.model.FilterEvent;
import com.it.gft.global.service.FilterEventService;

@Service("filterEventService")
@Transactional
public class FilterEventServiceImpl implements FilterEventService {

    @Autowired
    private FilterEventDAO filterEventDAO;

    @Override
    public void save(FilterEvent filterEvent) {
	filterEventDAO.save(filterEvent);
    }

    @Override
    public List<FilterEvent> findAll() {
	return filterEventDAO.findAll();
    }

    @Override
    public FilterEvent findById(Integer id) {
	return filterEventDAO.findById(id);
    }

    @Override
    public void update(FilterEvent filterEvent) {
	filterEventDAO.update(filterEvent);
    }

}
