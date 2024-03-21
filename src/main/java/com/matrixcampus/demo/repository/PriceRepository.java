package com.matrixcampus.demo.repository;

import com.matrixcampus.demo.model.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

    @Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brandId = :brandId AND startDate <= :applicationDate AND endDate >= :applicationDate")
    List<Price> findByApplicationDate(@Param("productId") Long productId , @Param("brandId") Long brandId, @Param("applicationDate") LocalDateTime applicationDate);

}
