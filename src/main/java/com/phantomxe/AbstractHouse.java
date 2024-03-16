package com.phantomxe;

import java.math.BigDecimal;

public abstract class AbstractHouse {
    private BigDecimal price;
    private Integer totalArea;
    private Integer numberOfRooms;
    private Integer numberOfSaloons;


    public AbstractHouse(BigDecimal price, Integer totalArea, Integer numberOfRooms, Integer numberOfSaloons) {
        this.price = price;
        this.totalArea = totalArea;
        this.numberOfRooms = numberOfRooms;
        this.numberOfSaloons = numberOfSaloons;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Integer totalArea) {
        this.totalArea = totalArea;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfSaloons() {
        return numberOfSaloons;
    }

    public void setNumberOfSaloons(Integer numberOfSaloons) {
        this.numberOfSaloons = numberOfSaloons;
    }

    
}
