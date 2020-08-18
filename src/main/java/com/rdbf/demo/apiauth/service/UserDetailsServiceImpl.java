package com.rdbf.demo.apiauth.service;

import com.rdbf.demo.apiauth.controller.SampleController;
import com.rdbf.demo.apiauth.domain.People;
import com.rdbf.demo.apiauth.repository.PeopleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PeopleRepository peopleRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    public UserDetailsServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 本来ならここでDBなどからユーザを検索することになるが、サンプルのためリストに含まれるかで判定している
//        if(!usernameList.contains(username)){
//            throw new UsernameNotFoundException(username);
//        }

        People people = peopleRepository.findByLoginId(username);

        if(people == null){
            throw new UsernameNotFoundException("User Not Found with -> username or email: " + username);
        }

        LOGGER.info("ゆーざーねーむ"+username+":::::::::::people::::::"+people.getLoginId());


        return User.withUsername(username)
                .password(people.getPassword())
                .authorities("ROLE_USER") // ユーザの権限
                .build();
    }

}
