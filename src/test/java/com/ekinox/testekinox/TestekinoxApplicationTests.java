package com.ekinox.testekinox;

import com.ekinox.testekinox.application.request.Panier;
import com.ekinox.testekinox.application.service.CountArticle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestekinoxApplicationTests {

    @Autowired
    CountArticle countArticle;

    @Test
    void contextLoads() {
    }

    String sousChaine = "Back to the Future";

    @Test
    public void WhenGetEmptyBillThenGet_0(){
        Panier panier = new Panier();
        panier.setPanier("");
        int bill = countArticle.getAmountArticle(panier, sousChaine);

        assertEquals(0, bill);
    }


    @Test
    public void WhenGet3ArticleThenGet_36(){
        Panier panier = new Panier();
        panier.setPanier("Back to the Future 1\n" +
                "Back to the Future 2\n" +
                "Back to the Future 3\n");

        int bill = countArticle.getAmountArticle(panier, sousChaine);

        assertEquals(36, bill);
    }

    @Test
    public void WhenGet2ArticleThenGet_27(){
        Panier panier = new Panier();
        panier.setPanier("Back to the Future 1\n" +
                "Back to the Future 3\n");

        int bill = countArticle.getAmountArticle(panier, sousChaine);

        assertEquals(27, bill);
    }

    @Test
    public void WhenGet1ArticleThenGet_15(){
        Panier panier = new Panier();
        panier.setPanier("Back to the Future 1\n");

        int bill = countArticle.getAmountArticle(panier, sousChaine);

        assertEquals(15, bill);
    }

    @Test
    public void WhenGet3ArticleAnd1FilmThenGet_56(){
        Panier panier = new Panier();
        panier.setPanier("Back to the Future 1\n" +
                "Back to the Future 2\n" +
                "Back to the Future 3\n" +
                "La chèvre\n");

        int bill = countArticle.getAmountArticle(panier, sousChaine);

        assertEquals(56, bill);
    }


}
