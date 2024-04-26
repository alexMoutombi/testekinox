package com.ekinox.testekinox.application.service;

import com.ekinox.testekinox.application.request.Panier;

public interface CountArticle {

    public int getNombreBackToFuture(String panier, String sousChaine);

    public int getNombreTotalArticle(String panier);

    public int getAmountArticle(Panier panier, String sousChaine);
}
