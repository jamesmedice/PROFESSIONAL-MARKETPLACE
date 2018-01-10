package com.it.gft.global.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private OauthRepository oauthRepository;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
	User user = oauthRepository.getByUsername(s);
	return user;
    }

}
