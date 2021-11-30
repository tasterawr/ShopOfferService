package org.loktevik.netcracker.rest.classes;

import lombok.Data;

@Data
public class OfferResponse {
    private Long id;
    private String name;
    private Double price;
    private int paidTypeId;
    private String category;
    private String[] characteristics;
}
