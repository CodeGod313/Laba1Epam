package by.shpak.laba1.dto;

import java.util.List;

public class CylinderDTOListStat {
    private final int unique;
    private final double maxValue;
    private final double minValue;
    private final double average;

    public int getUnique() {
        return unique;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getAverage() {
        return average;
    }

    public List<CylinderDTO> getCylinderDTOList() {
        return cylinderDTOList;
    }

    private List<CylinderDTO> cylinderDTOList;

    public CylinderDTOListStat(int unique, double maxValue, double minValue, double average, List<CylinderDTO> cylinderDTOList) {
        this.unique = unique;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.average = average;
        this.cylinderDTOList = cylinderDTOList;
    }
}
