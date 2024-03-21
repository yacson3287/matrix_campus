package com.matrixcampus.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long brandId;

    private Date startDate;

    private Date endDate;

    private Long priceList;

    private Long productId;

    private Integer priority;

    private float price;

    private String currency;

}

