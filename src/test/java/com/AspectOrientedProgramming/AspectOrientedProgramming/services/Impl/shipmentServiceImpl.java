package com.AspectOrientedProgramming.AspectOrientedProgramming.services.Impl;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class shipmentServiceImpl {
    @Autowired
    private shipmentServiceImp shipmentServiceImp;

    @Test
    void aopTestOrderPackage(){
        String ordertrack=shipmentServiceImp.OrderPackage(1L);
        log.info(ordertrack);
    }

    @Test
    void aopTestTrackPackage(){
        shipmentServiceImp.TrackPackage(1L);

    }
}
