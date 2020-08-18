package com.rdbf.demo.apiauth.controller;

import com.rdbf.demo.apiauth.controller.form.UserForm;
import com.rdbf.demo.apiauth.repository.PeopleRepository;
import com.rdbf.demo.apiauth.service.SampleService;
import com.rdbf.demo.apiauth.support.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rdbf.demo.apiauth.service.SampleService;

import javax.validation.Valid;

@RestController
public class SampleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);
    private final SampleService sampleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }



    @GetMapping(value = "/public")
    public String publicApi() {
        return "this is public";
    }

    @GetMapping(value = "/private")
    public String privateApi() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // JWTAuthenticationFilter#successfulAuthenticationで設定したusernameを取り出す
        String username = (String) (authentication.getPrincipal());

        return "this is private for " + username;
    }


    @PostMapping(value = SecurityConstants.SIGNUP_URL)
    public void signup(@Valid @RequestBody UserForm user) {

        // passwordを暗号化する
        user.encrypt(bCryptPasswordEncoder);

        // DBに保存する処理を本来は書く
        LOGGER.info("signup :" + user.toString());
        sampleService.createAccount(user.getLoginId(),user.getPassword());
    }

}
