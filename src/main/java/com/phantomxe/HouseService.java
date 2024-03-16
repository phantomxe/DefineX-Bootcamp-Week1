package com.phantomxe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List; 
import java.util.OptionalDouble; 
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HouseService {
    private List<House> houseList;
    private List<Villa> villaList;
    private List<Summery> summeryList;

    public HouseService() {
        houseList = new ArrayList<>();
        villaList = new ArrayList<>();
        summeryList = new ArrayList<>();

        //Each of them must me have at least 3 samples
        houseList.add(new House(BigDecimal.valueOf(1000000), 80, 2, 1));
        houseList.add(new House(BigDecimal.valueOf(1500000), 110, 3, 1));
        houseList.add(new House(BigDecimal.valueOf(1800000), 120, 3, 1));

        villaList.add(new Villa(BigDecimal.valueOf(2900000), 181, 4, 1));
        villaList.add(new Villa(BigDecimal.valueOf(3500000), 200, 5, 1));
        villaList.add(new Villa(BigDecimal.valueOf(12000000), 400, 6, 2));

        summeryList.add(new Summery(BigDecimal.valueOf(2000000), 100, 2, 1));
        summeryList.add(new Summery(BigDecimal.valueOf(2500000), 150, 2, 1));
        summeryList.add(new Summery(BigDecimal.valueOf(3000000), 170, 2, 1));
    }    

    public BigDecimal getTotalHousePrices() {
        return houseList.stream().map(AbstractHouse::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalVillaPrices() {
        return villaList.stream().map(AbstractHouse::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalSummeryPrices() {
        return summeryList.stream().map(AbstractHouse::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalPrices() {
        return getTotalHousePrices().add(getTotalVillaPrices()).add(getTotalSummeryPrices());
    }

    public Double getAvgHouseArea() {
        OptionalDouble result = houseList.stream().mapToInt(AbstractHouse::getTotalArea).average();
        if(result.isPresent()) {
            return result.getAsDouble();
        } else {
            return 0.0;
        }
    }

    public Double getAvgVillaArea() {
        OptionalDouble result = villaList.stream().mapToInt(AbstractHouse::getTotalArea).average();
        if(result.isPresent()) {
            return result.getAsDouble();
        } else {
            return 0.0;
        }
    }

    public Double getAvgSummeryArea() {
        OptionalDouble result = summeryList.stream().mapToInt(AbstractHouse::getTotalArea).average();
        if(result.isPresent()) {
            return result.getAsDouble();
        } else {
            return 0.0;
        }
    }

    public Double getAvgArea() {
        return (getAvgHouseArea() + getAvgVillaArea() + getAvgSummeryArea()) / 3;
    }

    public List<AbstractHouse> getHouse(Integer numberOfRooms, Integer numberOfSaloons) {
        Stream<AbstractHouse> myHouses = houseList.stream()
                    .filter(house -> house.getNumberOfRooms().equals(numberOfRooms) && house.getNumberOfSaloons().equals(numberOfSaloons))
                    .map(house -> (AbstractHouse) house);

        Stream<AbstractHouse> myVillas = villaList.stream()
                    .filter(villa -> villa.getNumberOfRooms().equals(numberOfRooms) && villa.getNumberOfSaloons().equals(numberOfSaloons))
                    .map(villa -> (AbstractHouse) villa);
        
        Stream<AbstractHouse> mySummerys = summeryList.stream()
                    .filter(summery -> summery.getNumberOfRooms().equals(numberOfRooms) && summery.getNumberOfSaloons().equals(numberOfSaloons))
                    .map(summery -> (AbstractHouse) summery);

        return Stream.concat(Stream.concat(myHouses, myVillas), mySummerys).collect(Collectors.toList());
    }
}
