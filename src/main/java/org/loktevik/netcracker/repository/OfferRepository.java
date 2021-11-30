package org.loktevik.netcracker.repository;

import org.loktevik.netcracker.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    Offer getById(Long aLong);

    List<Offer> findAll();

    Offer save(Offer offer);

    void deleteById(Long id);
}
