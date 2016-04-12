package com.example.rest;

import com.example.domain.AppUser;
import com.example.service.impl.AppUserService;
import flexjson.JSONDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wutthinan on 4/4/2016 AD.
 */
@RestController
@RequestMapping("/appuser")
@Slf4j
public class AppUserRest {
    @Autowired
    AppUserService appUserService;

    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public AppUser findOne(@RequestParam(value = "id")Long id) {
        return appUserService.findOne(id);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<AppUser> findAll() {
        return appUserService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody String json) {
        try {
            AppUser appUser = new JSONDeserializer<AppUser>().use(null, AppUser.class).deserialize(json);
            appUserService.save(appUser);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
