package com.AspectOrientedProgramming.AspectOrientedProgramming.services;

public interface shipmentService {
    String OrderPackage(Long OrderId);
    String TrackPackage(Long OrderId);
}
