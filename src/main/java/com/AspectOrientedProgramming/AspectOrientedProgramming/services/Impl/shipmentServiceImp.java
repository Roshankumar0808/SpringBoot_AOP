package com.AspectOrientedProgramming.AspectOrientedProgramming.services.Impl;

import com.AspectOrientedProgramming.AspectOrientedProgramming.services.shipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class shipmentServiceImp implements shipmentService {

    @Override
    public String OrderPackage(Long OrderId) {
      try{
          log.info("Processing The Order");
          Thread.sleep(1000);

      } catch (Exception e) {
         log.info("Error Occurred while processing ordered",e);
      }
      return "Order Processed Successfully,orderId"+OrderId;
    }

    @Override
    public String TrackPackage(Long OrderId) {
        try{
            log.info("Tracking The Order...");
            Thread.sleep(1000);
            throw new RuntimeException("Exception occurred during trackPackage");

        } catch (Exception e) {
           throw new RuntimeException(e);
        }

    }
}
