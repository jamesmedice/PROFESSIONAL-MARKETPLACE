package com.it.gft.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.gft.global.dao.ProfileDAO;
import com.it.gft.global.model.Profile;
import com.it.gft.global.service.ProfileService;

/**
 * 
 * @author TOSS
 *
 */
@Service("profileService")
@Transactional
public class ProfileServiceImpl implements ProfileService {

    @Autowired(required = true)
    private ProfileDAO profileDAO;

    @Override
    public void saveProfile(Profile entity) {
	profileDAO.save(entity);
    }

    @Override
    public List<Profile> findAllProfiles(Boolean orderBy, String name) {
	return profileDAO.findAll(orderBy, name);
    }

    @Override
    public List<Profile> findAllProfiles() {
	return profileDAO.findAll(false, null);
    }

    @Override
    public void deleteProfileById(Integer id) {
	profileDAO.deleteById(id);
    }

    @Override
    public void deleteProfile(Profile entity) {
	profileDAO.delete(entity);
    }

    @Override
    public Profile findById(Integer id) {
	return profileDAO.findById(id);
    }

    @Override
    public void updateProfile(Profile entity) {
	profileDAO.update(entity);
    }

}
