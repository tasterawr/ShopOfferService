package org.loktevik.netcracker.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.message.FormattedMessage;
import org.loktevik.netcracker.domain.Offer;
import org.loktevik.netcracker.repository.OfferRepository;
import org.loktevik.netcracker.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final Logger log = Logger.getLogger(OfferServiceImpl.class);
    private final OfferRepository offerRepo;

    @Override
    public Offer getById(Long id) {
        log.info(new FormattedMessage("Getting offer with id: {}.", id));
        return offerRepo.getById(id);
    }

    @Override
    public List<Offer> getAll() {
        log.info("Getting all offers.");
        return offerRepo.findAll();
    }

    @Override
    public Offer saveOffer(Offer offer) {
        log.info(new FormattedMessage("Saving offer \"{}\".", offer.getName()));
        return offerRepo.save(offer);
    }

    @Override
    public Offer updateOffer(Offer offer) {
        log.info(new FormattedMessage("Updating offer with id: {}.", offer.getId()));
        return saveOffer(offer);
    }

    @Override
    public void deleteById(Long id) {
        log.info(new FormattedMessage("Deleting offer with id: {}.", id));
        offerRepo.deleteById(id);
    }
}
