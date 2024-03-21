package com.matrixcampus.demo.service.impl;

import com.matrixcampus.demo.exeptions.BadRequestException;
import com.matrixcampus.demo.exeptions.InternalServerErrorException;
import com.matrixcampus.demo.model.Price;
import com.matrixcampus.demo.repository.PriceRepository;
import com.matrixcampus.demo.service.PriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Override
    public Price findByApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate) {

        try {

            var prices = priceRepository.findByApplicationDate(productId, brandId, applicationDate);
            return disambiguator(prices);

        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            throw new InternalServerErrorException("An unexpected error occurred");
        }

    }

    private Price disambiguator(List<Price> prices) {

        if (prices.isEmpty()) {
            throw new BadRequestException("no element found");
        }

        var optionalPrice = prices.stream().max(Comparator.comparing(Price::getPriority));

        if (optionalPrice.isPresent()) {
            return optionalPrice.get();
        }

        throw new BadRequestException("no element found");


    }
}
