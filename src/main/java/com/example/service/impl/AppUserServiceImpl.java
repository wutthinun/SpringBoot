package com.example.service.impl;

import com.example.domain.AppUser;
import com.example.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wutthinan on 4/4/2016 AD.
 */
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser update(AppUser appUser) {
        return appUserRepository.saveAndFlush(appUser);
    }

    @Override
    public void delete(Long id) {
        appUserRepository.delete(appUserRepository.findOne(id));
    }

    @Override
    public AppUser findOne(Long id) {
        return appUserRepository.findOne(id);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }
}
