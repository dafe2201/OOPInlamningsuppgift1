package Greenest;

public class PalmTree extends Plant {

    final protected double tapWaterNeeded = 0.5;

    public PalmTree(String name, double height) {
        super(name, height);
        nutrition = NutritionEnum.KRANVATTEN;
    }

    @Override
    public double calculateNutrition() {
        return getHeight() * tapWaterNeeded;
    }

    // Abstract Metod som är dynamisk på alla subklasser, returnerar Nutrition-typ.
    @Override
    public String getNutritionType() {
        return nutrition.toString().toLowerCase();
    }

    @Override
    public String getClassNameToReadable() {
        return "Palm";
    }

}
