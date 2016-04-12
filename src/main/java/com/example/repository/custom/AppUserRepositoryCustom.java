package com.example.repository.custom;

import com.example.domain.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by wutthinan on 4/12/2016 AD.
 */
@Repository
@Slf4j
public class AppUserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    public AppUser findById(Long id) {
        Criteria criteria = ((Session)entityManager.getDelegate()).createCriteria(AppUser.class);
        criteria.add(Restrictions.eq("id",id));
        return (AppUser) criteria.list().get(0);
    }
}
