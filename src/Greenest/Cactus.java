package Greenest;

public class Cactus extends Plant {

    final protected double mineralWaterNeeded = 0.02;

    public Cactus(String name, double height) {
        super(name, height);
        nutrition = NutritionEnum.MINERALVATTEN;
    }

    @Override
    public double calculateNutrition() {
        return mineralWaterNeeded;
    }

    @Override
    public String getNutritionType() {
        return nutrition.toString().toLowerCase();
    }

    @Override
    public String getClassNameToReadable() {
        return "Kaktus";
    }


}
