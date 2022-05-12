package org.loktevik.netcracker;

import lombok.RequiredArgsConstructor;
import org.loktevik.netcracker.domain.Category;
import org.loktevik.netcracker.domain.Characteristic;
import org.loktevik.netcracker.domain.Offer;
import org.loktevik.netcracker.service.CategoryService;
import org.loktevik.netcracker.service.CharacteristicService;
import org.loktevik.netcracker.service.OfferService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    private final CategoryService categoryService;
    private final CharacteristicService characteristicService;
    private final OfferService offerService;

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Шоссейные");
        Category category2 = new Category(null, "Горные");
        categoryService.saveCategory(category1);
        categoryService.saveCategory(category2);

        Characteristic characteristic1 = new Characteristic(null,
                "Пол", "унисекс", new ArrayList<>());
        Characteristic characteristic2 = new Characteristic(null,
                "Возраст", "Для взрослых", new ArrayList<>());
        Characteristic characteristic3 = new Characteristic(null,
                "Материал рамы", "сталь", new ArrayList<>());
        Characteristic characteristic4 = new Characteristic(null,
                "Крепление колеса", "ось", new ArrayList<>());
        Characteristic characteristic5 = new Characteristic(null,
                "Количество скоростей", "1", new ArrayList<>());
        Characteristic characteristic6 = new Characteristic(null,
                "Вынос руля", "алюминий 6061, 6°", new ArrayList<>());
        Characteristic characteristic7 = new Characteristic(null,
                "Система", "Prowheel, 36/26Т", new ArrayList<>());
        Characteristic characteristic8 = new Characteristic(null,
                "Педали", "Cannondale Platform", new ArrayList<>());

        characteristicService.saveCharacteristic(characteristic1);
        characteristicService.saveCharacteristic(characteristic2);
        characteristicService.saveCharacteristic(characteristic3);
        characteristicService.saveCharacteristic(characteristic4);
        characteristicService.saveCharacteristic(characteristic5);
        characteristicService.saveCharacteristic(characteristic6);
        characteristicService.saveCharacteristic(characteristic7);
        characteristicService.saveCharacteristic(characteristic8);

        Offer offer1 = new Offer(null, "Шоссейный велосипед Outleap GREENWICH", 15520.0, 4L, category1, new ArrayList<>());
        Offer offer2 = new Offer(null, "Шоссейный велосипед Jamis BEATNIK", 33040.0, 4L, category1, new ArrayList<>());
        Offer offer3 = new Offer(null, "Горный велосипед Cannondale 29 TRAIL 5", 73200.0, 5L, category2, new ArrayList<>());

        offerService.saveOffer(offer1);
        offerService.saveOffer(offer2);
        offerService.saveOffer(offer3);

        offer1.getCharacteristics().add(characteristic1);
        offer1.getCharacteristics().add(characteristic2);
        offer1.getCharacteristics().add(characteristic3);
        offer1.getCharacteristics().add(characteristic4);
        offer1.getCharacteristics().add(characteristic5);

        offer2.getCharacteristics().add(characteristic1);
        offer2.getCharacteristics().add(characteristic2);
        offer2.getCharacteristics().add(characteristic3);
        offer2.getCharacteristics().add(characteristic4);
        offer2.getCharacteristics().add(characteristic5);

        offer3.getCharacteristics().add(characteristic1);
        offer3.getCharacteristics().add(characteristic2);
        offer3.getCharacteristics().add(characteristic6);
        offer3.getCharacteristics().add(characteristic7);
        offer3.getCharacteristics().add(characteristic8);

        offerService.saveOffer(offer1);
        offerService.saveOffer(offer2);
        offerService.saveOffer(offer3);
    }
}