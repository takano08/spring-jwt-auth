package com.rdbf.demo.apiauth.controller;

import com.rdbf.demo.apiauth.domain.Applicant;
import com.rdbf.demo.apiauth.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicantController {

    private final ApplicantRepository applicantRepository;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    ApplicantController(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }







    @PostMapping(value = "/applicant")
    public void createApplicant( @RequestBody Applicant creteApplicantData) {


        applicantRepository.createApplicant(creteApplicantData);

    }











}
