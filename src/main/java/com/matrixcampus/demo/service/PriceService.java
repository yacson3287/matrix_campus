package com.matrixcampus.demo.service;

import com.matrixcampus.demo.model.Price;

import java.time.LocalDateTime;

public interface PriceService {

    Price findByApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate);
}
