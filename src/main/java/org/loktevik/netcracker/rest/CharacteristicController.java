package org.loktevik.netcracker.rest;

import lombok.RequiredArgsConstructor;
import org.loktevik.netcracker.domain.Characteristic;
import org.loktevik.netcracker.service.CharacteristicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characteristics")
@RequiredArgsConstructor
public class CharacteristicController {
    private final CharacteristicService characteristicService;

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Characteristic> getCharacteristic(@PathVariable Long id){
        Characteristic characteristic =characteristicService.getById(id);

        return new ResponseEntity<>(characteristic, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Characteristic>> getAll(){
        List<Characteristic> characteristics = characteristicService.getAll();

        return new ResponseEntity<>(characteristics, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Characteristic> addCharacteristic(@RequestBody Characteristic characteristic){

        return new ResponseEntity<>(characteristicService.saveCharacteristic(characteristic), HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Characteristic> updateCharacteristic(@RequestBody Characteristic characteristic){
        characteristicService.updateCharacteristic(characteristic);

        return new ResponseEntity<>(characteristic, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCharacteristic(@PathVariable Long id){
        characteristicService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
