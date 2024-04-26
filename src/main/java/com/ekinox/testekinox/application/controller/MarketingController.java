package com.ekinox.testekinox.application.controller;


import com.ekinox.testekinox.application.request.Panier;
import com.ekinox.testekinox.infrastructure.serviceImpl.CountArticleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MarketingController {

    @Autowired
    CountArticleImpl countArticle;

    @GetMapping("/bill")
    public ResponseEntity<?> getBill(@RequestBody Panier panier){

        String sousChaine = "Back to the Future";

        return new ResponseEntity<>(countArticle.getAmountArticle(panier, sousChaine), HttpStatus.OK);
    }
}
