package com.example.repository;

import com.example.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wutthinan on 4/4/2016 AD.
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
