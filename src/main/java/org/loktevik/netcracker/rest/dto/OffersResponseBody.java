package org.loktevik.netcracker.rest.dto;

import lombok.Data;

@Data
public class OffersResponseBody {
    private OfferDto[] offers;
    private CategoryDto[] categories;
}
