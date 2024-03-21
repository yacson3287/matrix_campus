package com.matrixcampus.demo.controller;

import com.matrixcampus.demo.controller.dto.PriceDTO;
import com.matrixcampus.demo.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("find-by-application-date/{date}/{productId}/{brandId}")
    public PriceDTO findByApplicationDate(@PathVariable("date") LocalDateTime applicationDate, @PathVariable("productId") Long productId, @PathVariable("brandId") Long brandId) {
        return PriceDTO.convertFromEntity(priceService.findByApplicationDate(productId, brandId, applicationDate));
    }

}
