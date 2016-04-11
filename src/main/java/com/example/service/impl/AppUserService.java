package com.example.service.impl;

import com.example.domain.AppUser;

import java.util.List;

/**
 * Created by wutthinan on 4/4/2016 AD.
 */
public interface AppUserService {
    AppUser save(AppUser appUser);
    AppUser update(AppUser appUser);
    void delete(Long id);
    AppUser findOne(Long id);
    List<AppUser> findAll();
}
