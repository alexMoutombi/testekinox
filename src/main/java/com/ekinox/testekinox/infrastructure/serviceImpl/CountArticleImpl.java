package com.ekinox.testekinox.infrastructure.serviceImpl;

import com.ekinox.testekinox.application.request.Panier;
import com.ekinox.testekinox.application.service.CountArticle;
import org.springframework.stereotype.Service;

@Service
public class CountArticleImpl implements CountArticle {
    @Override
    public int getNombreBackToFuture(String panier, String sousChaine) {

        // Diviser le texte en lignes en utilisant le caractère de saut de ligne (\n)
        String[] lignes = panier.split("\n");
        int compteur = 0;
        // Parcourir chaque ligne et incrémenter le compteur si la ligne contient Back to the Future
        for (String ligne : lignes) {
            if (ligne.contains(sousChaine)) {
                compteur++;
            }
        }
        // Retourner le nombre de lignes contenant Back to the Future
        return compteur;
    }

    @Override
    public int getNombreTotalArticle(String panier) {
        // Diviser le texte en lignes en utilisant le caractère de saut de ligne (\n)
        String[] lignes = panier.split("\n");
        // Retourner le nombre de lignes non vides
        int nbLines = 0;
        for(String ligne : lignes){
            if(!ligne.trim().isEmpty()){
                nbLines++;
            }
        }

        return nbLines;
    }

    @Override
    public int getAmountArticle(Panier panier, String sousChaine) {

        int dvd = getNombreBackToFuture(panier.getPanier(), sousChaine);
        int films = getNombreTotalArticle(panier.getPanier()) - dvd;

        return switch (dvd) {
            case 0 -> films * 20;
            case 1 -> dvd * 15 + films * 20;
            case 2 -> (int) (dvd * 15 * 0.90) + (films * 20);
            default -> (int) (dvd * 15 * 0.80) + (films * 20);
        };
    }
}
