package org.loktevik.netcracker.rest.classes;

import lombok.Data;

@Data
public class OffersResponseBody {
    private OfferResponse[] offers;
    private CategoryResponse[] categories;
}
