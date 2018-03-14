package com.codecool.shitwish.order.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class OrderControllerREST {

    @PutMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addProductToOrder(
            @PathVariable("id") Long userId){

    }
}
