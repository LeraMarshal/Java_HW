package de.marshal.growing_plants;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    private List<Plant> plants = new ArrayList<>();

    public Garden(List<Plant> plants) {
        this.plants.addAll(plants);
    }

    public void yearHasPassed(){

        growPlants(Season.SPRING);
        growPlants(Season.SUMMER);
        growPlants(Season.AUTUMN);
        growPlants(Season.WINTER);
    }

    private void growPlants(Season season){
        System.out.println(season + " has passed.");
        for (Plant plant : plants) {
            plant.grow(season);
        }
        System.out.println(plants);
    }
}
