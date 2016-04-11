package com.example.rest;

import com.example.domain.AppUser;
import com.example.service.impl.AppUserService;
import com.example.utils.HttpHeaderJson;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wutthinan on 4/4/2016 AD.
 */
@RestController
@RequestMapping("/appuser")
public class AppUserRest {
    @Autowired
    AppUserService appUserService;

    private static final Logger log = LoggerFactory.getLogger(AppUserRest.class);

    @RequestMapping(value = "/findOne", method = RequestMethod.POST)
    public ResponseEntity<String> findOne(@RequestParam(value = "id")Long id) {
        try {
            return new ResponseEntity<String>(new JSONSerializer()
                        .exclude("*.class")
                        .deepSerialize(appUserService.findOne(id).toString())
                        , HttpHeaderJson.getJsonHeader(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(HttpHeaderJson.getJsonHeader(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAll() {
        try {
            System.out.println("Find all user");
            System.out.println("user : "+appUserService.findAll().toString());
            return new ResponseEntity<String>(new JSONSerializer()
                    .exclude("*.class")
                    .deepSerialize(appUserService.findAll().toString())
                    , HttpHeaderJson.getJsonHeader(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(HttpHeaderJson.getJsonHeader(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody String json) {
        try {
            AppUser appUser = new JSONDeserializer<AppUser>().use(null, AppUser.class).deserialize(json);
            return new ResponseEntity<String>(new JSONSerializer()
                    .exclude("*.class")
                    .deepSerialize(appUser.toString())
                    , HttpHeaderJson.getJsonHeader(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(HttpHeaderJson.getJsonHeader(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
