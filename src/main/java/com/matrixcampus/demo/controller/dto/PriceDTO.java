package com.matrixcampus.demo.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.matrixcampus.demo.model.Price;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PriceDTO {

    private Long productId;

    private Long brandId;

    private Long priceList;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    private float price;


    public static PriceDTO convertFromEntity(Price price) {
        return PriceDTO.builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice())
                .build();
    }
}
