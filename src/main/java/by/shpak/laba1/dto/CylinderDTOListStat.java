package by.shpak.laba1.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "StatDTO")
public class CylinderDTOListStat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final int unique;
    private final double maxValue;
    private final double minValue;
    private final double average;

    public int getUnique() {
        return unique;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public CylinderDTOListStat() {
        unique = 1;
        maxValue = 1;
        minValue = 1;
        average = 1;
    }

    public void setCylinderDTOList(List<CylinderDTO> cylinderDTOList) {
        this.cylinderDTOList = cylinderDTOList;
    }

    public List<CylinderDTO> getCylinderDTOList() {
        return cylinderDTOList;
    }
    @OneToMany
    @JoinTable(
            name = "CylinderDTOStat",
            joinColumns = @JoinColumn(name = "CylinderDTO_id")
    )
    private List<CylinderDTO> cylinderDTOList;

    public CylinderDTOListStat(int unique, double maxValue, double minValue, double average, List<CylinderDTO> cylinderDTOList) {
        this.unique = unique;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.average = average;
        this.cylinderDTOList = cylinderDTOList;
    }
}
