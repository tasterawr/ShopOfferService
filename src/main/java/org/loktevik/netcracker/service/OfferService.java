package org.loktevik.netcracker.service;

import org.loktevik.netcracker.domain.Offer;

import java.util.List;

public interface OfferService {
    Offer getById(Long id);

    List<Offer> getAll();

    Offer saveOffer(Offer offer);

    Offer updateOffer(Offer offer);

    void deleteById(Long id);
}
