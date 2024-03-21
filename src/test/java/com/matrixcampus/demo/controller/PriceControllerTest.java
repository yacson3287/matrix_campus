package com.matrixcampus.demo.controller;

import com.matrixcampus.demo.controller.dto.PriceDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerTest {

    @Autowired
    private TestRestTemplate client;

    @Test
    public void test1() {
        var response = client.getForEntity("/price/find-by-application-date/2020-06-14T10:00:00.000/35455/1", PriceDTO.class);
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getPriceList());
    }

    @Test
    public void test2() {
        var response = client.getForEntity("/price/find-by-application-date/2020-06-14T16:00:00.000/35455/1", PriceDTO.class);
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().getPriceList());
    }

    @Test
    public void test3() {
        var response = client.getForEntity("/price/find-by-application-date/2020-06-14T21:00:00.000/35455/1", PriceDTO.class);
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getPriceList());
    }

    @Test
    public void test4() {
        var response = client.getForEntity("/price/find-by-application-date/2020-06-15T10:00:00.000/35455/1", PriceDTO.class);
        assertNotNull(response.getBody());
        assertEquals(3, response.getBody().getPriceList());
    }

    @Test
    public void test5() {
        var response = client.getForEntity("/price/find-by-application-date/2020-06-16T21:00:00.000/35455/1", PriceDTO.class);
        assertNotNull(response.getBody());
        assertEquals(4, response.getBody().getPriceList());
    }


}