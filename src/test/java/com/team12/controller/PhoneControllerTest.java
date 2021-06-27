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
class PhoneControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;



    @Test
    void getPhones(){
       assertTrue(
                this.restTemplate.getForObject("http://localhost:" + port + "/getPhones", Product[].class)[0].getBrand().getBrandName().equals("Apple")

        );

        assertEquals(3, this.restTemplate.getForObject("http://localhost:" + port + "/getPhones", Product[].class).length);
        assertTrue(this.restTemplate.getForObject("http://localhost:"+port+"/getPhones",Product[].class)[0].getModel().equals("iPhone 12 Pro Max"));
        assertEquals(1,this.restTemplate.getForObject("http://localhost:"+port+"/getPhones", Product[].class)[0].getProductID());
    }

    @Test
    void getPhonesForSearch(){
        assertTrue(
                this.restTemplate.getForObject("http://localhost:" + port + "/getPhonesForSearch?brandName=Apple", Product[].class)[0].getBrand().getBrandName().equals("Apple")

        );
        assertTrue(
                this.restTemplate.getForObject("http://localhost:" + port + "/getPhonesForSearch?modelName=iPhone 12 Pro Max", Product[].class)[0].getModel().equals("iPhone 12 Pro Max")

        );
        assertEquals(1,this.restTemplate.getForObject("http://localhost:"+port+"/getPhonesForSearch?productID=1", Product[].class)[0].getProductID());
    }
}