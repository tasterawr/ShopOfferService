package org.loktevik.netcracker.service;

import org.loktevik.netcracker.domain.Characteristic;

import java.util.List;

/**
 * Service interface for Characteristic model.
 */
public interface CharacteristicService {

    /**
     * Finds characteristic with specified id.
     * @param id id of characteristic.
     * @return instance of characteristic with specified id.
     */
    Characteristic getById(Long id);

    /**
     * Finds all characteristic in the database.
     * @return all characteristics from the database.
     */
    List<Characteristic> getAll();

    /**
     * Saves new of updates existing characteristic.
     * @param characteristic instance of new or existing characteristic.
     * @return instance of saved or updated characteristic.
     */
    Characteristic saveCharacteristic(Characteristic characteristic);

    /**
     * Updates characteristic in the database.
     * @param characteristic instance of characteristic to update.
     * @return updated characteristic.
     */
    Characteristic updateCharacteristic(Characteristic characteristic);

    /**
     * Deletes characteristic with specified id.
     * @param id id of characteristic.
     */
    void deleteById(Long id);
}
