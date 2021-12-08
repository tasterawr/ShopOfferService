package org.loktevik.netcracker.rest.dto;

import lombok.Data;

@Data
public class OffersResponseBody {
    private OfferResponse[] offers;
    private CategoryResponse[] categories;
}
