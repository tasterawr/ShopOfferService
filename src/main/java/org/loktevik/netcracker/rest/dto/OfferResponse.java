package org.loktevik.netcracker.rest.dto;

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
