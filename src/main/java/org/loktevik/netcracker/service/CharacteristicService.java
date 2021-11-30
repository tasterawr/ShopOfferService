package org.loktevik.netcracker.service;

import org.loktevik.netcracker.domain.Characteristic;

import java.util.List;

public interface CharacteristicService {
    Characteristic getById(Long id);

    List<Characteristic> getAll();

    Characteristic saveCharacteristic(Characteristic characteristic);

    Characteristic updateCharacteristic(Characteristic characteristic);

    void deleteById(Long id);
}
