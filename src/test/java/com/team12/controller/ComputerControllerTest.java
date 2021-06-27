package com.team12.controller;

import com.team12.WebServiceApplication;

import com.team12.entity.Product;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = WebServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComputerControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;



    @Test
    void getComputers(){
        assertTrue(
                this.restTemplate.getForObject("http://localhost:" + port + "/getComputers", Product[].class)[0].getBrand().getBrandName().equals("Asus")

        );
        assertEquals(4,this.restTemplate.getForObject("http://localhost:"+port+"getComputers",Product[].class).length);
    }

    @Test
    void getComputersForSearch(){

        assertTrue(
                this.restTemplate.getForObject("http://localhost:" + port + "/getComputerForSearch?modelName=GL 702VMK", Product[].class)[0].getModel().equals("GL 702VMK")

        );
        assertEquals(7,this.restTemplate.getForObject("http://localhost:"+port+"getComputerForSearch?productID=7",Product[].class)[0].getProductID());


    }




}