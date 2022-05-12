package org.loktevik.netcracker.service;

import org.loktevik.netcracker.domain.Offer;

import java.util.List;

/**
 * Service interface for Offer model.
 */
public interface OfferService {

    /**
     * Finds offer by specified id.
     * @param id id of offer
     * @return instance of offer with specified id.
     */
    Offer getById(Long id);

    /**
     * Finds all offers in the database.
     * @return List of offers from the database.
     */
    List<Offer> getAll();

    /**
     * Saves new or updates existing offer in the database.
     * @param offer instance of new or existing offer.
     * @return created or updated offer.
     */
    Offer saveOffer(Offer offer);

    /**
     * Updates offer in the database.
     * @param offer instance of offer to update.
     * @return updated offer.
     */
    Offer updateOffer(Offer offer);

    /**
     * Deletes offer with specified id.
     * @param id id of offer.
     */
    void deleteById(Long id);
}
