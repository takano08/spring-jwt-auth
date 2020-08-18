package com.rdbf.demo.apiauth.service;

import com.rdbf.demo.apiauth.domain.People;
import com.rdbf.demo.apiauth.repository.PeopleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class SampleService  {

    private final PeopleRepository peopleRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleService.class);

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public SampleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void createAccount(String loginId,String password){

        peopleRepository.createAccount(loginId,password);

    }

}
