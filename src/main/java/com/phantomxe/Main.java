package com.phantomxe;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HouseService houseService = new HouseService();

        System.out.println("Total House Prices: " + houseService.getTotalHousePrices() + " TL");
        System.out.println("Total Villa Prices: " + houseService.getTotalVillaPrices() + " TL");
        System.out.println("Total Summery Prices: " + houseService.getTotalSummeryPrices() + " TL");
        System.out.println("Total Prices: " + houseService.getTotalPrices() + " TL");
        System.out.println();

        System.out.println("Average House Area: " + String.format("%.2f m2", houseService.getAvgHouseArea()));
        System.out.println("Average Villa Area: " + String.format("%.2f m2", houseService.getAvgVillaArea()));
        System.out.println("Average Summery Area: " + String.format("%.2f m2", houseService.getAvgSummeryArea()));
        System.out.println("Average Area: " + String.format("%.2f m2", houseService.getAvgArea()));
        System.out.println();

        // Get some houses based on room and saloon count
        List<AbstractHouse> houseList = houseService.getHouse(2, 1);
        System.out.println("Houses with 2+1");
        houseList.stream().forEach(house -> {
            System.out.println("House type: " + house.getClass().getSimpleName());
            System.out.println("Price: " + house.getPrice() + " TL");
            System.out.println("Total Area: " + house.getTotalArea() + " m2"); 
        });
        System.out.println();

        List<AbstractHouse> houseList2 = houseService.getHouse(3, 1);
        System.out.println("Houses with 3+1");
        houseList2.stream().forEach(house -> {
            System.out.println("House type: " + house.getClass().getSimpleName());
            System.out.println("Price: " + house.getPrice() + " TL");
            System.out.println("Total Area: " + house.getTotalArea() + " m2"); 
        });
        System.out.println();

        List<AbstractHouse> houseList3 = houseService.getHouse(6, 2);
        System.out.println("Houses with 6+2");
        houseList3.stream().forEach(house -> {
            System.out.println("House type: " + house.getClass().getSimpleName());
            System.out.println("Price: " + house.getPrice() + " TL");
            System.out.println("Total Area: " + house.getTotalArea() + " m2"); 
        });
    }
}