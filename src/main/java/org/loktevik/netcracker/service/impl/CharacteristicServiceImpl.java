package org.loktevik.netcracker.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.message.FormattedMessage;
import org.loktevik.netcracker.domain.Characteristic;
import org.loktevik.netcracker.repository.CharacteristicRepository;
import org.loktevik.netcracker.service.CharacteristicService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service implementation class for Characteristic model. Implements methods from CharacteristicService.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CharacteristicServiceImpl implements CharacteristicService {
    private final Logger log = Logger.getLogger(CharacteristicServiceImpl.class);
    private final CharacteristicRepository characteristicRepo;

    @Override
    public Characteristic getById(Long id) {
        log.info(new FormattedMessage("Getting characteristic with id: {}.", id));
        return characteristicRepo.getById(id);
    }

    @Override
    public List<Characteristic> getAll() {
        log.info("Getting all characteristics.");
        return characteristicRepo.findAll();
    }

    @Override
    public Characteristic saveCharacteristic(Characteristic characteristic) {
        log.info(new FormattedMessage("Saving characteristic \"{}\".", characteristic.getName()));
        return characteristicRepo.save(characteristic);
    }

    @Override
    public Characteristic updateCharacteristic(Characteristic characteristic) {
        log.info(new FormattedMessage("Updating characteristic with id: {}.", characteristic.getId()));
        return saveCharacteristic(characteristic);
    }

    @Override
    public void deleteById(Long id) {
        log.info(new FormattedMessage("Deleting characteristic with id: {}.", id));
        characteristicRepo.deleteById(id);
    }
}
