package com.it.gft.global.service;

import java.util.List;

import com.it.gft.global.model.*;

public interface ProfileService {

    void saveProfile(Profile entity);

    List<Profile> findAllProfiles(Boolean orderBy, String name);

    List<Profile> findAllProfiles();

    void deleteProfileById(Integer id);

    void deleteProfile(Profile entity);

    Profile findById(Integer id);

    void updateProfile(Profile entity);
}
