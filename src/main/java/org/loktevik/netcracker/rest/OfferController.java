package org.loktevik.netcracker.rest;

import lombok.RequiredArgsConstructor;
import org.loktevik.netcracker.domain.Category;
import org.loktevik.netcracker.domain.Characteristic;
import org.loktevik.netcracker.domain.Offer;
import org.loktevik.netcracker.rest.classes.CategoryResponse;
import org.loktevik.netcracker.rest.classes.OfferResponse;
import org.loktevik.netcracker.rest.classes.OffersResponseBody;
import org.loktevik.netcracker.service.CategoryService;
import org.loktevik.netcracker.service.CharacteristicService;
import org.loktevik.netcracker.service.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("offers")
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;
    private final CharacteristicService characteristicService;
    private final CategoryService categoryService;

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Offer> getOffer(@PathVariable Long id){
        Offer offer =offerService.getById(id);

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @GetMapping(value="/full-info",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OffersResponseBody> getOffersFullInfo(){
        OffersResponseBody responseBody = getOffersResponseBody();

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Offer>> getAll(){
        List<Offer> offers = offerService.getAll();

        return new ResponseEntity<>(offers, HttpStatus.OK);
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

    public OffersResponseBody getOffersResponseBody(){
        OffersResponseBody responseBody = new OffersResponseBody();
        List<OfferResponse> offerResponses = new ArrayList<>();
        List<CategoryResponse> categoryResponses = new ArrayList<>();

        List<Offer> offers = offerService.getAll();
        List<Category> categories = categoryService.getAll();

        offers.stream()
                .forEach(offer -> {
                    OfferResponse response = new OfferResponse();
                    response.setId(offer.getId());
                    response.setName(offer.getName());
                    response.setPrice(offer.getPrice());
                    response.setPaidTypeId(offer.getPaidTypeId());
                    response.setCategory(offer.getCategory().getName());

                    String[] characteristics = offer.getCharacteristics().stream()
                                    .map(Characteristic::getName)
                                    .collect(Collectors.toList())
                                    .toArray(new String[0]);
                    response.setCharacteristics(characteristics);

                    offerResponses.add(response);
                });

        categories.stream()
                .forEach(category -> {
                    CategoryResponse response = new CategoryResponse();
                    response.setId(category.getId());
                    response.setName(category.getName());

                    categoryResponses.add(response);
                });

        responseBody.setCategories(categoryResponses.toArray(new CategoryResponse[0]));
        responseBody.setOffers(offerResponses.toArray(new OfferResponse[0]));
        return responseBody;
    }
}
