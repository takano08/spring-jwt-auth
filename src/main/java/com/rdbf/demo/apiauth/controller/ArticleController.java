package com.rdbf.demo.apiauth.controller;

import com.rdbf.demo.apiauth.controller.form.UserForm;
import com.rdbf.demo.apiauth.domain.Article;
import com.rdbf.demo.apiauth.domain.People;
import com.rdbf.demo.apiauth.service.SampleService;
import com.rdbf.demo.apiauth.support.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.rdbf.demo.apiauth.repository.ArticleRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ArticleController {

    private final ArticleRepository articleRepository;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }





    @GetMapping(value = "/article")
    List<Article> findAll() {
        return articleRepository.findAll();
    }

    @GetMapping(value = "/article/{id}")
    Article one(@PathVariable Long id) {

        return articleRepository.findByArticleId(id);
    }






}
