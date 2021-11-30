package org.loktevik.netcracker.repository;

import org.loktevik.netcracker.domain.Characteristic;
import org.loktevik.netcracker.domain.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {
    Characteristic getById(Long aLong);

    List<Characteristic> findAll();

    Characteristic save(Characteristic characteristic);

    void deleteById(Long id);
}
