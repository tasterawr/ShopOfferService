package org.loktevik.netcracker.rest;

import lombok.RequiredArgsConstructor;
import org.loktevik.netcracker.domain.Category;
import org.loktevik.netcracker.domain.Characteristic;
import org.loktevik.netcracker.domain.Offer;
import org.loktevik.netcracker.rest.dto.*;
import org.loktevik.netcracker.service.CategoryService;
import org.loktevik.netcracker.service.CharacteristicService;
import org.loktevik.netcracker.service.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("offers")
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;
    private final CharacteristicService characteristicService;
    private final CategoryService categoryService;

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OfferDto> getOffer(@PathVariable Long id){
        Offer offer =offerService.getById(id);
        OfferDto dto = getOfferDto(offer);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(value="/full-info",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OffersResponseBody> getOffersInfo(@RequestBody CustomerPaidTypesDto paidtypes){
        OffersResponseBody responseBody = getOffersResponseBody(paidtypes.getPaidtypeIds());

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Offer>> getAll(){
        List<Offer> offers = offerService.getAll();

        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @GetMapping("/{id}/price")
    public ResponseEntity<String> getPrice(@PathVariable Long id){
        Offer offer = offerService.getById(id);

        return new ResponseEntity<>(offer.getPrice().toString(), HttpStatus.OK);
    }

    @GetMapping("/{id}/name")
    public ResponseEntity<String> getOfferName(@PathVariable Long id){
        Offer offer = offerService.getById(id);

        return new ResponseEntity<>(offer.getName(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Offer> addOffer(@RequestBody Offer offer,
                                          @RequestBody List<Characteristic> characteristics){
        characteristics.forEach(characteristicService::saveCharacteristic);
        offer.setCharacteristics(characteristics);

        return new ResponseEntity<>(offerService.saveOffer(offer), HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Offer> updateOffer(@RequestBody Offer offer){
        offerService.updateOffer(offer);

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteOffer(@PathVariable Long id){
        offerService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public OffersResponseBody getOffersResponseBody(Long [] paidtypes){
        List<Long> ids = Arrays.asList(paidtypes);
        OffersResponseBody responseBody = new OffersResponseBody();
        List<OfferDto> offerResponses = new ArrayList<>();
        List<CategoryDto> categoryResponses = new ArrayList<>();

        List<Offer> offers = offerService.getAll();
        List<Category> categories = categoryService.getAll();

        offers.stream()
                .filter(offer -> ids.contains(offer.getPaidTypeId()))
                .forEach(offer -> offerResponses.add(getOfferDto(offer)));

        categories
                .forEach(category -> {
                    CategoryDto response = new CategoryDto();
                    response.setId(category.getId());
                    response.setName(category.getName());

                    categoryResponses.add(response);
                });

        responseBody.setCategories(categoryResponses.toArray(new CategoryDto[0]));
        responseBody.setOffers(offerResponses.toArray(new OfferDto[0]));
        return responseBody;
    }

    public OfferDto getOfferDto(Offer offer){
        OfferDto dto = new OfferDto();
        dto.setId(offer.getId());
        dto.setName(offer.getName());
        dto.setPrice(offer.getPrice());
        dto.setPaidType(offer.getPaidTypeId().toString());
        dto.setCategory(offer.getCategory().getName());

        List<CharacteristicDto> characteristics = new ArrayList<>();

        offer.getCharacteristics().forEach(ch->{
            characteristics.add(new CharacteristicDto(ch.getId(), ch.getName(), ch.getDescription()));
        });
        dto.setCharacteristics(characteristics.toArray(new CharacteristicDto[0]));

        return dto;
    }
}
