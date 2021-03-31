package by.shpak.laba1.service;

import org.springframework.stereotype.Service;

@Service
public class CylinderService {
    public double calculateVolume(double radius, double height) {
        return 3.14*Math.pow(radius,2)*height;
    }
}
